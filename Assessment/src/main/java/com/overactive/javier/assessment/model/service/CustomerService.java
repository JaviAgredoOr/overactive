package com.overactive.javier.assessment.model.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overactive.javier.assessment.model.dao.CustomerDao;
import com.overactive.javier.assessment.model.dto.CustomerDto;
import com.overactive.javier.assessment.model.entity.Customer;
import com.overactive.javier.assessment.model.entity.Purchase;
import com.overactive.javier.assessment.model.entity.Strategy;
import com.overactive.javier.assessment.model.service.interfaces.ICustomerService;
import com.overactive.javier.assessment.model.service.interfaces.IPurchaseService;
import com.overactive.javier.assessment.model.service.interfaces.IStrategyService;
import com.overactive.javier.assessment.util.DateUtils;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private IStrategyService strategyService;

	@Autowired
	private IPurchaseService purchaseService;

	@Override
	public List<Customer> findAll() {
		return (List<Customer>) customerDao.findAll();
	}

	@Override
	public Customer save(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public List<CustomerDto> lastQuarterRewards() {
		Date endDate = new Date();
		Date initDate = DateUtils.substractMonths(endDate, 3);

		return customerRewards(initDate, endDate);
	}

	@Override
	public List<CustomerDto> customerRewards(Date initDate, Date endDate) {
		List<Strategy> strategies = strategyService.findAll();
		List<Purchase> purchases = purchaseService.salesInDateRange(initDate, endDate);

		calculatePoints(strategies, purchases);

		Map<Customer, Map<String, List<Purchase>>> customerPurchasesPerMonth = purchases.stream()
				.collect(Collectors.groupingBy(Purchase::getCustomer, Collectors.groupingBy(Purchase::getMonth)));

		return buildListCustomerDto(customerPurchasesPerMonth).stream().sorted(Comparator.comparingLong(CustomerDto::getId)).collect(Collectors.toList());
	}

	/**
	 * Calculate the reward points for each purchase according to existing
	 * strategies
	 * 
	 * @param strategies with which the reward is calculated
	 * @param purchases  to which the reward is calculated
	 */
	private void calculatePoints(List<Strategy> strategies, List<Purchase> purchases) {
		purchases.forEach(p -> p.setPoints(strategyService.calculatePoints(strategies, p.getTotal())));
	}

	/**
	 * Build a customer DTO
	 * 
	 * @param customerPurchasesPerMonth
	 * @return a listing of customerDTO
	 */
	private List<CustomerDto> buildListCustomerDto(
			Map<Customer, Map<String, List<Purchase>>> customerPurchasesPerMonth) {
		List<CustomerDto> customerDto = new ArrayList<CustomerDto>();

		customerPurchasesPerMonth.forEach((customer, map) -> {
			CustomerDto dto = new CustomerDto(customer);
			Map<String, Integer> pointsPerMonth = new HashMap<String, Integer>();
			map.forEach((month, list) -> {
				Integer po = list.stream().collect(Collectors.summingInt(Purchase::getPoints));
				pointsPerMonth.put(month, po);
				dto.setPoints(dto.getPoints() + po);
			});
			dto.setPointsPerMonth(pointsPerMonth);
			customerDto.add(dto);
		});

		return customerDto;
	}

}
