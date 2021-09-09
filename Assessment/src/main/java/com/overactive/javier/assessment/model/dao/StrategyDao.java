package com.overactive.javier.assessment.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.overactive.javier.assessment.model.entity.Strategy;

public interface StrategyDao extends CrudRepository<Strategy, Long>{
	
}
