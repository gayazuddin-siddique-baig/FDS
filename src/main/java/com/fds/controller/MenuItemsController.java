package com.fds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fds.model.MenuItems;
import com.fds.model.Restaurants;
import com.fds.service.CustomersService;
import com.fds.service.MenuItemsService;
import com.fds.service.RestaurantsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class MenuItemsController {
	
	@Autowired
	private MenuItemsService menuItemsService;
	
	@Autowired
	private RestaurantsService restaurantsService;
	
	@GetMapping("/restaurants/{restaurantId}/menuitems")
	public ResponseEntity<List<MenuItems>> getMenuItemsByRestaurants(@PathVariable int restaurantId){
		Restaurants restaurant = restaurantsService.getRestaurantById(restaurantId);
		List<MenuItems> menuItems = menuItemsService.getMenuItemsByRestaurant(restaurant);
		return new ResponseEntity<>(menuItems,HttpStatus.OK);
	}

}
