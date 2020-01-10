package com.wipcamp.gameservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Team {

	@Id
	private String teamId;
	private String teamName;
	private boolean status;
	private int score;
	private int health;
	private int maxHealth;
	@OneToMany(mappedBy = "team")
	@JsonBackReference
	private List<UserGame> userGameList;

	public Team() {
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public List<UserGame> getUserGameList() {
		return userGameList;
	}

	public void setUserGameList(List<UserGame> userGameList) {
		this.userGameList = userGameList;
	}
}
