package com.overactive.javier.assessment.model.service.interfaces;

import java.util.Date;
import java.util.List;

import com.overactive.javier.assessment.model.entity.Purchase;

public interface IPurchaseService {

	public List<Purchase> findAll();
	
	public Purchase save(Purchase purchase);

	public List<Purchase> lastQuarterSales();
	
	public List<Purchase> salesInDateRange(Date lowerDate, Date upperDate);	
}
