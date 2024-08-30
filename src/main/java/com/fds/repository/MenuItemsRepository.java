package com.fds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fds.model.MenuItems;
import com.fds.model.Restaurants;

public interface MenuItemsRepository extends JpaRepository<MenuItems,Integer>{
	List<MenuItems>findByRestaurants(Restaurants restaurant);
}


