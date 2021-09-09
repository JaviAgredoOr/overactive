package com.overactive.javier.assessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.overactive.javier.assessment.model.entity.Strategy;
import com.overactive.javier.assessment.model.service.interfaces.IStrategyService;

@RestController
@RequestMapping("/api/strategy")
public class StrategyController {
	
	@Autowired
	private IStrategyService strategyService;
	
	@GetMapping("/")
	private List<Strategy> findAll(){
		return strategyService.findAll();
	}

}
