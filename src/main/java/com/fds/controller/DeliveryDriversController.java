package com.fds.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fds.model.DeliveryDrivers;
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
    
    @GetMapping("/{driverId}")
    public ResponseEntity<DeliveryDrivers> getDriverById(@PathVariable int driverId){
    	DeliveryDrivers driver = deliveryDriversService.getDriverById(driverId);
    	return new ResponseEntity<>(driver,HttpStatus.OK);
    }
}
