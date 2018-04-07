/**
 *
 */
package com.zappos.restaurant.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public boolean save(RestaurantRequest restaurantRequest) {
		// TODO Auto-generated method stub
		boolean saveStatus = true;
		try {
			Address address = prepareAddressEntry(restaurantRequest);
			address=addressRepository.save(address);
			Restaurant restaurant = prepareRestaurantEntry(restaurantRequest, address);
			restaurantRepository.save(restaurant);
		} catch (Exception ex) {
			// problem while saving
			saveStatus = false;
		}
		return saveStatus;
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

}
