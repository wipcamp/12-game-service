package com.wipcamp.gameservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;

@Entity
public class UserGame_Item implements Serializable {

	@ManyToOne
	@JoinColumn
	@JsonManagedReference
	@Id
	private UserGame userGame_id;
	@Id
	@ManyToOne
	@JoinColumn
	@JsonManagedReference
	private Items item_id;

	public UserGame_Item() {
	}

	public UserGame getUserGame_id() {
		return userGame_id;
	}

	public void setUserGame_id(UserGame userGame_id) {
		this.userGame_id = userGame_id;
	}

	public Items getItem_id() {
		return item_id;
	}

	public void setItem_id(Items item_id) {
		this.item_id = item_id;
	}
}
