/**
 *
 */
package com.zappos.restaurant.backend.service;

import com.zappos.restaurant.backend.entities.Restaurant;
import com.zappos.restaurant.backend.models.RestaurantRequest;

/**
 * @author Vis
 *
 */

public interface RestaurantService {

	Restaurant save(RestaurantRequest restaurantRequest);

	Restaurant getRestaurant(long id);

	boolean delete(long id);

	boolean updateName(long id, String name);

}
