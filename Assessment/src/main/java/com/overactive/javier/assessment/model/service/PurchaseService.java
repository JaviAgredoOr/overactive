package com.overactive.javier.assessment.model.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overactive.javier.assessment.model.dao.PurchaseDao;
import com.overactive.javier.assessment.model.entity.Purchase;
import com.overactive.javier.assessment.model.service.interfaces.IPurchaseService;
import com.overactive.javier.assessment.util.DateUtils;

@Service
public class PurchaseService implements IPurchaseService {

	@Autowired
	private PurchaseDao purchaseDao;

	public List<Purchase> lastQuarterSales() {
		Date upperDate = new Date();
		Date lowerDate = DateUtils.substractMonths(upperDate, 3);

		return purchaseDao.salesInDateRange(lowerDate, upperDate);
	}

	public List<Purchase> salesInDateRange(Date lowerDate, Date upperDate) {
		return purchaseDao.salesInDateRange(lowerDate, upperDate);
	}

	@Override
	public List<Purchase> findAll() {
		return (List<Purchase>) purchaseDao.findAll();
	}

	@Override
	public Purchase save(Purchase purchase) {
		return purchaseDao.save(purchase);
	}

}
