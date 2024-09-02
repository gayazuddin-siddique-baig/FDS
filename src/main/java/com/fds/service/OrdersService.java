package com.fds.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fds.dto.OrdersDTO;
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
	public OrdersDTO getSpecificOrderById(int order_id) {
		List<Object[]> orders = orders_repository.getSpecificOrderById(order_id);
		
		// throw exception if the order is not found
		if (orders.isEmpty()) throw new OrderNotFoundException("Order not found with id: " + order_id, "GETFAILS");
		
		// convert Orders to OrdersDTO
		Object[] order = orders.get(0);
		OrdersDTO orderdto = new OrdersDTO((int)order[0], ((Timestamp)order[1]).toLocalDateTime(), (int)order[2], (int)order[3], (int)order[4], (String)order[5]);
		
		return orderdto;
	}

	// method to assign the delivery driver to the specific order
	public DeliveryDrivers assignDeliveryDriverForSpecificOrder(DeliveryDrivers delivery_driver, int order_id) {
		Orders order = orders_repository.findById(order_id).orElse(null);
		
		// throw exception if the order is not found
		if(order == null) throw new OrderNotFoundException("Order not found with id: " +order_id, "PUTFAILS");
		
		DeliveryDrivers driver = order.getDeliverydrivers();
		// throw exception if delivery driver is already assigned
		if(driver != null) throw new AssingedDriverToOrderException("Order has alredy been assigned to an driver");
		
		order.setDeliverydrivers(delivery_driver);
		Orders newOrder = orders_repository.save(order);
		
		return newOrder.getDeliverydrivers();
	}
	
	// method to delete the specific order
	public void deleteSpecificOrder(int order_id) {
		Orders order = orders_repository.findById(order_id).orElse(null);
		if(order == null) throw new OrderNotFoundException("Order doesn't exist with id: " +order_id, "DELETEFAILS");
		orders_repository.deleteById(order_id);
	}
}
