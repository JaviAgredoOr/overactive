package com.overactive.javier.assessment.model.service.interfaces;

import java.util.Date;
import java.util.List;

import com.overactive.javier.assessment.model.dto.CustomerDto;
import com.overactive.javier.assessment.model.entity.Customer;

public interface ICustomerService {
	/**
	 * List all stored customers
	 * @return a list of {@link Customer}
	 */
	public List<Customer> findAll();

	/**
	 * Save a customer entity to the repository
	 * @param customer what will be saved
	 * @return a new customer entity
	 */
	public Customer save(Customer customer);

	/**
	 * Get the reward points of the last quarter for each customer
	 * 
	 * @return a listing of {@link CustomerDto}
	 */
	public List<CustomerDto> lastQuarterRewards();

	/**
	 * Get the reward points for each customer for a given date range
	 * 
	 * @param initDate range start date
	 * @param endDate  range end date
	 * @return a listing of {@link CustomerDto}
	 */
	public List<CustomerDto> customerRewards(Date initDate, Date endDate);
}
