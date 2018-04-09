/**
 *
 */
package com.zappos.restaurant.backend.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Vis
 *
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "restaurant_menu_item_mapping")
public class Restaurant_Menu_Item_Mapping implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "restaurant_id", nullable = false)
	private long restaurant_id;

	@Column(name = "menu_id", nullable = false)
	private long menuId;

	@Column(name = "menu_item_id", nullable = false)
	private long menuItemId;


	public long getRestaurant_id() {
		return restaurant_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public void setRestaurant_id(long restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public long getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(long menuItemId) {
		this.menuItemId = menuItemId;
	}

	public Restaurant_Menu_Item_Mapping() {
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Restaurant_Menu_Item_Mapping [id=").append(id).append(", restaurant_id=").append(restaurant_id)
		.append(", menuId=").append(menuId).append(", menuItemId=").append(menuItemId).append("]");
		return builder.toString();
	}

}
