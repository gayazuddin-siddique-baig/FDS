package com.fds.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fds.model.DeliveryDrivers;
import com.fds.model.Orders;
import com.fds.service.DeliveryDriversService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/drivers")
public class DeliveryDriversController {

    private DeliveryDriversService deliveryDriversService;

    @RequestMapping(value="", method=RequestMethod.GET)
    public ResponseEntity<List<DeliveryDrivers>> getAllDeliveryDrivers() {
        List<DeliveryDrivers> driversList = deliveryDriversService.getAllDeliveryDrivers();
        return new ResponseEntity<List<DeliveryDrivers>>(driversList, HttpStatus.OK);
    }
    
    @RequestMapping(value="/{driverId}/orders", method=RequestMethod.GET)
    public ResponseEntity<List<Orders>> getAllOrdersByDriverId(@PathVariable("driverId") int driverId) {
        List<Orders> orders = deliveryDriversService.getAllOrdersByDriverId(driverId);
        return new ResponseEntity<List<Orders>>(orders, HttpStatus.OK);
    }
    
    
}
