package com.overactive.javier.assessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.overactive.javier.assessment.model.entity.Purchase;
import com.overactive.javier.assessment.model.service.interfaces.IPurchaseService;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

	@Autowired
	private IPurchaseService purchaseService;
	
	@GetMapping("/")
	public List<Purchase> findAll(){
		return purchaseService.findAll();
	}
	
	@GetMapping("/last-quarter")
	public List<Purchase> lastQuarterSales(){
		return purchaseService.lastQuarterSales();
	}
	
	
}
