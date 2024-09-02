package com.fds.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fds.exception.CustomerNotFoundException;
import com.fds.exception.SuccessResponse;
import com.fds.model.Customers;
import com.fds.model.Restaurants;
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
	
//	@RequestMapping(value="", method=RequestMethod.GET)
//	public ResponseEntity<List<Customers>> getAllCustomer(){
//		List<Customers> customerList = customers_service.getAllCustomers();
//		if(customerList.size() == 0) {
//			throw new CustomerNotFoundException("No Customer exist.");
//		}
//		return new ResponseEntity<List<Customers>>(customerList, HttpStatus.OK);
//	}
	
//	//pankaj delete customer by Id
//	@RequestMapping(value="/{customerId}", method=RequestMethod.DELETE)
//	public ResponseEntity<SuccessResponse> deleteCustomerById(@PathVariable("customerId") int customer_id) {
//		Customers customer = customers_service.deleteCustomerById(customer_id);
//
//		if(customer == null) {
//			throw new CustomerNotFoundException("Customer with the id : "+customer_id+" dosen't exist.");
//		}
//		SuccessResponse response = new SuccessResponse("DELETESUCCESS", "Customer deleted successfully");
//		
//		return new ResponseEntity<SuccessResponse>(response, HttpStatus.OK);
//	}
	
	// method to get all the reviews of the specific customer
	@RequestMapping(value="/{customerId}/reviews", method=RequestMethod.GET)
	public ResponseEntity<List<String>> getRatingsCustomer(@PathVariable("customerId") int customer_id) {
		List<String> reviews = customers_service.getRatingsByCustomer(customer_id);
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{customerId}/favorites", method=RequestMethod.GET)
	public ResponseEntity<Restaurants> getCustomerFavouriteRestaurant(@PathVariable("customerId") int customerId){
		Restaurants restaurant = customers_service.getFavouriteRestaurantOfCustomer(customerId);
		return new ResponseEntity<Restaurants>(restaurant,HttpStatus.OK);
	}

}