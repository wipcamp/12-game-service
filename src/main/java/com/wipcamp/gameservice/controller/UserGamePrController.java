package com.wipcamp.gameservice.controller;

import com.wipcamp.gameservice.model.UserGamePr;
import com.wipcamp.gameservice.service.UserGamePrService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
public class UserGamePrController {

	@Autowired
	UserGamePrService service;

 @PutMapping("/profileGamePr")
	public UserGamePr getUserGamePr(@RequestParam(name="id") String id,@RequestParam(name="name") String name){
 	return service.getUserGamePr(id,name);
 }

 @GetMapping("/scoreBoard")
	public List<UserGamePr> getScoreBoard(){
 	return service.getScoreBoard();
 }

 @GetMapping("/getHighScore")
 public int gethighScore(@RequestParam(name="id") String id){
 	return service.getHighScore(id);
 }

 /*@GetMapping("/allProfileGamePr")
	public List<UserGamePr> getAllProfilePr(){
 	return service.findAllProfilePr();
 }*/

@GetMapping("/checkUserPr")
public boolean checkUserPr(@RequestParam(name="id")String id){
	return service.checkUserPr(id);
}

 @PutMapping("/gamePrGameOver")
	public void addScore(@RequestParam(name="id")String id,@RequestParam(name="score")int score){
 	service.getNewScore(id,score);
 }

}
