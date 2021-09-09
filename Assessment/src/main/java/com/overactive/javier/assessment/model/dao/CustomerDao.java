package com.overactive.javier.assessment.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.overactive.javier.assessment.model.entity.Customer;

public interface CustomerDao extends CrudRepository<Customer, Long> {

}
