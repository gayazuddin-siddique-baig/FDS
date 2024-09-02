package com.fds.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orderscoupons")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

	// toString()
	@Override
	public String toString() {
		return "OrdersCoupons [composite_key=" + composite_key + "]";
	}
}