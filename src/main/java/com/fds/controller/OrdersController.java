package com.fds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fds.dto.OrdersDTO;
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

	
	// method to get the specific order
	@RequestMapping(value="/{orderId}", method=RequestMethod.GET)
	public ResponseEntity<OrdersDTO> getSpecificOrderById(@PathVariable("orderId") int order_id) {
		OrdersDTO orderdto = orders_service.getSpecificOrderById(order_id);
		return new ResponseEntity<OrdersDTO>(orderdto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{orderId}/assignDriver/{driverId}", method=RequestMethod.PUT)
	public ResponseEntity<SuccessResponse> assignDriverById(@PathVariable("orderId") int orderId, @PathVariable("driverId") int driverId){
		DeliveryDrivers deliveryDriver= deliveryDriversService.getSpecificDeliveryDriverById(driverId);
		orders_service.assignDeliveryDriverForSpecificOrder(deliveryDriver, orderId);
		SuccessResponse response = new SuccessResponse("PUTSUCCESS", "Order has been successfully assinged to driver");
		return new ResponseEntity<SuccessResponse>(response, HttpStatus.OK);
	}
	
	// method to place a new order
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<SuccessResponse> placeOrder(@RequestBody OrdersDTO ordersDTO) {
       
        // Set other fields and relationships as necessary
        // Assuming the existence of a method to handle setting relationships or additional logic

        // Call to the OrdersService to save the order
        orders_service.saveOrder(ordersDTO);

        SuccessResponse response = new SuccessResponse("POSTSUCCESS", "Order placed successfully");
        return new ResponseEntity<SuccessResponse>(response, HttpStatus.CREATED);
    }
	
	// method to delete the specific order
	@RequestMapping(value="/{orderId}", method=RequestMethod.DELETE)
	public ResponseEntity<SuccessResponse> deleteSpecificOrder(@PathVariable("orderId") int order_id) {
		orders_service.deleteSpecificOrder(order_id);
		SuccessResponse success = new SuccessResponse("DELETESUCCESS", "Order deleted successfully");
		return new ResponseEntity<SuccessResponse>(success, HttpStatus.OK);
	}
	
	//method to update the status of a specific order
	@RequestMapping(value="/{orderId}/status", method=RequestMethod.PUT)
    public ResponseEntity<SuccessResponse> updateOrderStatus(@PathVariable("orderId") int order_id, @RequestParam("status") String status) {
        orders_service.updateOrderStatus(order_id, status);
        SuccessResponse success = new SuccessResponse("UPDATESUCCESS", "Order status updated successfully");
        return new ResponseEntity<>(success, HttpStatus.OK);
    }
}