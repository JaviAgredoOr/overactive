package com.overactive.javier.assessment.model.dto;

import java.util.List;

public class RewardModel {
	private List<CustomerDto> customers;
	private int total;

	public List<CustomerDto> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerDto> customers) {
		this.customers = customers;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
