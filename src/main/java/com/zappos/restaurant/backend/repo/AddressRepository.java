/**
 *
 */
package com.zappos.restaurant.backend.repo;

import org.springframework.data.repository.CrudRepository;

import com.zappos.restaurant.backend.entities.Address;

/**
 * @author Vis
 *
 */
public interface AddressRepository extends CrudRepository<Address, Long> {

}
