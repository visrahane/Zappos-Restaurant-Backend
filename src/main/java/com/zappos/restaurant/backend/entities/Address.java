/**
 *
 */
package com.zappos.restaurant.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vis
 *
 */
@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "country", nullable = false)
	private String country;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "pin", nullable = false)
	private String pin;

	@Column(name = "state", nullable = false)
	private String state;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [id=").append(id).append(", country=").append(country).append(", city=").append(city)
		.append(", pin=").append(pin).append(", state=").append(state).append("]");
		return builder.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
