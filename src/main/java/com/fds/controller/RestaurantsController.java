package com.fds.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fds.model.MenuItems;
import com.fds.model.Restaurants;
import com.fds.service.RestaurantsService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/restaurants")
public class RestaurantsController {

	private RestaurantsService restaurants_service;
	
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
}