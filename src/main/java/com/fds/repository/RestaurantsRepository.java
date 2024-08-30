package com.fds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fds.model.MenuItems;
import com.fds.model.Restaurants;

@Repository
public interface RestaurantsRepository extends JpaRepository<Restaurants, Integer> {
	@Query(
			value="SELECT * FROM restaurants",
			nativeQuery=true 
	)
	List<Restaurants> getAllRestaurants();
	
	List<MenuItems> getAllMenuItemsByRestaurant(Restaurants restaurant);
	
}

