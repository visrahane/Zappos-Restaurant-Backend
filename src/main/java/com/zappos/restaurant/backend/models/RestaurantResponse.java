/**
 *
 */
package com.zappos.restaurant.backend.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zappos.restaurant.backend.entities.Restaurant;

/**
 * @author Vis
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RestaurantResponse {

	private Restaurant restaurant;

	private String message;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RestaurantResponse [restaurant=").append(restaurant).append(", message=").append(message)
		.append("]");
		return builder.toString();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
