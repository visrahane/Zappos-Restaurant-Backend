/**
 *
 */
package com.zappos.restaurant.backend.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zappos.restaurant.backend.models.RestaurantRequest;
import com.zappos.restaurant.backend.models.RestaurantResponse;

/**
 * @author Vis
 *
 */
@RestController
@RequestMapping("restaurant")
public class RestaurantController {

	@RequestMapping(value = "", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestaurantResponse getRestaurant(RestaurantRequest restaurantRequest) {
		RestaurantResponse restaurantResponse = new RestaurantResponse();
		restaurantResponse.setMessage("Demo");
		return restaurantResponse;
	}

}
