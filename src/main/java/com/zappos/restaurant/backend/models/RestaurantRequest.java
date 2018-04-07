/**
 *
 */
package com.zappos.restaurant.backend.models;

import javax.validation.constraints.NotEmpty;

/**
 * @author Vis
 *
 */
public class RestaurantRequest {
	private Long id;
	@NotEmpty
	private String country;
	@NotEmpty
	private String city;
	@NotEmpty
	private String state;
	@NotEmpty
	private String pin;
	@NotEmpty
	private String name;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RestaurantRequest [id=").append(id).append(", country=").append(country).append(", city=")
		.append(city).append(", state=").append(state).append(", pin=").append(pin).append(", name=")
		.append(name).append("]");
		return builder.toString();
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
