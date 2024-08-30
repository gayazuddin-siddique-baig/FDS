package com.fds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fds.exception.Response;
import com.fds.model.Restaurants;
import com.fds.service.RestaurantsService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/restaurants")
public class RestaurantsController {

	@Autowired
	private RestaurantsService restaurants_service;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<List<Restaurants>> getAllRestaurants() {
		return new ResponseEntity<List<Restaurants>>(restaurants_service.getAllRestaurants(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete/{restaurantId}", method=RequestMethod.DELETE)
	public ResponseEntity<Response> deleteRestaurantById(@PathVariable("restaurantId") int restaurant_id) {
		restaurants_service.deleteRestaurantById(restaurant_id);
		Response response = new Response("DELETESUCCESS", "Restaurant deleted successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}
