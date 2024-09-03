package com.fds.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fds.model.MenuItems;
import com.fds.exception.MenuItemsFieldNotFoundException;
import com.fds.exception.MenuNotFoundException;
import com.fds.exception.OrderNotFoundException;
import com.fds.exception.RatingsNotFoundException;
import com.fds.exception.RestaurantFeildNotFoundException;
import com.fds.exception.RestaurantNotFoundException;
import com.fds.model.DeliveryAddresses;
import com.fds.model.Orders;
import com.fds.model.Ratings;
import com.fds.model.Restaurants;
import com.fds.repository.MenuItemRepository;
import com.fds.repository.RestaurantsRepository;

@Service
public class RestaurantsService {

	@Autowired
	private RestaurantsRepository restaurants_repository;
	
	@Autowired
	private MenuItemRepository menu_repository;

	
	// method to get all the restaurants
	public List<Restaurants> getAllRestaurants() {
		List<Restaurants> restaurants = restaurants_repository.findAll();
		
		// throw exception if the no restaurants are found
		if(restaurants.isEmpty()) throw new RestaurantNotFoundException("Restaurants list is empty", "GETALLFAILS");
		return restaurants;
	}
	
	// method to delete the specific restaurant
	public void deleteRestaurantById(int restaurant_id) {
		Restaurants restaurant = restaurants_repository.findById(restaurant_id).orElse(null);
		
		// throw exception if the restaurant is not found
		if(restaurant == null) throw new RestaurantNotFoundException("Restaurant doesn't exist with id: " +restaurant_id, "DELETEFAILS");
		
		restaurants_repository.deleteById(restaurant_id);
	}

	//get restaurant by id
	public Restaurants getRestaurantById(int restaurantId){
		Restaurants restaurant= restaurants_repository.findById(restaurantId).orElse(null);
		if(restaurant == null) throw new RestaurantNotFoundException("Restaurant doesn't exist with id: " +restaurantId, "GETFAILS");
		return restaurant;
	}

	//delete a specific restaurant menu item
	public void deleteMenuItemFromRestaurant(int restaurantId, int itemId) {
		Restaurants restaurant= restaurants_repository.findById(restaurantId).orElse(null);
		if(restaurant == null) throw new RestaurantNotFoundException("Restaurant doesn't exist with id: " +restaurantId, "GETFAILS");
	
	    MenuItems currItem= menu_repository.findById(itemId).orElse(null);
	    if(currItem ==null) throw new MenuNotFoundException("Menu items list is empty", "GETALLFAILS");
	    currItem.setRestaurants(null);
	 
	   menu_repository.save(currItem);
	}
	
	
	// method to get all the delivery areas served by the specific restaurant
	public List<DeliveryAddresses> getDeliveryAddressesOfSpecificRestaurant(int restaurant_id) {
		List<DeliveryAddresses> addresses = new ArrayList<>();		
		Restaurants restaurant = restaurants_repository.findById(restaurant_id).orElse(null);
		// throw exception if the restaurant is not found
		if(restaurant == null) throw new RestaurantNotFoundException("Restaurant not found with id: " +restaurant_id, "GETALLFAILS");
			
		List<Orders> orders = restaurant.getOrders();
		// throw exception if orders list is empty
		if(orders.isEmpty()) throw new OrderNotFoundException("Orders list is empty", "GETALLFAILS");
		
		for(Orders order : orders) {
			for(DeliveryAddresses address : order.getCustomers().getDeliveryaddresses()) addresses.add(address);
		}	
		return addresses;
	}
	
	// method to update the specific restaurant
	public void updateRestaurantById(Restaurants newRestaurant, int restaurantId) {
		Restaurants restaurant = restaurants_repository.findById(restaurantId).orElse(null);
		
		// throw exception if the restaurant is not found
		if(restaurant == null) throw new RestaurantNotFoundException("Restaurant not found with id: " +restaurantId, "UPDATEFAILS");
			
		restaurant.setRestaurant_name(newRestaurant.getRestaurant_name());
		restaurant.setRestaurant_phone(newRestaurant.getRestaurant_phone());
		restaurant.setRestaurant_address(newRestaurant.getRestaurant_address());
			
		restaurants_repository.save(restaurant);
	}

	// method to get all the ratings of the specific restaurant
	public List<String> getReviewsOfSpecificRestaurant(int restaurantId) {
		List<String> reviews = new ArrayList<>();
		
		Restaurants restaurant = restaurants_repository.findById(restaurantId).orElse(null);
		// throw exception if the restaurant is not found
		if(restaurant == null) throw new RestaurantNotFoundException("Restaurant not found with id: " + restaurantId, "GETALLFAILS");
		
		List<Ratings> ratings = restaurant.getRatings();
		// throw exception if ratings list is empty
		if(ratings.isEmpty()) throw new RatingsNotFoundException("Ratings list is empty", "GETALLFAILS");
		
		for(Ratings rating : ratings) reviews.add(rating.getReview());
		
		return reviews;
	}

	// method to get all the menu items of the specific restaurant
	public List<MenuItems> getMenuItemsByRestaurant(int restaurantId) {
		Restaurants restaurant = restaurants_repository.findById(restaurantId).orElse(null);
		
		// throw exception if the restaurant is not found
		if(restaurant == null) throw new RestaurantNotFoundException("Restaurant not found with id: " +restaurantId, "GETALLFAILS");
		
		List<MenuItems> menuitems = restaurant.getMenuitems();
		// throw exception if the menu items list is empty
		if(menuitems.isEmpty()) throw new MenuNotFoundException("Menu items list is empty", "GETALLFAILS");
		
		return menuitems;
	}
	
	// method to add menu item for the specific restaurant
	public void addMenuItemInSpecificRestaurant(int restaurant_id, MenuItems menuItem) {
		Restaurants restaurant = restaurants_repository.findById(restaurant_id).orElse(null);
		
		// throw exception if the restaurant is not found
		if(restaurant == null) throw new RestaurantNotFoundException("Restaurant not found with id: " +restaurant_id, "ADDFAILS");
		
		menuItem.setRestaurants(restaurant);
		
		// check if any menu items fields are null
		if(menuItem.getItem_id() == 0) throw new MenuItemsFieldNotFoundException("Menu item id is not given", "POSTFAILS");
		if(menuItem.getItem_name() == null) throw new MenuItemsFieldNotFoundException("Menu item name is not given", "POSTFAILS");
		if(menuItem.getItem_description() == null) throw new MenuItemsFieldNotFoundException("Menu item description is not given", "POSTFAILS");
		if(menuItem.getItem_price() == null) throw new MenuItemsFieldNotFoundException("Menu item price is not given", "POSTFAILS");
		
		restaurant.getMenuitems().add(menuItem);
		restaurants_repository.save(restaurant);
	}

	// method to add a new restaurant
	public void addRestaurant(Restaurants restaurant) {
		// throws an exception if restaurant id is not given
		if(restaurant.getRestaurant_id() == 0) {
			throw new RestaurantFeildNotFoundException("Restaurant Id is not given/valid, please give a valid Id", "POSTFAILS");
		}
		
		// throws an exception if restaurant name is not given
		if(restaurant.getRestaurant_name() == null) {
			throw new RestaurantFeildNotFoundException("Restaurant name is not given, please give a valid name", "POSTFAILS");
		}
		
		// throws an exception if restaurant phone number is not given
		if(restaurant.getRestaurant_phone() == null) {
			throw new RestaurantFeildNotFoundException("Restaurant phone is not given, please give a valid phone number", "POSTFAILS");
		}
		
		// throws an exception if restaurant address is not given
		if(restaurant.getRestaurant_address() == null) {
			throw new RestaurantFeildNotFoundException("Restaurant address is not given, please give a valid address", "POSTFAILS");
		}
		
		restaurants_repository.save(restaurant);
	}

	// method to update specific menu items of the specific restaurant
	public void updateMenuItemOfRestaurant(int restaurant_id, int itemId, MenuItems menuItem) {
		Restaurants restaurant = restaurants_repository.findById(restaurant_id).orElse(null);
		// throw exception if the restaurant is not found
		if(restaurant == null) throw new RestaurantNotFoundException("Restaurant not found with id: " +restaurant_id, "UPDATEFAILS");
		
		List<MenuItems> menuItems = restaurant.getMenuitems();
		// throw exception if the menu items is empty
		if(menuItems.isEmpty()) throw new MenuNotFoundException("Menu items list is empty", "UPDATEFAILS");
		
		boolean found = false;
		for(MenuItems m : menuItems) {
			if(m.getItem_id() == itemId) {
				if(menuItem.getItem_name() != null) m.setItem_name(menuItem.getItem_name());					
				if(menuItem.getItem_description() != null) m.setItem_description(menuItem.getItem_description());					
				if(menuItem.getItem_price() != null) m.setItem_price(menuItem.getItem_price());
				
				restaurants_repository.save(restaurant);
				found = true;
				break;
			}
		}
		
		if(!found) throw new MenuNotFoundException("Menu item not found with id: " +itemId, "UPDATEFAILS");
	}
}