package com.fds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fds.exception.DeliveryDriverNotFoundException;
import com.fds.model.DeliveryDrivers;
import com.fds.model.Orders;
import com.fds.repository.DeliveryDriversRepository;

@Service
public class DeliveryDriversService {

	@Autowired
    private DeliveryDriversRepository deliverydrivers_repository;

	// method to get all the delivery drivers
    public List<DeliveryDrivers> getAllDeliveryDrivers() {
        return deliverydrivers_repository.findAll();
    }
    
    // method to get the specific delivery driver
    public DeliveryDrivers getSpecificDeliveryDriverById(int delivery_driver_id) {
    	DeliveryDrivers delivery_driver = deliverydrivers_repository.findById(delivery_driver_id).orElse(null);
    	
    	// throw exception if the delivery driver is not found
    	if(delivery_driver == null) throw new DeliveryDriverNotFoundException("Delivery driver not found with id: " +delivery_driver_id, "GETFAILS");

    	return delivery_driver;
    }
    
    // method to get all the orders of the specific delivery driver
    public List<Orders> getOrdersofSpecificDeliveryDriver(int delivery_driver_id) {
    	DeliveryDrivers delivery_driver = deliverydrivers_repository.findById(delivery_driver_id).orElse(null);
    	
    	// throw exception if the delivery driver is not found
    	if(delivery_driver == null) throw new DeliveryDriverNotFoundException("Delivery driver not found with id: " +delivery_driver_id, "GETALLFAILS");
    	
    	return delivery_driver.getOrders();
    }
    
    // method to update the vehicle of the specific delivery driver
    public void updateVehicleOfSpecificDeliveryDriver(int delivery_driver_id, String vehicle) {
    	DeliveryDrivers delivery_driver = deliverydrivers_repository.findById(delivery_driver_id).orElse(null);
    	
    	// throw exception if delivery driver is not found
    	if(delivery_driver == null) throw new DeliveryDriverNotFoundException("Delivery driver not found with id: " +delivery_driver_id, "UPDATEFAILS");
    	
    	delivery_driver.setDriver_vehicle(vehicle);
    	deliverydrivers_repository.save(delivery_driver);
    }
}