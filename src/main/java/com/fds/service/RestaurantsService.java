package com.fds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fds.model.MenuItems;
import com.fds.model.Restaurants;
import com.fds.repository.RestaurantsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RestaurantsService {

	private RestaurantsRepository restaurants_repository;
	
	public List<Restaurants> getAllRestaurants() {
		return restaurants_repository.getAllRestaurants();
	}
	
	public Restaurants getRestaurantById(int restaurantId){
		return restaurants_repository.findById(restaurantId).orElse(null);
		
	}
}