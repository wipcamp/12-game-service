package com.wipcamp.gameservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Items {

	@Id
	private String id;
	@Column(unique = true)
	private String item_name;
	private int item_str;
	private int item_dek;
	private int item_luk;
	@ManyToOne
	@JoinColumn
	@JsonManagedReference
	private Item_Types item_type_id;
	@OneToMany(mappedBy = "item_id")
	@JsonBackReference
	private List<UserGame_Item> userGameList;

	public Items() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getItem_str() {
		return item_str;
	}

	public void setItem_str(int item_str) {
		this.item_str = item_str;
	}

	public int getItem_dek() {
		return item_dek;
	}

	public void setItem_dek(int item_dek) {
		this.item_dek = item_dek;
	}

	public int getItem_luk() {
		return item_luk;
	}

	public void setItem_luk(int item_luk) {
		this.item_luk = item_luk;
	}

	public Item_Types getItem_type_id() {
		return item_type_id;
	}

	public void setItem_type_id(Item_Types item_type_id) {
		this.item_type_id = item_type_id;
	}

	public List<UserGame_Item> getUserGameList() {
		return userGameList;
	}

	public void setUserGameList(List<UserGame_Item> userGameList) {
		this.userGameList = userGameList;
	}
}
