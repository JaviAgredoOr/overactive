package com.overactive.javier.assessment.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overactive.javier.assessment.model.dao.StrategyDao;
import com.overactive.javier.assessment.model.entity.Strategy;
import com.overactive.javier.assessment.model.service.interfaces.IStrategyService;

@Service
public class StrategyService implements IStrategyService {

	@Autowired
	private StrategyDao strategyDao;

	@Override
	public List<Strategy> findAll() {
		return (List<Strategy>) strategyDao.findAll();
	}

	@Override
	public Strategy save(Strategy strategy) {
		return strategyDao.save(strategy);
	}

	@Override
	public int calculatePoints(List<Strategy> strategies, double value) {
		int points = 0;
		for (Strategy strategy : strategies) {
			points += calculatePoints(strategy, value);
		}
		return points;
	}

	@Override
	public int calculatePoints(Strategy strategy, double value) {
		double result = 0;
		if (strategy.getLowerLimit() != null && strategy.getUpperLimit() == null) {
			// lower only
			result = value > strategy.getLowerLimit() ? value - strategy.getLowerLimit() : 0;
		} else if (strategy.getLowerLimit() != null && strategy.getUpperLimit() != null) {
			// range
			result = calcInRange(strategy, value);
		}
		return (int) (result * strategy.getPoints());
	}

	/**
	 * Calculate the amount on which the points will be applied
	 * 
	 * @param strategy containing the ranges to calculate the reward
	 * @param value    that is evaluated
	 * @return the new amount
	 */
	private double calcInRange(Strategy strategy, double value) {
		if (value <= strategy.getLowerLimit()) {
			return 0;
		}

		if (value > strategy.getUpperLimit()) {
			return strategy.getUpperLimit() - strategy.getLowerLimit();
		} else if (value < strategy.getUpperLimit()) {
			return value - strategy.getLowerLimit();
		}

		return 0;
	}

}
