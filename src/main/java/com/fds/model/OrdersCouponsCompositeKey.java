package com.fds.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OrdersCouponsCompositeKey implements Serializable {
	
	@Column(name="order_id")
	private int order_id;
	
	@Column(name="coupon_id")
	private int coupon_id;

	// getter and setter
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(int coupon_id) {
		this.coupon_id = coupon_id;
	}

	// constructors
	public OrdersCouponsCompositeKey() {}
	public OrdersCouponsCompositeKey(int order_id, int coupon_id) {
		this.order_id = order_id;
		this.coupon_id = coupon_id;
	}

	// toString()
	@Override
	public String toString() {
		return "OrdersCouponsCompositeKey [order_id=" + order_id + ", coupon_id=" + coupon_id + "]";
	}

	// hashCode()
	@Override
	public int hashCode() {
		return Objects.hash(coupon_id, order_id);
	}

	// equals()
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		OrdersCouponsCompositeKey other = (OrdersCouponsCompositeKey) obj;
		return coupon_id == other.coupon_id && order_id == other.order_id;
	}
}