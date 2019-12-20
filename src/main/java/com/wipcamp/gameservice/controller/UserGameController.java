package com.wipcamp.gameservice.controller;

import com.wipcamp.gameservice.model.UserGame;
import com.wipcamp.gameservice.service.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserGameController {

    @Autowired
    UserGameService service;

    @GetMapping(path = "/profile/{id}")
    public UserGame getUserGameInformation(@PathVariable String id){
    	return service.findById(id);
    }

    @GetMapping("/allProfile")
    public List<UserGame> getAll(){
        return service.findAll();
    }



}
