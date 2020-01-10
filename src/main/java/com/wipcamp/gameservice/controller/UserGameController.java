package com.wipcamp.gameservice.controller;

import com.wipcamp.gameservice.model.Team;
import com.wipcamp.gameservice.model.UserGame;
import com.wipcamp.gameservice.service.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserGameController {

    @Autowired
    UserGameService service;

    @GetMapping("/profile")
    public UserGame getUserGameInformation(@RequestParam(name="id") String id){
    	return service.getUserGame(id);
    }

    @PutMapping("/gameGameOver")
		private UserGame addExp(@RequestParam(name="id")String id,@RequestParam(name="score")int score){
		long scoreLong = Long.valueOf(score);
		return service.addExp(id,scoreLong);
		}

//		@GetMapping("/checkUserGame")
//		private boolean checkUserGameByUserId(@RequestParam(name="userId")Object userId){
//    	return userId.camp;
//		}

    /*@GetMapping("/allProfile")
    public List<UserGame> getAll(){
        return service.findAll();
    }*/



}
