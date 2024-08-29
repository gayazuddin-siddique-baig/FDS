package com.fds.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	@Column(name="order_id")
	private int order_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_date", columnDefinition="DATETIME")
	private Date order_date;
	
	@Column(name="order_status", length=50)
	private String order_status;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="customer_id")
	private Customers customers;
	
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	@JsonBackReference
	private Restaurants restaurants;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="delivery_driver_id")
	private DeliveryDrivers deliverydrivers;
	
	@OneToMany(mappedBy="orders", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Ratings> ratings;
	
	@OneToMany(mappedBy="orders", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<OrderItems> orderitems;
	
	@OneToMany(mappedBy="orders", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<OrdersCoupons> orderscoupons;

	// getters and setters
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	public Restaurants getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(Restaurants restaurants) {
		this.restaurants = restaurants;
	}
	public DeliveryDrivers getDeliveryDrivers() {
		return deliverydrivers;
	}
	public void setDeliveryDrivers(DeliveryDrivers deliverydrivers) {
		this.deliverydrivers = deliverydrivers;
	}
	public List<Ratings> getRatings() {
		return ratings;
	}
	public void setRatings(List<Ratings> ratings) {
		this.ratings = ratings;
	}
	public List<OrderItems> getOrderItems() {
		return orderitems;
	}
	public void setOrderItems(List<OrderItems> orderitems) {
		this.orderitems = orderitems;
	}
	public List<OrdersCoupons> getOrdersCoupons() {
		return orderscoupons;
	}
	public void setOrdersCoupons(List<OrdersCoupons> orderscoupons) {
		this.orderscoupons = orderscoupons;
	}

	// constructors
	public Orders() {}
	public Orders(int order_id, Date order_date, String order_status, Customers customers, Restaurants restaurants, DeliveryDrivers deliverydrivers, List<Ratings> ratings, List<OrderItems> orderitems, List<OrdersCoupons> orderscoupons) {
		this.order_id = order_id;
		this.order_date = order_date;
		this.order_status = order_status;
		this.customers = customers;
		this.restaurants = restaurants;
		this.deliverydrivers = deliverydrivers;
		this.ratings = ratings;
		this.orderitems = orderitems;
		this.orderscoupons = orderscoupons;
	}

	// toString()
	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", order_date=" + order_date + ", order_status=" + order_status + ", customers=" + customers + ", restaurants=" + restaurants + ", deliverydrivers=" + deliverydrivers + ", ratings=" + ratings + ", orderitems=" + orderitems + ", orderscoupons=" + orderscoupons + "]";
	}
}