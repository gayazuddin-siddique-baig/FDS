package com.fds.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ratings")
public class Ratings {

	@Id
	@Column(name="rating_id")
	private int rating_id;
	
	@Column(name="rating")
	private int rating;
	
	@Lob
	@Column(name="review", columnDefinition="TEXT")
	private String review;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="order_id")
	private Orders orders;
	
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	@JsonBackReference
	private Restaurants restaurants;

	// getter and setter
	public int getRating_id() {
		return rating_id;
	}
	public void setRating_id(int rating_id) {
		this.rating_id = rating_id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Restaurants getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(Restaurants restaurants) {
		this.restaurants = restaurants;
	}
	
	// constructors
	public Ratings() {}
	public Ratings(int rating_id, int rating, String review, Orders orders, Restaurants restaurants) {
		this.rating_id = rating_id;
		this.rating = rating;
		this.review = review;
		this.orders = orders;
		this.restaurants = restaurants;
	}

	// toString()
	@Override
	public String toString() {
		return "Ratings [rating_id=" + rating_id + ", rating=" + rating + ", review=" + review + ", orders=" + orders + ", restaurants=" + restaurants + "]";
	}
}