package com.fds.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fds.model.Customers;
import com.fds.service.CustomersService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CustomersController {

	private CustomersService customers_service;
	
	@RequestMapping(value="/customers/{customerId}", method=RequestMethod.GET)
	public ResponseEntity<Customers> getCustomerById(@PathVariable("customerId") int customer_id) {
		Customers customer = customers_service.getCustomerById(customer_id);
		return new ResponseEntity<Customers>(customer, HttpStatus.OK);
	}
	
	@RequestMapping(value="/customers", method=RequestMethod.GET)
	public ResponseEntity<List<Customers>> getAllCustomer(){
		List<Customers> customerList = customers_service.getAllCustomers();
		return new ResponseEntity<List<Customers>>(customerList, HttpStatus.OK);
	}
	
	//pankaj delete customer by Id
	@RequestMapping(value="/customers/{customerId}", method=RequestMethod.DELETE)
	public ResponseEntity<Customers> deleteCustomerById(@PathVariable("customerId") int customer_id) {
		Customers customer = customers_service.deleteCustomerById(customer_id);
		return new ResponseEntity<Customers>(customer, HttpStatus.OK);
	}

	
}
