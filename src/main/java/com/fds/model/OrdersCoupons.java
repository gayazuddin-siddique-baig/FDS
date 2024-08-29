package com.fds.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orderscoupons")
public class OrdersCoupons {
	
	@EmbeddedId
	private OrdersCouponsCompositeKey composite_key;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="order_id", insertable=false, updatable=false)
	private Orders orders;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="coupon_id", insertable=false, updatable=false)
	private Coupons coupons;

	// getter and setter
	public OrdersCouponsCompositeKey getComposite_key() {
		return composite_key;
	}
	public void setComposite_key(OrdersCouponsCompositeKey composite_key) {
		this.composite_key = composite_key;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Coupons getCoupons() {
		return coupons;
	}
	public void setCoupons(Coupons coupons) {
		this.coupons = coupons;
	}

	// constructors
	public OrdersCoupons() {}
	public OrdersCoupons(OrdersCouponsCompositeKey composite_key, Orders orders, Coupons coupons) {
		this.composite_key = composite_key;
		this.orders = orders;
		this.coupons = coupons;
	}

	// toString()
	@Override
	public String toString() {
		return "OrdersCoupons [composite_key=" + composite_key + ", orders=" + orders + ", coupons=" + coupons + "]";
	}
}