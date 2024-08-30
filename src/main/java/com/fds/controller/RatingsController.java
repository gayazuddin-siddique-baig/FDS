package com.fds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fds.model.Customers;
import com.fds.model.Ratings;
import com.fds.service.CustomersService;
import com.fds.service.RatingsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class RatingsController {
	
	@Autowired
	private RatingsService ratingsService;
	
	@Autowired
	private CustomersService customersService;
	
	@GetMapping("/customers/{customerId}/ratings")
	public ResponseEntity<List<Ratings>> getRatingsCustomer(@PathVariable int customerId){
		Customers customer = customersService.getCustomersById(customerId);
		List<Ratings>ratings = ratingsService.getRatingsByCustomer(customer);
		return new ResponseEntity<>(ratings,HttpStatus.OK);
	}
	

}
