package com.fds.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomersService {
	@Autowired
	private RestaurantsRepository restaurants_repository;
	private CustomersRepository customers_repository;
	
	// method to get the specific customer
	public Customers getCustomersById(int customer_id) {
		Customers customer = customers_repository.findById(customer_id).orElse(null);
		if(customer == null) throw new CustomerNotFoundException("No customer found with id: " +customer_id, "GETFAILS");
		return customer;
	}
	
	public List<Customers> getAllCustomers(){
		return customers_repository.findAll();
	}
	
	public Customers deleteCustomerById(int customer_id) {
		Customers cust = customers_repository.findById(customer_id).orElse(null);
		if(cust == null) {return null;}
		customers_repository.deleteById(customer_id);
		return cust;
	}
	
	// method to get all the reviews of the specific customer
	public List<String> getRatingsByCustomer(int customer_id){
		List<String> reviews = new ArrayList<>();
		Customers customer = customers_repository.findById(customer_id).orElse(null);
		if(customer == null) throw new CustomerNotFoundException("Customer not found with id: " +customer_id, "GETALLFAILS");
		List<Orders> orders = customer.getOrders();
		if(orders.isEmpty()) throw new OrderNotFoundException("Orders list is empty", "GETALLFAILS");
		for(Orders o : orders) {
			List<Ratings> ratings = o.getRatings();
			for(Ratings r : ratings) reviews.add(r.getReview());
		}
		
		return reviews;
	}
	
	public Restaurants getFavouriteRestaurantOfCustomer(int customerId) {
		Customers customer = getCustomersById(customerId);
		if(customer == null) {
			throw new CustomerNotFoundException("No customer found with id: " + customerId, "GETFAILS");
		}
		return restaurants_repository.getFavouriteRestaurantOfCustomer(customerId);
	}


}