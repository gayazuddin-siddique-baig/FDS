package com.fds.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fds.model.MenuItems;
import com.fds.exception.RestaurantNotFoundException;
import com.fds.model.Customers;
import com.fds.model.DeliveryAddresses;
import com.fds.model.DeliveryDrivers;
import com.fds.model.Orders;
import com.fds.model.Ratings;
import com.fds.model.Restaurants;
import com.fds.repository.RestaurantsRepository;

@Service
public class RestaurantsService {

	@Autowired
	private RestaurantsRepository restaurants_repository;
	
	public List<Restaurants> getAllRestaurants() {
		return restaurants_repository.findAll();
	}
	
	public void deleteRestaurantById(int restaurant_id) {
		restaurants_repository.deleteById(restaurant_id);
	}

	public Restaurants getRestaurantById(int restaurantId){
		return restaurants_repository.findById(restaurantId).orElse(null);
	}
	
	public List<DeliveryAddresses> getDeliveryAddresses(int restaurantId) {
		Optional<Restaurants> rs = restaurants_repository.findById(restaurantId);
		List<DeliveryAddresses> list = new ArrayList<>();
		if(rs.isPresent()) {
			Restaurants restaurant = rs.get();
			
			for(Orders order:restaurant.getOrders()) {
				
				for(DeliveryAddresses address: order.getCustomers().getDeliveryaddresses()) {
					list.add(address);
				}
			}
			
		}
		return list;
	}
	
	
	public Restaurants updateRestaurantById(Restaurants newRestaurant, int restaurantId) {
		
		Optional<Restaurants> restaurant = restaurants_repository.findById(restaurantId);
		if(restaurant.isPresent()) {
			Restaurants oldRestaurant = restaurant.get();
			oldRestaurant.setRestaurant_name(newRestaurant.getRestaurant_name());
			oldRestaurant.setRestaurant_phone(newRestaurant.getRestaurant_phone());
			oldRestaurant.setRestaurant_address(newRestaurant.getRestaurant_address());
			
			return restaurants_repository.save(oldRestaurant);
		}
		else return null;
	}

	public List<String> getAllRatingsOfRestaurant(int restaurantId) {
		List<String> ratingList = new ArrayList<>();
		Restaurants restaurant = restaurants_repository.findById(restaurantId).get();
		List<Ratings> ratings= restaurant.getRatings();
		for(Ratings currRating:ratings) {
			ratingList.add(currRating.getReview());
		}
		return ratingList;
	}

	public List<MenuItems> getMenuItemsByRestaurant(int restaurantId) {
		Restaurants restaurant = restaurants_repository.findById(restaurantId).orElse(null);
		if(restaurant == null) {
			throw new RestaurantNotFoundException("Restaurant not found with id: " +restaurantId);
		}
		return restaurant.getMenuitems();
	}
	
	// method to add menu item for a specific restaurant
	public void addMenuItemInSpecificRestaurant(int restaurant_id, MenuItems menuItem) {
		Restaurants restaurant = restaurants_repository.findById(restaurant_id).orElse(null);
		if(restaurant != null) {
			menuItem.setRestaurants(restaurant);
			restaurant.getMenuitems().add(menuItem);
			restaurants_repository.save(restaurant);
		}
		else throw new RestaurantNotFoundException("Restaurant not found with id: " +restaurant_id);
	}

	public Restaurants saveRestaurants(Restaurants restaurant) {
		return restaurants_repository.save(restaurant);
	}
}