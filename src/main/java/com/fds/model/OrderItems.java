package com.fds.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orderitems")
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

	// getter and setter
	public int getOrder_item_id() {
		return order_item_id;
	}
	public void setOrder_item_id(int order_item_id) {
		this.order_item_id = order_item_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public MenuItems getMenuItems() {
		return menuitems;
	}
	public void setMenuItems(MenuItems menuitems) {
		this.menuitems = menuitems;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	// constructors
	public OrderItems() {}
	public OrderItems(int order_item_id, int quantity, MenuItems menuitems, Orders orders) {
		this.order_item_id = order_item_id;
		this.quantity = quantity;
		this.menuitems = menuitems;
		this.orders = orders;
	}

	// toString()
	@Override
	public String toString() {
		return "OrderItems [order_item_id=" + order_item_id + ", quantity=" + quantity + ", menuitems=" + menuitems + ", orders=" + orders + "]";
	}
}