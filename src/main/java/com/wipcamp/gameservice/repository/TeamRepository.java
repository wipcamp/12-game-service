package com.wipcamp.gameservice.repository;

import com.wipcamp.gameservice.model.Team;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,String> {

}
