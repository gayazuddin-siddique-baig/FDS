package com.fds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fds.model.DeliveryDrivers;
import com.fds.model.Orders;
import com.fds.service.DeliveryDriversService;
import com.fds.service.OrdersService;

@RestController
@RequestMapping("/api")
public class OrdersController {

	@Autowired
	private OrdersService orders_service;
	@Autowired
	private DeliveryDriversService deliveryDriversService;
	
	@RequestMapping(value="/orders/{orderId}", method=RequestMethod.GET)
	public ResponseEntity<Orders> getOrdersById(@PathVariable("orderId") int order_id) {
		Orders order = orders_service.getOrdersById(order_id);
		return new ResponseEntity<Orders>(order, HttpStatus.OK);
	}
	@RequestMapping(value="/orders/{orderId}/assignDriver/{driverId}", method=RequestMethod.PUT)
	public ResponseEntity<DeliveryDrivers> assignDriverById(@PathVariable("orderId") int orderId,@PathVariable("driverId") int driverId){
		DeliveryDrivers deliveryDriver= deliveryDriversService.getDriverById(driverId);
		DeliveryDrivers updatedDriver=orders_service.updateDriver(deliveryDriver, orderId);
		return new ResponseEntity<DeliveryDrivers>(updatedDriver, HttpStatus.OK);
	}
}
