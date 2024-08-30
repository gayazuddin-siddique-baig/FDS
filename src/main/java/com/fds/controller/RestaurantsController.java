package com.fds.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.fds.model.MenuItems;


import com.fds.model.Ratings;
import com.fds.model.DeliveryAddresses;
import com.fds.model.DeliveryDrivers;
import com.fds.model.Restaurants;
import com.fds.repository.RatingsRepository;
import com.fds.repository.RestaurantsRepository;
import com.fds.service.RatingsService;
import com.fds.service.RestaurantsService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/restaurants")
public class RestaurantsController {

	private RestaurantsService restaurants_service;
	
	private RatingsService ratings_service;
	
	@RequestMapping(value="/restaurants", method=RequestMethod.GET)
	public ResponseEntity<List<Restaurants>> getAllRestaurants() {
		return new ResponseEntity<List<Restaurants>>(restaurants_service.getAllRestaurants(), HttpStatus.OK);
	}
	

	@GetMapping("/{restaurantId}/menuitems")
	public ResponseEntity<List<MenuItems>> getMenuItemsByRestaurants(@PathVariable int restaurantId){
		Restaurants restaurant = restaurants_service.getRestaurantById(restaurantId);
		List<MenuItems> menuItems = restaurants_service.getAllMenuItemsByRestaurant(restaurant);
		return new ResponseEntity<>(menuItems,HttpStatus.OK);
	}

	@RequestMapping(value="/restaurants/{restaurantId}/reviews", method=RequestMethod.GET)
	public ResponseEntity<List<Ratings>> getAllRatingsOfRestaurant(@PathVariable("restaurantId") int restaurantId) {
		return new ResponseEntity<List<Ratings>>(ratings_service.getAllRatingsOfRestaurant(restaurantId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/restaurants/{restaurantId}/delivery-areas", method=RequestMethod.GET)
	public ResponseEntity<List<DeliveryAddresses>> getDeliveryAddressByRestaurantID(@PathVariable int restaurantId) {
		List<DeliveryAddresses> list =restaurants_service.getDeliveryAddresses(restaurantId);
		return new ResponseEntity<List<DeliveryAddresses>>(list, HttpStatus.OK);
	}
	@RequestMapping(value="/restaurants/{restaurantId}", method=RequestMethod.PUT)
	public ResponseEntity<Restaurants> updateRestaurant(@RequestBody Restaurants newRestaurant, @PathVariable int restaurantId){
		Restaurants updatedRest = restaurants_service.updateRestaurantById(newRestaurant, restaurantId);
		return new ResponseEntity<Restaurants>(updatedRest,HttpStatus.OK );	
	}
	
}

