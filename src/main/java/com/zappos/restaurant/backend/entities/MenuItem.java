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

import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Vis
 *
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "menu_item")
public class MenuItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "contents", nullable = false)
	@Type(type = "text")
	private String contents;

	@Column(name = "description", nullable = false)
	@Type(type = "text")
	private String description;

	@Column(name = "price", nullable = false)
	private int price;

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Column(nullable = false, name = "active", columnDefinition = "TINYINT(1)")
	private boolean active = true;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public MenuItem(long id) {
		this.id = id;
	}

	public MenuItem() {
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MenuItem [id=").append(id).append(", name=").append(name).append(", contents=").append(contents)
		.append(", description=").append(description).append(", price=").append(price).append(", active=")
		.append(active).append("]");
		return builder.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
