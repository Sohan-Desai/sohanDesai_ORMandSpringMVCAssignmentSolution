package com.greatlearning.customerrelations.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.customerrelations.entity.Customer;

@Service
public interface CustomerService {

	List<Customer> findAll();

	Customer findById(int id);

	void save(Customer customer3);

	void deleteById(int id);

}
