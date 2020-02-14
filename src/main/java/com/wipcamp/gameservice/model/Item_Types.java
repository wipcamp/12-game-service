package com.wipcamp.gameservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Item_Types {

	@Id
	private String id;
	@Column(unique = true)
	private String item_type_name;
	@OneToMany(mappedBy = "item_type_id")
	@JsonBackReference
	private List<Items> itemsList;

	public Item_Types() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItem_type_name() {
		return item_type_name;
	}

	public void setItem_type_name(String item_type_name) {
		this.item_type_name = item_type_name;
	}

	public List<Items> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<Items> itemsList) {
		this.itemsList = itemsList;
	}


}
