package com.fds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fds.model.MenuItems;
import com.fds.model.Restaurants;
import com.fds.repository.MenuItemsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MenuItemsService {
	
	@Autowired
	private MenuItemsRepository menuItemsRepository;
	
	public List<MenuItems> getMenuItemsByRestaurant(Restaurants restaurant){
		return menuItemsRepository.findByRestaurants(restaurant);
	}

}
