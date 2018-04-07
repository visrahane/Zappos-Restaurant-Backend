/**
 *
 */
package com.zappos.restaurant.backend.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zappos.restaurant.backend.entities.Restaurant;
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

	private static final Logger LOGGER = LogManager.getLogger(RestaurantController.class.getName());

	@Autowired
	private RestaurantService restaurantService;


	@RequestMapping(value = "/{id}", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestaurantResponse getRestaurant(@PathVariable("id") long id) {
		LOGGER.info("GET Restaurant Request with id-" + id);
		RestaurantResponse restaurantResponse = new RestaurantResponse();
		// getUser from Db
		Restaurant restaurant = restaurantService.getRestaurant(id);
		prepareGetResponse(restaurantResponse, restaurant);
		LOGGER.info("GET Restaurant Response with id-" + id + " " + restaurant);
		return restaurantResponse;
	}

	private void prepareGetResponse(RestaurantResponse restaurantResponse, Restaurant restaurant) {
		restaurantResponse.setRestaurant(restaurant);
		if (restaurant.getName() == null) {
			restaurantResponse.setMessage("failure");
		} else {
			restaurantResponse.setMessage("success");
		}
	}

	// create a new restaurant entry
	@RequestMapping(value = "", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestaurantResponse addRestaurant(@RequestBody RestaurantRequest restaurantRequest) {
		LOGGER.info("POST Restaurant Request with data-" + restaurantRequest);
		RestaurantResponse restaurantResponse = new RestaurantResponse();
		Restaurant restaurant = restaurantService.save(restaurantRequest);
		if (restaurant.getId() == -1) {
			restaurantResponse.setMessage("Saved-" + false);
		}else{
			restaurantResponse.setRestaurant(restaurant);
			restaurantResponse.setMessage("Saved-" + true);
		}
		LOGGER.info("POST Restaurant Response" + restaurantResponse);
		return restaurantResponse;
	}

	// update Restaurant Details
	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT }, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestaurantResponse updateRestaurant(@PathVariable("id") long id, String name) {
		LOGGER.info("Update Restaurant Request with id-" + id);
		RestaurantResponse restaurantResponse = new RestaurantResponse();
		boolean updateStatus = restaurantService.updateName(id, name);
		restaurantResponse.setMessage("Updated-" + updateStatus);
		return restaurantResponse;
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestaurantResponse removeRestaurant(@PathVariable("id") long id) {
		RestaurantResponse restaurantResponse = new RestaurantResponse();
		boolean deleteStatus = restaurantService.delete(id);
		restaurantResponse.setMessage("Deleted-" + deleteStatus);
		return restaurantResponse;
	}

}
