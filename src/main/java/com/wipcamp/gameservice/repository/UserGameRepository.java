package com.wipcamp.gameservice.repository;

import com.wipcamp.gameservice.model.UserGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGameRepository extends JpaRepository<UserGame,String> {
}
