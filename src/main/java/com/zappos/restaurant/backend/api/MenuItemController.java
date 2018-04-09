/**
 *
 */
package com.zappos.restaurant.backend.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zappos.restaurant.backend.models.MenuItemRequest;
import com.zappos.restaurant.backend.models.MenuItemResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Vis
 *
 */
@RestController
@RequestMapping("menuItem")
@Api(value = "/menuItem")
public class MenuItemController {

	// get menu
	@ApiOperation(value = "accepts an id and outputs record", response = MenuItemResponse.class)
	@RequestMapping(value = "/{id}", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public MenuItemResponse getMenuItem(@PathVariable("id") long id) {
		MenuItemResponse menuItemResponse = new MenuItemResponse();
		// getMenu from Db

		return menuItemResponse;
	}

	// create a new menu item entry
	@ApiOperation(value = "accepts a record and outputs the status of save operation", response = MenuItemResponse.class)
	@RequestMapping(value = "", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public MenuItemResponse addMenuItem(@RequestBody MenuItemRequest MenuRequest) {
		MenuItemResponse menuItemResponse = new MenuItemResponse();
		// getMenu from Db

		return menuItemResponse;
	}

	// update menu Details
	@ApiOperation(value = "accepts an id and name and outputs updated record", response = MenuItemResponse.class)
	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT }, produces = MediaType.APPLICATION_JSON_VALUE)
	public MenuItemResponse updateMenuItemName(@PathVariable("id") long id, String name) {
		MenuItemResponse menuItemResponse = new MenuItemResponse();
		// getMenu from Db

		return menuItemResponse;
	}

	// delete menu
	@ApiOperation(value = "accepts an id and deletes that record from db", response = MenuItemResponse.class)
	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public MenuItemResponse removeMenuItem(@PathVariable("id") long id) {
		MenuItemResponse menuItemResponse = new MenuItemResponse();
		// getMenu from Db

		return menuItemResponse;
	}

}
