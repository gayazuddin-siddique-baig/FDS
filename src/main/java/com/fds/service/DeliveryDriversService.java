package com.fds.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fds.exception.DriverNotFoundException;
import com.fds.model.DeliveryDrivers;
import com.fds.model.Orders;
import com.fds.repository.DeliveryDriversRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeliveryDriversService {

    private DeliveryDriversRepository deliveryDriversRepository;

    public List<DeliveryDrivers> getAllDeliveryDrivers() {
        return deliveryDriversRepository.findAll();
    }
    
    public DeliveryDrivers getDriverById(int id) {
    	DeliveryDrivers deliveryDriver= deliveryDriversRepository.findById(id).orElse(null);
    	if(deliveryDriver == null) {
			throw new DriverNotFoundException("Driver with id "+ id +" does not exist.");
		}
    	return deliveryDriver;
    }
    

    

    public List<Orders> getAllOrdersByDriverId(int driverId){
    	DeliveryDrivers driver = getDriverById(driverId);
    	return driver.getOrders();
    }

}
