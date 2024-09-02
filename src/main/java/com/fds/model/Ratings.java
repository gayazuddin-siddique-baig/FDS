package com.fds.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ratings")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

	// toString()
	@Override
	public String toString() {
		return "Ratings [rating_id=" + rating_id + ", rating=" + rating + ", review=" + review + "]";
	}
}