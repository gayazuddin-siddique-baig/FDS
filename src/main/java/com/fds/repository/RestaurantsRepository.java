package com.fds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fds.model.MenuItems;
import com.fds.model.Restaurants;

import jakarta.transaction.Transactional;

@Repository
public interface RestaurantsRepository extends JpaRepository<Restaurants, Integer> {
	@Query(
			value="SELECT * FROM restaurants",
			nativeQuery=true 
	)
	List<Restaurants> getAllRestaurants();
	
	@Modifying
	@Transactional
	@Query(
			value="DELETE FROM restaurants WHERE restaurant_id=:restaurant_id",
			nativeQuery=true 
	)
	void deleteRestaurantById(@Param("restaurant_id") int restaurant_id);
  
	List<MenuItems> getAllMenuItemsByRestaurant(Restaurants restaurant);
}