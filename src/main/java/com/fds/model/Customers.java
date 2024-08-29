package com.fds.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

	// toString()
	@Override
	public String toString() {
		return "Customers [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_email=" + customer_email + ", customer_phone=" + customer_phone + "]";
	}
}