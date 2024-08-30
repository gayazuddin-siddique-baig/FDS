package com.fds.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fds.model.Ratings;
import com.fds.model.Restaurants;
import com.fds.repository.RatingsRepository;
import com.fds.repository.RestaurantsRepository;
import com.fds.service.RatingsService;
import com.fds.service.RestaurantsService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class RestaurantsController {

	private RestaurantsService restaurants_service;
	
	private RatingsService ratings_service;
	
	@RequestMapping(value="/restaurants", method=RequestMethod.GET)
	public ResponseEntity<List<Restaurants>> getAllRestaurants() {
		return new ResponseEntity<List<Restaurants>>(restaurants_service.getAllRestaurants(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/restaurants/{restaurantId}/reviews", method=RequestMethod.GET)
	public ResponseEntity<List<Ratings>> getAllRatingsOfRestaurant(@PathVariable("restaurantId") int restaurantId) {
		return new ResponseEntity<List<Ratings>>(ratings_service.getAllRatingsOfRestaurant(restaurantId), HttpStatus.OK);
	}
}
