package com.fds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fds.model.Restaurants;
import com.fds.repository.RestaurantsRepository;

@Service
public class RestaurantsService {

	@Autowired
	private RestaurantsRepository restaurants_repository;
	
	public List<Restaurants> getAllRestaurants() {
		return restaurants_repository.getAllRestaurants();
	}
	
	public void deleteRestaurantById(int restaurant_id) {
		restaurants_repository.deleteRestaurantById(restaurant_id);
	}
}