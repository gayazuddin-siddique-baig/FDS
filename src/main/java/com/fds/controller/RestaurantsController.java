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

import com.fds.exception.RestaurantNotFoundException;
import com.fds.exception.SuccessResponse;

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
  
	// method to get all the restaurants
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<List<Restaurants>> getAllRestaurants() {
		return new ResponseEntity<List<Restaurants>>(restaurants_service.getAllRestaurants(), HttpStatus.OK);
	}
	
	// method to delete the specific restaurant
	@RequestMapping(value="/{restaurantId}", method=RequestMethod.DELETE)
	public ResponseEntity<SuccessResponse> deleteRestaurantById(@PathVariable("restaurantId") int restaurant_id) {
		restaurants_service.deleteRestaurantById(restaurant_id);
		SuccessResponse response = new SuccessResponse("DELETESUCCESS", "Restaurant deleted successfully");
		return new ResponseEntity<SuccessResponse>(response, HttpStatus.OK);
	}

	// method to get all the reviews of a specific restaurant
	@RequestMapping(value="/{restaurantId}/reviews", method=RequestMethod.GET)
	public ResponseEntity<List<String>> getAllRatingsOfRestaurant(@PathVariable("restaurantId") int restaurantId) {
		return new ResponseEntity<List<String>>(restaurants_service.getAllRatingsOfRestaurant(restaurantId), HttpStatus.OK);
	}
	
	// method to get all the delivery areas of a specific restaurant
	@RequestMapping(value="/{restaurantId}/delivery-areas", method=RequestMethod.GET)
	public ResponseEntity<List<DeliveryAddresses>> getDeliveryAddressByRestaurantID(@PathVariable int restaurantId) {
		List<DeliveryAddresses> list =restaurants_service.getDeliveryAddresses(restaurantId);
		return new ResponseEntity<List<DeliveryAddresses>>(list, HttpStatus.OK);
	}
  
	// method to update a specific restaurant
	@RequestMapping(value="/{restaurantId}", method=RequestMethod.PUT)
	public ResponseEntity<SuccessResponse> updateRestaurant(@RequestBody Restaurants newRestaurant, @PathVariable int restaurantId){
		Restaurants updatedRest = restaurants_service.updateRestaurantById(newRestaurant, restaurantId);
		if(updatedRest == null) {
			throw new RestaurantNotFoundException("Restaurant with id "+restaurantId+"not found", "PUTFAILS");
		}
		SuccessResponse response = new SuccessResponse("PUTSUCCESS", "Restaurant details updated successfully");
		return new ResponseEntity<SuccessResponse>(response,HttpStatus.OK );	
	}
	
	// method to get all the menu items of a specific restaurant
	@RequestMapping(value="/{restaurantId}/menu", method=RequestMethod.GET)
	public ResponseEntity<List<MenuItems>> getMenuItemsByRestaurants(@PathVariable("restaurantId") int restaurant_id){
		List<MenuItems> menuItems = restaurants_service.getMenuItemsByRestaurant(restaurant_id);
		return new ResponseEntity<>(menuItems, HttpStatus.OK);
	}
	
	// method to add menu items for a specific restaurant
	@RequestMapping(value="/{restaurantId}/menu", method=RequestMethod.POST)
	public ResponseEntity<SuccessResponse> addMenuItemInSpecificRestaurant(@PathVariable("restaurantId") int restaurant_id, @RequestBody MenuItems menuItems) {
		restaurants_service.addMenuItemInSpecificRestaurant(restaurant_id, menuItems);
		SuccessResponse success = new SuccessResponse("POSTSUCCESS", "Menu item added to the restaurant successfully");
		return new ResponseEntity<SuccessResponse>(success, HttpStatus.CREATED);
	}
	
	// method to get a specific restaurant
	@RequestMapping(value="/{restaurantId}", method=RequestMethod.GET)
	public ResponseEntity<Restaurants> getRestaurantsById(@PathVariable("restaurantId") int restaurant_id) {
		Restaurants restaurant = restaurants_service.getRestaurantById(restaurant_id);
		if(restaurant == null) {
			throw new RestaurantNotFoundException("Restaurant with id "+restaurant_id+"not found", "GETFAILS");
		}
		return new ResponseEntity<Restaurants>(restaurant, HttpStatus.OK);
	}
	
	// method to create a new restaurant
	@RequestMapping(value = "", method=RequestMethod.POST)
	public ResponseEntity<Restaurants> createRestaurant(@Valid @RequestBody Restaurants newRestaurant) {
		Restaurants saved = restaurants_service.saveRestaurants(newRestaurant);
		return new ResponseEntity<Restaurants>(saved, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{restaurantId}/menu/{itemId}", method=RequestMethod.PUT)
	public ResponseEntity<SuccessResponse> updateMenuItemOfRestaurant(@RequestBody MenuItems menuItem, @PathVariable("restaurantId") int restaurantId, @PathVariable("itemId") int itemId) {
		Restaurants restaurant = restaurants_service.getRestaurantById(restaurantId);
		if(restaurant == null) {
			throw new RestaurantNotFoundException("Restaurant with id " + restaurantId +" not found", "GETFAILS");
		}
		restaurants_service.updateMenuItemOfRestaurant(restaurant, itemId, menuItem);
		SuccessResponse response = new SuccessResponse("PUTSUCCESS", "Menu item details updated successfully");
		return new ResponseEntity<SuccessResponse>(response, HttpStatus.OK);
	}
	
}

