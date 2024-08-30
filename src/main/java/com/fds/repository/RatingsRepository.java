package com.fds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fds.model.Ratings;

public interface RatingsRepository extends JpaRepository<Ratings, Integer> {
	@Query(
			value="SELECT * FROM ratings WHERE restaurant_id=:restaurantId",
			nativeQuery = true
	)
	List<Ratings> findByRestaurants(@Param("restaurantId") int restaurantId);
}
