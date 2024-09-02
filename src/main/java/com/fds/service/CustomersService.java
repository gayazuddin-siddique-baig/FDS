package com.fds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fds.exception.CustomerNotFoundException;
import com.fds.exception.OrderNotFoundException;
import com.fds.model.Customers;
import com.fds.model.Orders;
import com.fds.model.Ratings;
import com.fds.model.Restaurants;
import com.fds.repository.CustomersRepository;
import com.fds.repository.RestaurantsRepository;

@Service
public class CustomersService {

	@Autowired
	private RestaurantsRepository restaurants_repository;

	@Autowired
	private CustomersRepository customers_repository;
	
	// method to get all the customers
	public List<Customers> getAllCustomers() {
		List<Customers> customers = customers_repository.findAll();
		
		// throw exception if no customer is found
		if(customers.isEmpty()) throw new CustomerNotFoundException("Customers list is empty", "GETALLFAILS");
		
		return customers;
	}
	
	// method to get the specific customer
	public Customers getSpecificCustomerById(int customer_id) {
		Customers customer = customers_repository.findById(customer_id).orElse(null);
		
		// throw exception if the customer is not found
		if(customer == null) throw new CustomerNotFoundException("No customer found with id: " +customer_id, "GETFAILS");
		
		return customer;
	}
	
	// method to get all the reviews of the specific customer
	public List<String> getReviewsOfSpecificCustomer(int customer_id) {
		List<String> reviews = new ArrayList<>();
		
		Customers customer = customers_repository.findById(customer_id).orElse(null);
		if(customer == null) throw new CustomerNotFoundException("Customer not found with id: " +customer_id, "GETALLFAILS");
		
		List<Orders> orders = customer.getOrders();
		// throw exception if the list of orders is empty
		if(orders.isEmpty()) throw new OrderNotFoundException("Orders list is empty", "GETALLFAILS");
		
		for(Orders o : orders) {
			List<Ratings> ratings = o.getRatings();
			for(Ratings r : ratings) reviews.add(r.getReview());
		}
		
		return reviews;
	}
	
	// method to get favrite restaurant of a customer
	public Restaurants getFavouriteRestaurantOfCustomer(int customerId) {
		Customers customer = customers_repository.findById(customerId).orElse(null);
		if(customer == null) {
			throw new CustomerNotFoundException("No customer found with id: " + customerId, "GETFAILS");
		}
		return restaurants_repository.getFavouriteRestaurantOfCustomer(customerId);
	}


	// method to delete the specific customer
	public void deleteSpecificCustomerById(int customer_id) {
		Customers customer = customers_repository.findById(customer_id).orElse(null);
		
		// throw exception if the customer is not found
		if(customer == null) throw new CustomerNotFoundException("Customer not found with id: " +customer_id, "DELETEFAILS");
		
		customers_repository.deleteById(customer_id);
	}
}