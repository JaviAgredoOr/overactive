package com.overactive.javier.assessment.model.dto;

import java.util.Map;

import com.overactive.javier.assessment.model.entity.Customer;

/**
 * Represents the information of a client, the reward points for each month and
 * the total
 * 
 * @author Javier Agredo
 *
 */
public class CustomerDto {
	private Long id;
	private String name;
	private int points;
	private Map<String, Integer> pointsPerMonth;

	public CustomerDto(Customer customer) {
		this.id = customer.getId();
		this.name = customer.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Map<String, Integer> getPointsPerMonth() {
		return pointsPerMonth;
	}

	public void setPointsPerMonth(Map<String, Integer> pointsPerMonth) {
		this.pointsPerMonth = pointsPerMonth;
	}

}
