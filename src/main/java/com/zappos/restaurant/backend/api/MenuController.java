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

import com.zappos.restaurant.backend.models.MenuRequest;
import com.zappos.restaurant.backend.models.MenuResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Vis
 *
 */
@RestController
@RequestMapping("menu")
@Api(value = "/menu")
public class MenuController {

	// get menu
	@ApiOperation(value = "accepts an id and outputs record", response = MenuResponse.class)
	@RequestMapping(value = "/{id}", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public MenuResponse getMenu(@PathVariable("id") long id) {
		MenuResponse menuResponse = new MenuResponse();
		return menuResponse;
	}

	// create a new menu entry
	@ApiOperation(value = "accepts a record and outputs the status of save operation", response = MenuResponse.class)
	@RequestMapping(value = "", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public MenuResponse addMenu(@RequestBody MenuRequest MenuRequest) {
		MenuResponse menuResponse = new MenuResponse();
		return menuResponse;
	}

	// update menu Details
	@ApiOperation(value = "accepts an id and name and outputs updated record", response = MenuResponse.class)
	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT }, produces = MediaType.APPLICATION_JSON_VALUE)
	public MenuResponse updateMenu(@PathVariable("id") long id, String name) {
		MenuResponse menuResponse = new MenuResponse();

		return menuResponse;
	}

	// delete menu
	@ApiOperation(value = "accepts an id and deletes that record from db", response = MenuResponse.class)
	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public MenuResponse removeMenu(@PathVariable("id") long id) {
		MenuResponse menuResponse = new MenuResponse();

		return menuResponse;
	}

}
