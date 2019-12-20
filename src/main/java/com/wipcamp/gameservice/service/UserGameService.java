package com.wipcamp.gameservice.service;

import com.wipcamp.gameservice.model.UserGame;
import com.wipcamp.gameservice.repository.UserGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGameService {

    @Autowired
    UserGameRepository gameRepository;

    public UserGame findById(String id){
        return gameRepository.findById(id).get();
    }

    public List<UserGame> findAll(){
        return gameRepository.findAll();
    }



}
