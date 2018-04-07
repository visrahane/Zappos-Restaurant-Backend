/**
 *
 */
package com.zappos.restaurant.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zappos.restaurant.backend.models.RestaurantRequest;
import com.zappos.restaurant.backend.models.RestaurantResponse;
import com.zappos.restaurant.backend.service.RestaurantService;

/**
 * @author Vis
 *
 */
@RestController
@RequestMapping("restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@RequestMapping(value = "/{id}", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestaurantResponse getRestaurant(@PathVariable("id") long id) {
		RestaurantResponse restaurantResponse = new RestaurantResponse();
		// getUser from Db

		restaurantResponse.setMessage("GET");
		return restaurantResponse;
	}

	// create a new restaurant entry
	@RequestMapping(value = "", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestaurantResponse addRestaurant(@RequestBody RestaurantRequest restaurantRequest) {
		RestaurantResponse restaurantResponse = new RestaurantResponse();
		boolean save = restaurantService.save(restaurantRequest);
		restaurantResponse.setMessage("POST");
		return restaurantResponse;
	}

	// update Restaurant Details
	@RequestMapping(value = "{id}", method = { RequestMethod.PUT }, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestaurantResponse updateRestaurant(RestaurantRequest restaurantRequest) {
		RestaurantResponse restaurantResponse = new RestaurantResponse();
		restaurantResponse.setMessage("PUT");
		return restaurantResponse;
	}

	@RequestMapping(value = "{id}", method = { RequestMethod.DELETE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestaurantResponse removeRestaurant(@PathVariable("id") long id) {
		RestaurantResponse restaurantResponse = new RestaurantResponse();
		restaurantResponse.setMessage("DELETE");
		return restaurantResponse;
	}

}
