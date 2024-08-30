package com.fds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fds.model.DeliveryDrivers;

@Repository
public interface DeliveryDriversRepository extends JpaRepository<DeliveryDrivers, Integer> {
    // No additional methods needed for now, JpaRepository provides basic CRUD operations
}
