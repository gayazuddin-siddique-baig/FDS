package com.fds.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fds.model.Customers;
import com.fds.model.DeliveryAddresses;
import com.fds.model.DeliveryDrivers;
import com.fds.model.Orders;
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
	// get delivery address by restaurant id
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
}