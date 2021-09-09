package com.overactive.javier.assessment.model.service.interfaces;

import java.util.List;

import com.overactive.javier.assessment.model.entity.Strategy;

/**
 * Provides services to manage strategies and calculate reward points
 * 
 * @author Javier Agredo
 *
 */
public interface IStrategyService {
	public List<Strategy> findAll();

	public Strategy save(Strategy strategy);

	/**
	 * Calculate the reward points according to the strategies and the value
	 * received
	 * 
	 * @param strategies list of strategies
	 * @param value      to whom the reward is calculated
	 * @return reward points
	 */
	public int calculatePoints(List<Strategy> strategies, double value);

	/**
	 * Calculate the reward points according to the strategy and the value received
	 * 
	 * @param strategy with which the reward is calculated
	 * @param value    to whom the reward is calculated
	 * @return reward points
	 */
	public int calculatePoints(Strategy strategy, double value);

}
