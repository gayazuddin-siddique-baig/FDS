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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="coupons", 
	   indexes = {
			   @Index(name="coupon_code", columnList="coupon_code")
			   }
)
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	
	// toString()
	@Override
	public String toString() {
		return "Coupons [coupon_id=" + coupon_id + ", coupon_code=" + coupon_code + ", discount_amount=" + discount_amount + ", expiry_date=" + expiry_date + "]";
	}
}