package com.fds.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fds.model.Customers;
import com.fds.repository.CustomersRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomersService {

	private CustomersRepository customers_repository;
	
	public Customers getCustomerById(int customer_id) {
		return customers_repository.findByCustomerId(customer_id);
	}
}
