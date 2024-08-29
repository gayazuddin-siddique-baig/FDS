package com.fds.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="restaurants")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurants {

	@Id
	@Column(name="restaurant_id")
	private int restaurant_id;
	
	@Column(name="restaurant_name")
	private String restaurant_name;
	
	@Column(name="restaurant_address")
	private String restaurant_address;
	
	@Column(name="restaurant_phone", length=20)
	private String restaurant_phone;
	
	@OneToMany(mappedBy="restaurants", cascade=CascadeType.ALL)
	@JsonManagedReference
	@JsonIgnore
	private List<MenuItems> menuitems;
	
	@OneToMany(mappedBy="restaurants", cascade=CascadeType.ALL)
	@JsonManagedReference
	@JsonIgnore
	private List<Orders> orders;
	
	@OneToMany(mappedBy="restaurants", cascade=CascadeType.ALL)
	@JsonManagedReference
	@JsonIgnore
	private List<Ratings> ratings;

	// toString()
	@Override
	public String toString() {
		return "Restaurants [restaurant_id=" + restaurant_id + ", restaurant_name=" + restaurant_name + ", restaurant_address=" + restaurant_address + ", restaurant_phone=" + restaurant_phone + "]";
	}
}