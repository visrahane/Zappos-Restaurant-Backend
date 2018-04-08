/**
 *
 */
package com.zappos.restaurant.backend.api;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.zappos.restaurant.backend.ApplicationTests;
import com.zappos.restaurant.backend.api.RestaurantController;
import com.zappos.restaurant.backend.models.RestaurantResponse;
import com.zappos.restaurant.backend.service.RestaurantService;

import mockit.Cascading;
import mockit.Deencapsulation;
import mockit.Expectations;



/**
 * @author Vis
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTests.class)
public class RestaurantControllerTest {

	@Autowired
	private RestaurantController restaurantController;

	@Cascading
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	private RestaurantService restaurantService;

	@Before
	public void setUp() {
		Deencapsulation.setField(restaurantService, "redisTemplate", redisTemplate);
	}

	@Test
	public void testGetRestaurant_shouldReturnRecord_whenValidCall() {
		new Expectations() {
			{
				redisTemplate.opsForValue().get(anyLong);
				result = null;
				redisTemplate.opsForValue().set(anyString, any, anyLong, TimeUnit.DAYS);

			}
		};
		RestaurantResponse actualOutput = restaurantController.getRestaurant(1);
		Assert.assertNotNull(actualOutput);
	}

}
