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
@Table(name="deliverydrivers")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

	// toString()
	@Override
	public String toString() {
		return "DeliveryDrivers [driver_id=" + driver_id + ", driver_name=" + driver_name + ", driver_phone=" + driver_phone + ", driver_vehicle=" + driver_vehicle + "]";
	}
}