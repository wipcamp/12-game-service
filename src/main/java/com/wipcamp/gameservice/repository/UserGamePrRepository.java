package com.wipcamp.gameservice.repository;

import com.wipcamp.gameservice.model.UserGamePr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGamePrRepository extends JpaRepository<UserGamePr,String> {



}
