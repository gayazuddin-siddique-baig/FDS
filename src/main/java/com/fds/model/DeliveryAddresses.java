package com.fds.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="deliveryaddresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAddresses {

	@Id
	@Column(name="address_id")
	private int address_id;
	
	@Column(name="address_line1")
	private String address_line1;
	
	@Column(name="address_line2")
	private String address_line2;
	
	@Column(name="city", length=100)
	private String city;
	
	@Column(name="state", length=100)
	private String state;
	
	@Column(name="postal_code", length=20)
	private String postal_code;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="customer_id")
	private Customers customers;

	// toString()
	@Override
	public String toString() {
		return "DeliveryAddresses [address_id=" + address_id + ", address_line1=" + address_line1 + ", address_line2=" + address_line2 + ", city=" + city + ", state=" + state + ", postal_code=" + postal_code + "]";
	}
}