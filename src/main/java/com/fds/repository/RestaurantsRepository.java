package com.fds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fds.model.Restaurants;

@Repository
public interface RestaurantsRepository extends JpaRepository<Restaurants, Integer> {
	
	// query to get all the favourite restaurants of the specific customer
	@Query(
		value="SELECT r.* FROM Restaurants r WHERE r.restaurant_id = (SELECT o.restaurant_id FROM Orders o WHERE o.customer_id =:customerId GROUP BY o.restaurant_id ORDER BY COUNT(o.order_id) DESC LIMIT 1)",
		nativeQuery = true
	)
	Restaurants getFavouriteRestaurantOfCustomer(@Param("customerId") int customerId);
}