package com.fds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fds.model.Orders;
import com.fds.service.OrdersService;

@RestController
@RequestMapping("/api")
public class OrdersController {

	@Autowired
	private OrdersService orders_service;
	
	@RequestMapping(value="/orders/{orderId}", method=RequestMethod.GET)
	public ResponseEntity<Orders> getOrdersById(@PathVariable("orderId") int order_id) {
		Orders order = orders_service.getOrdersById(order_id);
		return new ResponseEntity<Orders>(order, HttpStatus.OK);
	}
}
