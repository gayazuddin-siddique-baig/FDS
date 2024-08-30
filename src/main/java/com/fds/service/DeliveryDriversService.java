package com.fds.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fds.model.DeliveryDrivers;
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
    	return deliveryDriversRepository.findById(id).get();
    }
}
