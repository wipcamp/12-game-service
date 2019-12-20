package com.wipcamp.gameservice.service;

import com.wipcamp.gameservice.model.UserGame;
import com.wipcamp.gameservice.repository.UserGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserGameService {

    @Autowired
    UserGameRepository gameRepository;

    public UserGame findById(String id){
			Optional<UserGame> userGame = gameRepository.findById(id);
			return userGame.orElse(null);
    }

    public List<UserGame> findAll(){
        return gameRepository.findAll();
    }


}
