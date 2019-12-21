package com.wipcamp.gameservice.service;

import com.wipcamp.gameservice.model.UserGame;
import com.wipcamp.gameservice.model.UserGamePr;
import com.wipcamp.gameservice.repository.UserGamePrRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserGamePrService {

	@Autowired
	UserGamePrRepository gamePrRepository;

	private UserGamePr findById(String id){
		return gamePrRepository.findById(id).get();
	}

	private UserGamePr checkUserExist(String id){
		Optional<UserGamePr> userGamePr = gamePrRepository.findById(id);
		return userGamePr.orElse(null);
	}

	private void createUserGamePr(String id,String name){
		UserGamePr userGamePr = new UserGamePr();
		userGamePr.setId(id);
		userGamePr.setName(name);
		userGamePr.setHighScore(0);
		gamePrRepository.save(userGamePr);
	}

	public UserGamePr getUserGamePr(String id,String name){
		if(checkUserExist(id)==null){
			createUserGamePr(id,name);
			return this.findById(id);
		}else{
			return this.findById(id);
		}
	}


	public List<UserGamePr> getScoreBoard(){
		Page<UserGamePr> page = gamePrRepository.findAll(PageRequest.of(0,5,Sort.by(Sort.Direction.DESC,"highScore")));
		return page.toList();
	}

	public List<UserGamePr> findAllProfilePr(){
		return gamePrRepository.findAll();
	}

	private void addNewScore(String id, long score) {
		UserGamePr userGamePr = gamePrRepository.findById(id).get();
		userGamePr.setHighScore(score);
		gamePrRepository.save(userGamePr);
	}

	private boolean checkScore(String id,long score){
		UserGamePr userGamePr = gamePrRepository.findById(id).get();
		if(score <= userGamePr.getHighScore()){
			return false;
		}else{
			return true;
		}
	}

	public void getNewScore(String id,long score){
		if(checkScore(id,score)){
			this.addNewScore(id,score);
		}
	}


}
