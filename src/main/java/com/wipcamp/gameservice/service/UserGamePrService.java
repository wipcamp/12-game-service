package com.wipcamp.gameservice.service;

import com.wipcamp.gameservice.model.UserGame;
import com.wipcamp.gameservice.model.UserGamePr;
import com.wipcamp.gameservice.repository.UserGamePrRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserGamePrService {

	@Autowired
	UserGamePrRepository gamePrRepository;

	public UserGamePr findById(String id){
		return gamePrRepository.findById(id).get();
	}

	public UserGamePr checkUserExist(String id){
		Optional<UserGamePr> userGamePr = gamePrRepository.findById(id);
		return userGamePr.orElse(null);
	}

	public void createUserGamePr(String id,String name){
		UserGamePr userGamePr = new UserGamePr();
		userGamePr.setId(id);
		userGamePr.setName(name);
		userGamePr.setHighScore(0);
		gamePrRepository.save(userGamePr);
	}



}
