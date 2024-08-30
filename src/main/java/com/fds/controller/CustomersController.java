package com.fds.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fds.model.Customers;
import com.fds.service.CustomersService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class CustomersController {

	private CustomersService customers_service;
	
	@RequestMapping(value="/{customerId}", method=RequestMethod.GET)
	public ResponseEntity<Customers> getCustomerById(@PathVariable("customerId") int customer_id) {
		Customers customer = customers_service.getCustomersById(customer_id);
		return new ResponseEntity<Customers>(customer, HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<List<Customers>> getAllCustomer(){
		List<Customers> customerList = customers_service.getAllCustomers();
		return new ResponseEntity<List<Customers>>(customerList, HttpStatus.OK);
	}
	
	//pankaj delete customer by Id
	@RequestMapping(value="/{customerId}", method=RequestMethod.DELETE)
	public ResponseEntity<Customers> deleteCustomerById(@PathVariable("customerId") int customer_id) {
		Customers customer = customers_service.deleteCustomerById(customer_id);
		return new ResponseEntity<Customers>(customer, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{customerId}/reviews", method=RequestMethod.GET)
	public ResponseEntity<List<String>> getRatingsCustomer(@PathVariable int customerId){
		List<String> ratings = customers_service.getRatingsByCustomer(customerId);
		return new ResponseEntity<>(ratings,HttpStatus.OK);
	}

	
}
