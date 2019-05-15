package com.ibm.developer.passengerservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "passengers")
@SequenceGenerator(name = "passenger_id_generator", allocationSize = 1, initialValue = 10)
public class Passenger {

	@Id
	@GeneratedValue(generator = "passenger_id_generator")
	private long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "rating")
	private double rating;

	protected Passenger(long id, String firstName, String lastName, double rating) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.rating = rating;
	}

	protected Passenger(String firstName, String lastName, double rating) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.rating = rating;
	}

	protected Passenger() {
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public double getRating() {
		return rating;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

}
