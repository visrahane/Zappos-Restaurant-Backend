/**
 *
 */
package com.zappos.restaurant.backend.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zappos.restaurant.backend.entities.Restaurant;

/**
 * @author Vis
 *
 */
@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

}
