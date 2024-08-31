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

import com.fds.exception.DriverNotFoundException;
import com.fds.exception.SuccessResponse;
import com.fds.model.DeliveryDrivers;
import com.fds.model.Orders;
import com.fds.service.DeliveryDriversService;
import com.fds.service.OrdersService;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

	@Autowired
	private OrdersService orders_service;
	@Autowired
	private DeliveryDriversService deliveryDriversService;
	
	@RequestMapping(value="/{orderId}", method=RequestMethod.GET)
	public ResponseEntity<Orders> getOrdersById(@PathVariable("orderId") int order_id) {
		Orders order = orders_service.getOrdersById(order_id);
		return new ResponseEntity<Orders>(order, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{orderId}/assignDriver/{driverId}", method=RequestMethod.PUT)
	public ResponseEntity<SuccessResponse> assignDriverById(@PathVariable("orderId") int orderId,@PathVariable("driverId") int driverId){
		DeliveryDrivers deliveryDriver= deliveryDriversService.getDriverById(driverId);
		DeliveryDrivers updatedDriver=orders_service.updateDriver(deliveryDriver, orderId);
		SuccessResponse response = new SuccessResponse("PUTSUCCESS", "Order has been successfully assinged to driver");
		return new ResponseEntity<SuccessResponse>(response, HttpStatus.OK);
	}
}
