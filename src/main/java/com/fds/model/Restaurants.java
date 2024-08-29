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

@Entity
@Table(name="restaurants")
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
	private List<MenuItems> menuItems;
	
	@OneToMany(mappedBy="restaurants", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Orders> orders;
	
	@OneToMany(mappedBy="restaurants", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Ratings> ratings;

	// getter and setter
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public String getRestaurant_name() {
		return restaurant_name;
	}
	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}
	public String getRestaurant_address() {
		return restaurant_address;
	}
	public void setRestaurant_address(String restaurant_address) {
		this.restaurant_address = restaurant_address;
	}
	public String getRestaurant_phone() {
		return restaurant_phone;
	}
	public void setRestaurant_phone(String restaurant_phone) {
		this.restaurant_phone = restaurant_phone;
	}
	public List<MenuItems> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<MenuItems> menuItems) {
		this.menuItems = menuItems;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public List<Ratings> getRatings() {
		return ratings;
	}
	public void setRatings(List<Ratings> ratings) {
		this.ratings = ratings;
	}

	// constructors
	public Restaurants() {}
	public Restaurants(int restaurant_id, String restaurant_name, String restaurant_address, String restaurant_phone, List<MenuItems> menuItems, List<Orders> orders, List<Ratings> ratings) {
		this.restaurant_id = restaurant_id;
		this.restaurant_name = restaurant_name;
		this.restaurant_address = restaurant_address;
		this.restaurant_phone = restaurant_phone;
		this.menuItems = menuItems;
		this.orders = orders;
		this.ratings = ratings;
	}
	
	// toString()
	@Override
	public String toString() {
		return "Restaurants [restaurant_id=" + restaurant_id + ", restaurant_name=" + restaurant_name + ", restaurant_address=" + restaurant_address + ", restaurant_phone=" + restaurant_phone + ", menuitems=" + menuItems + ", orders=" + orders + ", ratings=" + ratings + "]";
	}
}