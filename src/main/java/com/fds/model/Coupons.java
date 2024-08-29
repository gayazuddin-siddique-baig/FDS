package com.fds.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="coupons", 
	   indexes = {
			   @Index(name="coupon_code", columnList="coupon_code")
			   }
)
public class Coupons {
	
	@Id
	@Column(name="coupon_id")
	private int coupon_id;
	
	@Column(name="coupon_code", length=50)
	private String coupon_code;
	
	@Column(name="discount_amount", precision=10, scale=2)
	private BigDecimal discount_amount;
	
	@Temporal(TemporalType.DATE)
	@Column(name="expiry_date")
	private Date expiry_date;
	
	@OneToMany(mappedBy="coupons", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<OrdersCoupons> orderscoupons;
	
	// getter and setter
	public int getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(int coupon_id) {
		this.coupon_id = coupon_id;
	}
	public String getCoupon_code() {
		return coupon_code;
	}
	public void setCoupon_code(String coupon_code) {
		this.coupon_code = coupon_code;
	}
	public BigDecimal getDiscount_amount() {
		return discount_amount;
	}
	public void setDiscount_amount(BigDecimal discount_amount) {
		this.discount_amount = discount_amount;
	}
	public Date getExpiry_date() {
		return expiry_date;
	}
	public List<OrdersCoupons> getOrderscoupons() {
		return orderscoupons;
	}
	public void setOrderscoupons(List<OrdersCoupons> orderscoupons) {
		this.orderscoupons = orderscoupons;
	}
	
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	
	// constructors
	public Coupons() {}
	public Coupons(int coupon_id, String coupon_code, BigDecimal discount_amount, Date expiry_date) {
		this.coupon_id = coupon_id;
		this.coupon_code = coupon_code;
		this.discount_amount = discount_amount;
		this.expiry_date = expiry_date;
	}
	
	// toString()
	@Override
	public String toString() {
		return "Coupons [coupon_id=" + coupon_id + ", coupon_code=" + coupon_code + ", discount_amount=" + discount_amount + ", expiry_date=" + expiry_date + "]";
	}
}