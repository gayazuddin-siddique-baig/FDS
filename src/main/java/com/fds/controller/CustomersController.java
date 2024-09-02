package com.fds.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fds.exception.SuccessResponse;
import com.fds.model.Customers;
import com.fds.model.Orders;
import com.fds.model.Restaurants;
import com.fds.service.CustomersService;

@RestController

@RequestMapping("/api/customers")
public class CustomersController {
	@Autowired
	private CustomersService customers_service;
	
	// method to get the specific customer
	@RequestMapping(value="/{customerId}", method=RequestMethod.GET)
	public ResponseEntity<Customers> getCustomerById(@PathVariable("customerId") int customer_id) {
		Customers customer = customers_service.getSpecificCustomerById(customer_id);
		return new ResponseEntity<Customers>(customer, HttpStatus.OK);
	}
	
	// method to get all the customers
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<List<Customers>> getAllCustomer() {
		List<Customers> customerList = customers_service.getAllCustomers();
		return new ResponseEntity<List<Customers>>(customerList, HttpStatus.OK);
	}
	
	// method to update a specific customer
    @RequestMapping(value="/{customerId}", method=RequestMethod.PUT)
    public ResponseEntity<SuccessResponse> updateCustomerById(
            @PathVariable("customerId") int customer_id, 
            @RequestBody Customers updatedCustomer) {
        customers_service.updateCustomerById(customer_id, updatedCustomer);
        SuccessResponse response = new SuccessResponse("UPDATESUCCESS", "Customer details updated successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

	//Retrieve all orders by specific customer

	//method to delete the specific customer
	@RequestMapping(value="/{customerId}", method=RequestMethod.DELETE)
	public ResponseEntity<SuccessResponse> deleteCustomerById(@PathVariable("customerId") int customer_id) {
		customers_service.deleteSpecificCustomerById(customer_id);
		SuccessResponse response = new SuccessResponse("DELETESUCCESS", "Customer deleted successfully");
		return new ResponseEntity<SuccessResponse>(response, HttpStatus.OK);
	}

	
	@RequestMapping(value="/{customerId}/orders", method=RequestMethod.GET)
    public ResponseEntity<List<Orders>> getAllOrdersByCustomerId(@PathVariable("customerId") int customerId) {
        List<Orders> orders = customers_service.getAllOrdersByCustomerId(customerId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

	// method to get all the reviews of the specific customer
	@RequestMapping(value="/{customerId}/reviews", method=RequestMethod.GET)
	public ResponseEntity<List<String>> getRatingsCustomer(@PathVariable("customerId") int customer_id) {
		List<String> reviews = customers_service.getReviewsOfSpecificCustomer(customer_id);
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}

	

	// method to get the favourite restaurant of the specific customer
	@RequestMapping(value="/{customerId}/favorites", method=RequestMethod.GET)
	public ResponseEntity<Restaurants> getCustomerFavouriteRestaurant(@PathVariable("customerId") int customerId){
		Restaurants restaurant = customers_service.getFavouriteRestaurantOfCustomer(customerId);
		return new ResponseEntity<Restaurants>(restaurant,HttpStatus.OK);
	}
}

