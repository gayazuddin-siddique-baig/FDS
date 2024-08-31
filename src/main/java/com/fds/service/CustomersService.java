package com.fds.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fds.exception.CustomerNotFoundException;
import com.fds.model.Customers;
import com.fds.model.Orders;
import com.fds.model.Ratings;
import com.fds.repository.CustomersRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomersService {

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
	

	
	public List<String>getRatingsByCustomer(int customerId){
		List<String> reviewList=new ArrayList<>();
		Customers cust= customers_repository.findById(customerId).get();
		List<Orders> order = cust.getOrders();
		for(Orders currentOrder:order) {
			List<Ratings> getRatingList=currentOrder.getRatings();
			for(Ratings currentRatings:getRatingList) {
				reviewList.add(currentRatings.getReview());
			}
		}
		return reviewList;
	}
	
	
}
