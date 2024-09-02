package com.fds.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
	
	@Id
	@Column(name="order_id")
	private int order_id;
	
	@Column(name="order_date", columnDefinition="DATETIME")
	private LocalDateTime order_date;
	
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
	@JsonIgnore
	private List<Ratings> ratings;
	
	@OneToMany(mappedBy="orders", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<OrderItems> orderitems;
	
	@OneToMany(mappedBy="orders", cascade=CascadeType.ALL)
	@JsonManagedReference
	@JsonIgnore
	private List<OrdersCoupons> orderscoupons;

	// toString()
	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", order_date=" + order_date + ", order_status=" + order_status + "]";
	}
}