package com.fds.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orderitems")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {

	@Id
	@Column(name="order_item_id")
	private int order_item_id;
	
	@Column(name="quantity")
	private int quantity;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="item_id")
	private MenuItems menuitems;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="order_id")
	private Orders orders;

	// toString()
	@Override
	public String toString() {
		return "OrderItems [order_item_id=" + order_item_id + ", quantity=" + quantity + "]";
	}
}