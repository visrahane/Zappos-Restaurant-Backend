/**
 *
 */
package com.zappos.restaurant.backend.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.zappos.restaurant.backend.entities.Address;
import com.zappos.restaurant.backend.entities.Restaurant;
import com.zappos.restaurant.backend.models.RestaurantRequest;
import com.zappos.restaurant.backend.repo.AddressRepository;
import com.zappos.restaurant.backend.repo.RestaurantRepository;

/**
 * @author Vis
 *
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

	private static final Logger LOGGER = LogManager.getLogger(RestaurantServiceImpl.class.getName());

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Value("${redis.expiry.time}")
	private int expiryTime;

	@Override
	public Restaurant save(RestaurantRequest restaurantRequest) {
		Restaurant restaurant = new Restaurant();
		try {
			Address address = prepareAddressEntry(restaurantRequest);
			address=addressRepository.save(address);
			restaurant = prepareRestaurantEntry(restaurantRequest, address);
			restaurant.setId(restaurantRepository.save(restaurant).getId());
		} catch (Exception ex) {
			// problem while saving
			LOGGER.error("Exception while saving restaurant entry-" + ex);
			restaurant.setId(-1);
		}
		return restaurant;
	}

	private Restaurant prepareRestaurantEntry(RestaurantRequest restaurantRequest, Address address) {
		Restaurant restaurant = new Restaurant();
		restaurant.setAddressId(address.getId());
		restaurant.setName(restaurantRequest.getName());
		return restaurant;
	}

	private Address prepareAddressEntry(RestaurantRequest restaurantRequest) {
		Address address = new Address();
		address.setCity(restaurantRequest.getCity());
		address.setCountry(restaurantRequest.getCountry());
		address.setPin(restaurantRequest.getPin());
		address.setState(restaurantRequest.getState());
		return address;
	}

	@Override
	public Restaurant getRestaurant(long id) {
		// check in cache. if yes, return else go for db
		Restaurant restaurant = null;
		restaurant = getFromCache(id);
		if (!entryFound(restaurant)) {
			Optional<Restaurant> optionalObj = null;
			try {
				optionalObj = restaurantRepository.findById(id);
				restaurant = optionalObj.get();
				if (entryFound(restaurant)) {
					persistToCache(restaurant);
				}
			} catch (NoSuchElementException ex) {
				LOGGER.info("No records with id-" + id);
			} catch (Exception ex) {
				LOGGER.error("Exception while fetching records with id-" + id + ex);
			}
		}
		return restaurant;
	}

	private void persistToCache(Restaurant restaurant) {
		try {
			redisTemplate.opsForValue().set(Long.toString(restaurant.getId()), restaurant, expiryTime,
					TimeUnit.DAYS);
		} catch (final Exception ex) {
			LOGGER.error("Exception while persisting restaurant to redis-" + ex);
		}
	}

	private boolean entryFound(Restaurant restaurant) {
		return restaurant != null ? true : false;
	}

	private Restaurant getFromCache(long id) {
		Restaurant restaurant = null;
		try {
			restaurant = (Restaurant) redisTemplate.opsForValue().get(Long.toString(id));
		} catch (final Exception ex) {
			LOGGER.error("Exception while fetching restaurant from redis-" + ex);
		}
		return restaurant;
	}

	@Override
	public boolean updateName(long id, String name) {
		boolean updateStatus = false;
		Restaurant restaurant = getRestaurant(id);
		if (restaurant != null) {
			restaurant.setName(name);
			try {
				restaurantRepository.save(restaurant);
				updateStatus = true;
			} catch (Exception ex) {
				LOGGER.error("Exception while updating restaurant data-" + ex);
			}
		}
		return updateStatus;

	}

	@Override
	public boolean delete(long id) {
		boolean deleteStatus = false;
		Restaurant restaurant = getRestaurant(id);
		if (restaurant != null) {
			restaurant.setActive(false);
			try {
				restaurantRepository.save(restaurant);
				deleteStatus = true;
			} catch (Exception ex) {
				LOGGER.error("Exception while deleting restaurant data-" + ex);
			}
		}
		return deleteStatus;
	}

}
