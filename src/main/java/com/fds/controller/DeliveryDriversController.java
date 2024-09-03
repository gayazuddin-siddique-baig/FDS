package com.fds.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fds.exception.SuccessResponse;
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
    

    // method to get the specific delivery driver
    @RequestMapping(value="/{driverId}", method=RequestMethod.GET)
    public ResponseEntity<DeliveryDrivers> getDriverById(@PathVariable("driverId") int driverId){
    	DeliveryDrivers driver = deliveryDriversService.getSpecificDeliveryDriverById(driverId);
    	return new ResponseEntity<>(driver,HttpStatus.OK);
    }

    // 
    @RequestMapping(value="/{driverId}/orders", method=RequestMethod.GET)
    public ResponseEntity<List<Orders>> getAllOrdersByDriverId(@PathVariable("driverId") int driverId) {
        List<Orders> orders = deliveryDriversService.getOrdersofSpecificDeliveryDriver(driverId);
        return new ResponseEntity<List<Orders>>(orders, HttpStatus.OK);
    }
    
    // method to update the vehicle of the specific driver
    @RequestMapping(value="/{driverId}/vehicle/{vehicleType}", method=RequestMethod.PUT)
    public ResponseEntity<SuccessResponse> updateVehicleOfSpecificDeliveryDriver(@PathVariable("driverId") int driver_id, @PathVariable("vehicleType") String vehicle) {
    	deliveryDriversService.updateVehicleOfSpecificDeliveryDriver(driver_id, vehicle);
    	SuccessResponse success = new SuccessResponse("UPDATESUCCESS", "Driver vehicle updated successfully");
    	return new ResponseEntity<SuccessResponse>(success, HttpStatus.OK);
    }
}