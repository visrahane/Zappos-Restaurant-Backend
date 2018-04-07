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

/**
 * @author Vis
 *
 */
@RestController
@RequestMapping("menu")
public class MenuController {

	// get menu
	@RequestMapping(value = "/{id}", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public MenuResponse getMenu(@PathVariable("id") long id) {
		MenuResponse MenuResponse = new MenuResponse();
		// getMenu from Db

		return MenuResponse;
	}

	// create a new menu entry
	@RequestMapping(value = "", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public MenuResponse addMenu(@RequestBody MenuRequest MenuRequest) {
		MenuResponse MenuResponse = new MenuResponse();

		return MenuResponse;
	}

	// update menu Details
	@RequestMapping(value = "", method = { RequestMethod.PUT }, produces = MediaType.APPLICATION_JSON_VALUE)
	public MenuResponse updateMenu(MenuRequest MenuRequest) {
		MenuResponse MenuResponse = new MenuResponse();

		return MenuResponse;
	}

	// delete menu
	@RequestMapping(value = "{id}", method = { RequestMethod.DELETE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public MenuResponse removeMenu(@PathVariable("id") long id) {
		MenuResponse MenuResponse = new MenuResponse();

		return MenuResponse;
	}

}
