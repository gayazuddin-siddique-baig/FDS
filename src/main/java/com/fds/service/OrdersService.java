package com.fds.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fds.dto.OrdersDTO;
import com.fds.exception.AssingedDriverToOrderException;
import com.fds.exception.CustomerNotFoundException;
import com.fds.exception.DeliveryDriverNotFoundException;
import com.fds.exception.OrderNotFoundException;
import com.fds.exception.RestaurantNotFoundException;
import com.fds.model.Customers;
import com.fds.model.DeliveryDrivers;
import com.fds.model.Orders;
import com.fds.model.Restaurants;
import com.fds.repository.CustomersRepository;
import com.fds.repository.DeliveryDriversRepository;
import com.fds.repository.OrdersRepository;
import com.fds.repository.RestaurantsRepository;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository orders_repository;
	@Autowired
	private CustomersRepository customer_repository;
	@Autowired
	private RestaurantsRepository rest_repository;
	@Autowired
	private DeliveryDriversRepository driver_repository;
	
	public void saveOrder(OrdersDTO newOrder) {
		 Orders order = new Orders();
		
		if(newOrder.getCustomer_id() !=0) {
			Customers cust = customer_repository.findById(newOrder.getCustomer_id()).orElse(null);
			if(cust == null) {
				throw new CustomerNotFoundException("No Customer exist with the id : "+newOrder.getCustomer_id(),"GETFAILS");
			}
			 order.setCustomers(cust);
		}
		
		if(newOrder.getRestaurant_id() !=0) {
			Restaurants restaurant= rest_repository.findById(newOrder.getRestaurant_id()).orElse(null);
			if(restaurant == null) {
				throw new RestaurantNotFoundException("Restaurant doesn't exist with id: " +newOrder.getRestaurant_id(), "GETFAILS");
			}
		      order.setRestaurants(restaurant);
		}
		
		if(newOrder.getDelivery_driver_id() !=0) {
			DeliveryDrivers drivers = driver_repository.findById(newOrder.getDelivery_driver_id()).orElse(null);
			if(drivers == null) {
				 throw new DeliveryDriverNotFoundException("Delivery driver not found with id: " +newOrder.getDelivery_driver_id(), "GETFAILS");
			}
			order.setDeliverydrivers(drivers);
		}
				
	        order.setOrder_id(newOrder.getOrder_id());
	        order.setOrder_date(newOrder.getOrder_date());
	        order.setOrder_date(newOrder.getOrder_date());
	        order.setOrder_status(newOrder.getOrder_status());
	        
	    orders_repository.save(order);
	    return;
	}

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
	public void assignDeliveryDriverForSpecificOrder(DeliveryDrivers delivery_driver, int order_id) {
		Orders order = orders_repository.findById(order_id).orElse(null);
		
		// throw exception if the order is not found
		if(order == null) throw new OrderNotFoundException("Order not found with id: " +order_id, "PUTFAILS");
		
		DeliveryDrivers driver = order.getDeliverydrivers();
		// throw exception if delivery driver is already assigned
		if(driver != null) throw new AssingedDriverToOrderException("Order has already been assigned to the driver with id: ");
		
		order.setDeliverydrivers(delivery_driver);
		orders_repository.save(order);
	}
	
	// method to delete the specific order
	public void deleteSpecificOrder(int order_id) {
		Orders order = orders_repository.findById(order_id).orElse(null);
		
		// throw an exception if the order is not found
		if(order == null) throw new OrderNotFoundException("Order doesn't exist with id: " +order_id, "DELETEFAILS");
		orders_repository.deleteById(order_id);
	}
	
	// method to update the status of the specific order
	public void updateOrderStatus(int order_id, String status) {
        Orders order = orders_repository.findById(order_id).orElse(null);
        
        // throw exception if the order is not found
        if(order == null) throw new OrderNotFoundException("Order not found with id: " +order_id, "UPDATEFAILS");
       
    	order.setOrder_status(status);
    	orders_repository.save(order);
	}
}