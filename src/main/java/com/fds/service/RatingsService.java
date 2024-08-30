package com.fds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fds.model.Customers;
import com.fds.model.Ratings;
import com.fds.repository.RatingsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RatingsService {
	
	@Autowired
	private RatingsRepository ratingsRepository;
	
	public List<Ratings>getRatingsByCustomer(Customers customer){
		return ratingsRepository.findByOrders_Customers(customer);
	}

}
