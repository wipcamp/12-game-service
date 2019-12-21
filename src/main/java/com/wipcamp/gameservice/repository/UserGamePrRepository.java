package com.wipcamp.gameservice.repository;

import com.wipcamp.gameservice.model.UserGamePr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGamePrRepository extends JpaRepository<UserGamePr,String> {


}
