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
@Table(name="customers")
public class Customers {
	
	@Id
	@Column(name="customer_id")
	private int customer_id;
	
	@Column(name="customer_name")
	private String customer_name;
	
	@Column(name="customer_email")
	private String customer_email;
	
	@Column(name="customer_phone", length=20)
	private String customer_phone;
	
	@OneToMany(mappedBy="customers", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<DeliveryAddresses> deliveryaddresses;
	
	@OneToMany(mappedBy="customers", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Orders> orders;

	// getter and setter
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public String getCustomer_phone() {
		return customer_phone;
	}
	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	public List<DeliveryAddresses> getDeliveryaddresses() {
		return deliveryaddresses;
	}
	public void setDeliveryaddresses(List<DeliveryAddresses> deliveryaddresses) {
		this.deliveryaddresses = deliveryaddresses;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	// constructors
	public Customers() {}
	public Customers(int customer_id, String customer_name, String customer_email, String customer_phone, List<DeliveryAddresses> deliveryaddresses, List<Orders> orders) {
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_email = customer_email;
		this.customer_phone = customer_phone;
		this.deliveryaddresses = deliveryaddresses;
		this.orders = orders;
	}

	// toString()
	@Override
	public String toString() {
		return "Customers [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_email=" + customer_email + ", customer_phone=" + customer_phone + ", deliveryaddresses=" + deliveryaddresses + ", orders=" + orders + "]";
	}
}