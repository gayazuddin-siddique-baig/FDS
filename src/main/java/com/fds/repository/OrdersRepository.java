package com.fds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fds.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
	@Query(
			value="SELECT * FROM orders WHERE order_id=:order_id",
			nativeQuery=true 
	)
	Orders getOrdersById(@Param("order_id") int order_id);
}