package com.fds.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="deliveryaddresses")
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

	// getter and setter
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getAddress_line1() {
		return address_line1;
	}
	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}
	public String getAddress_line2() {
		return address_line2;
	}
	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	
	// constructors
	public DeliveryAddresses() {}
	public DeliveryAddresses(int address_id, String address_line1, String address_line2, String city, String state, String postal_code, Customers customers) {
		this.address_id = address_id;
		this.address_line1 = address_line1;
		this.address_line2 = address_line2;
		this.city = city;
		this.state = state;
		this.postal_code = postal_code;
		this.customers = customers;
	}

	// toString()
	@Override
	public String toString() {
		return "DeliveryAddresses [address_id=" + address_id + ", address_line1=" + address_line1 + ", address_line2=" + address_line2 + ", city=" + city + ", state=" + state + ", postal_code=" + postal_code + ", customers=" + customers + "]";
	}
}