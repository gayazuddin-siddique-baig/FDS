package com.fds.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fds.model.DeliveryDrivers;
import com.fds.model.Orders;
import com.fds.repository.OrdersRepository;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository orders_repository;
	
	public Orders getOrdersById(int order_id) {
		return orders_repository.getOrdersById(order_id);
	}

	public DeliveryDrivers updateDriver(DeliveryDrivers deliveryDriver, int orderId) {
		Orders order =getOrdersById(orderId);
		order.setDeliverydrivers(deliveryDriver);
		Orders newOrder =orders_repository.save(order);
		
		return newOrder.getDeliverydrivers();
	}
}
