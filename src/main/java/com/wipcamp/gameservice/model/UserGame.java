package com.wipcamp.gameservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wipcamp.gameservice.model.Team;


import java.util.Date;
import java.util.List;

@Entity
public class UserGame {


	@Id
	private String id;
	@ManyToOne
	@JoinColumn
	@JsonManagedReference
	private Team team;
	private int level;
	private int maxExp;
	private float exp;
	private int str;
	private int dex;
	private int luk;
	private int energy;
	private int maxEnergy;
	private int point;
	private String name;
	private Date cooldownTime;
	@OneToMany(mappedBy = "userGame_id")
	@JsonBackReference
	private List<UserGame_Item> itemList;



	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public UserGame() {
	}

	public Date getCooldownTime() {
		return cooldownTime;
	}

	public void setCooldownTime(Date cooldownTime) {
		this.cooldownTime = cooldownTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public float getExp() {
		return exp;
	}

	public void setExp(float exp) {
		this.exp = exp;
	}

	public int getMaxExp() {
		return maxExp;
	}

	public void setMaxExp(int maxExp) {
		this.maxExp = maxExp;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getLuk() {
		return luk;
	}

	public void setLuk(int luk) {
		this.luk = luk;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getMaxEnergy() {
		return maxEnergy;
	}

	public void setMaxEnergy(int maxEnergy) {
		this.maxEnergy = maxEnergy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserGame_Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<UserGame_Item> itemList) {
		this.itemList = itemList;
	}
}


