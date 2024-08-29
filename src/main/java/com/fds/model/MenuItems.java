package com.fds.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;

@Entity
@Table(name="menuitems")
public class MenuItems {

	@Id
	@Column(name="item_id")
	private int item_id;
	
	@Column(name="item_name")
	private String item_name;
	
	@Lob
	@Column(name="item_description", columnDefinition="TEXT")
	private String item_description;
	
	@Column(name="item_price", precision=10, scale=2)
	private BigDecimal item_price;
	
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	@JsonBackReference
	private Restaurants restaurants;
	
	@OneToMany(mappedBy="menuitems", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<OrderItems> orderitems;

	// getter and setter
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_description() {
		return item_description;
	}
	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}
	public BigDecimal getItem_price() {
		return item_price;
	}
	public void setItem_price(BigDecimal item_price) {
		this.item_price = item_price;
	}
	public Restaurants getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(Restaurants restaurants) {
		this.restaurants = restaurants;
	}
	public List<OrderItems> getOrderItems() {
		return orderitems;
	}
	public void setOrderItems(List<OrderItems> orderitems) {
		this.orderitems = orderitems;
	}

	// constructors
	public MenuItems() {}
	public MenuItems(int item_id, String item_name, String item_description, BigDecimal item_price, Restaurants restaurants, List<OrderItems> orderitems) {
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_description = item_description;
		this.item_price = item_price;
		this.restaurants = restaurants;
		this.orderitems = orderitems;
	}

	// toString()
	@Override
	public String toString() {
		return "MenuItems [item_id=" + item_id + ", item_name=" + item_name + ", item_description=" + item_description + ", item_price=" + item_price + ", restaurants=" + restaurants + ", orderitems=" + orderitems + "]";
	}
}