package com.overactive.javier.assessment.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a way to calculate reward points
 * 
 * @author Javier Agredo
 *
 */
@Entity
@Table(name = "strategies")
public class Strategy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2979908194733589510L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "strategy_id")
	private Long id;

	@Column(name = "lower_limit")
	private Double lowerLimit;

	@Column(name = "upper_limit")
	private Double upperLimit;

	private int points;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLowerLimit() {
		return lowerLimit;
	}

	public void setLowerLimit(Double lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	public Double getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(Double upperLimit) {
		this.upperLimit = upperLimit;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
