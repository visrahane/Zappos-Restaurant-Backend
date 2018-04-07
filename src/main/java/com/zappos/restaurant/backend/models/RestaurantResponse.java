/**
 *
 */
package com.zappos.restaurant.backend.models;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Vis
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RestaurantResponse {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
