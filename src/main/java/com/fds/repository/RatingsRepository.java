package com.fds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fds.model.Customers;
import com.fds.model.Ratings;

public interface RatingsRepository extends JpaRepository<Ratings,Integer>{
	List<Ratings> findByOrders_Customers(Customers customer); 
}
