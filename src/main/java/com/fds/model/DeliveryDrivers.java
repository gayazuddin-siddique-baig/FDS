package com.fds.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="deliverydrivers")
public class DeliveryDrivers {

	@Id
	@Column(name="driver_id")
	private int driver_id;
	
	@Column(name="driver_name")
	private String driver_name;
	
	@Column(name="driver_phone", length=20)
	private String driver_phone;
	
	@Column(name="driver_vehicle")
	private String driver_vehicle;
	
	@OneToMany(mappedBy="deliverydrivers", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Orders> orders;

	// getter and setter
	public int getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}
	public String getDriver_name() {
		return driver_name;
	}
	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	public String getDriver_phone() {
		return driver_phone;
	}
	public void setDriver_phone(String driver_phone) {
		this.driver_phone = driver_phone;
	}
	public String getDriver_vehicle() {
		return driver_vehicle;
	}
	public void setDriver_vehicle(String driver_vehicle) {
		this.driver_vehicle = driver_vehicle;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	// constructors
	public DeliveryDrivers() {}
	public DeliveryDrivers(int driver_id, String driver_name, String driver_phone, String driver_vehicle, List<Orders> orders) {
		this.driver_id = driver_id;
		this.driver_name = driver_name;
		this.driver_phone = driver_phone;
		this.driver_vehicle = driver_vehicle;
		this.orders = orders;
	}

	// toString()
	@Override
	public String toString() {
		return "DeliveryDrivers [driver_id=" + driver_id + ", driver_name=" + driver_name + ", driver_phone=" + driver_phone + ", driver_vehicle=" + driver_vehicle + ", orders=" + orders + "]";
	}
}