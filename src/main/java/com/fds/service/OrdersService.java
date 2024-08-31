package com.fds.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fds.exception.AssingedDriverToOrderException;
import com.fds.exception.OrderNotFoundException;
import com.fds.model.DeliveryDrivers;
import com.fds.model.Orders;
import com.fds.repository.OrdersRepository;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository orders_repository;
	
	// method to get the specific order
	public Orders getOrdersById(int order_id) {
		Orders order= orders_repository.findById(order_id).orElse(null);
		if(order == null) throw new OrderNotFoundException("No order found with id: " +order_id, "GETFAILS");
		return order;
	}

	public DeliveryDrivers updateDriver(DeliveryDrivers deliveryDriver, int orderId) {
		Orders order =getOrdersById(orderId);
		DeliveryDrivers getOrderDriver = order.getDeliverydrivers();
		if(getOrderDriver !=null) {
			throw new AssingedDriverToOrderException("Order has alredy been assigned to an driver");
		}
		order.setDeliverydrivers(deliveryDriver);
		Orders newOrder =orders_repository.save(order);
		
		return newOrder.getDeliverydrivers();
	}
	
	// method to delete the specific order
	public void deleteSpecificOrder(int order_id) {
		Orders order = orders_repository.findById(order_id).orElse(null);
		if(order == null) throw new OrderNotFoundException("Order doesn't exist with id: " +order_id, "DELETEFAILS");
		orders_repository.deleteById(order_id);
	}
}
