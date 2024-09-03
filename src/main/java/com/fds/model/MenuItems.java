package com.fds.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="menuitems")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItems {

	@Id
	@Column(name="item_id")
	private int item_id;
	
	@Column(name="item_name")
	private String item_name;
	
	@Lob
	@Column(name="item_description", columnDefinition="TEXT")
	private String item_description;
	
	@Column(name="item_price", precision=10, scale=2)
	private BigDecimal item_price;
	
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	@JsonBackReference
	private Restaurants restaurants;
	
	@OneToMany(mappedBy="menuitems", cascade=CascadeType.ALL)
	@JsonManagedReference
	@JsonIgnore
	private List<OrderItems> orderitems;

	// toString()
	@Override
	public String toString() {
		return "MenuItems [item_id=" + item_id + ", item_name=" + item_name + ", item_description=" + item_description + ", item_price=" + item_price + "]";
	}
}