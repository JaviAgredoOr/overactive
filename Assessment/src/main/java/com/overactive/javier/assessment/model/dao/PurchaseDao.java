package com.overactive.javier.assessment.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.overactive.javier.assessment.model.entity.Purchase;

public interface PurchaseDao extends CrudRepository<Purchase, Long>{

	@Query(value = "SELECT p FROM Purchase p JOIN FETCH p.customer c WHERE p.date BETWEEN ?1 AND ?2 ORDER BY p.customerId, p.date")
	public List<Purchase> salesInDateRange(Date lowerDate, Date upperDate);
	
}

