package com.fds.repository;

import java.util.List;
import com.fds.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {
	
	@Query(
		value="SELECT * FROM customers WHERE customer_id=:customer_id",
		nativeQuery=true
	)
	Customers findByCustomerId(@Param("customer_id") int customer_id);
}
