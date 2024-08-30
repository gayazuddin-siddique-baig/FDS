package com.fds.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fds.model.Ratings;
import com.fds.repository.RatingsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RatingsService {
	private RatingsRepository ratingsRepository;
	
	public List<Ratings> getAllRatingsOfRestaurant(int restaurantId) {
		return ratingsRepository.findByRestaurants(restaurantId);
	}
}
