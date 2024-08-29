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
	
	public Customers getCustomersById(int customer_id) {
		return customers_repository.getCustomersById(customer_id);
	}
	
	public List<Customers> getAllCustomers(){
		return customers_repository.findAll();
	}
	
	public Customers deleteCustomerById(int customer_id) {
		Customers cust = customers_repository.findByCustomerId(customer_id);
		customers_repository.deleteById(customer_id);
		return cust;
		
	}
}
