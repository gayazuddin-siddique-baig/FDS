package com.fds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.fds.exception.Response;

import com.fds.model.MenuItems;


import com.fds.model.Ratings;
import com.fds.model.DeliveryAddresses;
import com.fds.model.DeliveryDrivers;
import com.fds.model.Restaurants;
import com.fds.repository.RestaurantsRepository;
import com.fds.service.RestaurantsService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/restaurants")
public class RestaurantsController {

	@Autowired
	private RestaurantsService restaurants_service;
  
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<List<Restaurants>> getAllRestaurants() {
		return new ResponseEntity<List<Restaurants>>(restaurants_service.getAllRestaurants(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{restaurantId}", method=RequestMethod.DELETE)
	public ResponseEntity<Response> deleteRestaurantById(@PathVariable("restaurantId") int restaurant_id) {
		restaurants_service.deleteRestaurantById(restaurant_id);
		Response response = new Response("DELETESUCCESS", "Restaurant deleted successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
/*
 // update later
	@GetMapping("/{restaurantId}/menuitems")
	public ResponseEntity<List<MenuItems>> getMenuItemsByRestaurants(@PathVariable int restaurantId) {
		Restaurants restaurant = restaurants_service.getRestaurantById(restaurantId);
		List<MenuItems> menuItems = restaurants_service.getAllMenuItemsByRestaurant(restaurant);
		return new ResponseEntity<>(menuItems,HttpStatus.OK);
	}
*/
	@RequestMapping(value="/{restaurantId}/reviews", method=RequestMethod.GET)
	public ResponseEntity<List<String>> getAllRatingsOfRestaurant(@PathVariable("restaurantId") int restaurantId) {
		return new ResponseEntity<List<String>>(restaurants_service.getAllRatingsOfRestaurant(restaurantId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{restaurantId}/delivery-areas", method=RequestMethod.GET)
	public ResponseEntity<List<DeliveryAddresses>> getDeliveryAddressByRestaurantID(@PathVariable int restaurantId) {
		List<DeliveryAddresses> list =restaurants_service.getDeliveryAddresses(restaurantId);
		return new ResponseEntity<List<DeliveryAddresses>>(list, HttpStatus.OK);
	}
  
	@RequestMapping(value="/{restaurantId}", method=RequestMethod.PUT)
	public ResponseEntity<Restaurants> updateRestaurant(@RequestBody Restaurants newRestaurant, @PathVariable int restaurantId){
		Restaurants updatedRest = restaurants_service.updateRestaurantById(newRestaurant, restaurantId);
		return new ResponseEntity<Restaurants>(updatedRest,HttpStatus.OK );	
	}
	
	
	@GetMapping("/{restaurantId}/menuitems")
	public ResponseEntity<List<MenuItems>> getMenuItemsByRestaurants(@PathVariable int restaurantId){
		List<MenuItems> menuItems = restaurants_service.getMenuItemsByRestaurant(restaurantId);
		return new ResponseEntity<>(menuItems,HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method=RequestMethod.POST)
	public ResponseEntity<Restaurants> createRestaurant(@RequestBody Restaurants newRestaurant) {
		Restaurants saved = restaurants_service.saveRestaurants(newRestaurant);
		return new ResponseEntity<Restaurants>(saved, HttpStatus.CREATED);
	}
}

