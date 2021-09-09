package com.overactive.javier.assessment.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.overactive.javier.assessment.model.dto.CustomerDto;
import com.overactive.javier.assessment.model.entity.Customer;
import com.overactive.javier.assessment.model.service.interfaces.ICustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/last-quarter")
	public List<CustomerDto> lastQuarterRewards(){	
		return customerService.lastQuarterRewards();
	}

	@GetMapping("/range")
	public List<CustomerDto> rewardsInRangeDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date initDate,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){		
		return customerService.customerRewards(initDate, endDate);
	}
	
	@GetMapping("/")
	public List<Customer> findAll(){
		return customerService.findAll();
	}
	
	@PostMapping("/")
	public Customer save(@RequestBody Customer customer) {
		return customerService.save(customer);
	}
	
}
