package com.fds.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fds.exception.CustomerNotFoundException;
import com.fds.exception.OrderNotFoundException;
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
	
	//update deatails for specific customer
	public Customers updateCustomerById(int customer_id, Customers updatedCustomer) {
	    Customers customer = customers_repository.findById(customer_id).orElse(null);
	    if (customer != null) {
	        // Update the existing customer's details with the new details
	        customer.setCustomer_name(updatedCustomer.getCustomer_name());
	       customer.setCustomer_email(updatedCustomer.getCustomer_email());
	        customer.setCustomer_phone(updatedCustomer.getCustomer_phone());
	        // Add more fields as needed
	        customers_repository.save(customer);
	    }
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
	
	public List<Orders> getAllOrdersByCustomerId(int customerId) {
        Customers customer = customers_repository.findById(customerId).orElse(null);
        if(customer == null) throw new CustomerNotFoundException("No customer found with id: " +customerId, "GETFAILS");
        List<Orders> orders = customer.getOrders();
        return orders;
        
        /*
         * 
         */
    }

}