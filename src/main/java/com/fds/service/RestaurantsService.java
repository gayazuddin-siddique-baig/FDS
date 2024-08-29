package com.fds.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fds.model.Restaurants;
import com.fds.repository.RestaurantsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RestaurantsService {

	private RestaurantsRepository restaurants_repository;
	
	public List<Restaurants> getAllRestaurants() {
		System.out.println(restaurants_repository.findAll());
		return restaurants_repository.findAll();
	}
}