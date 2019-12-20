package com.wipcamp.gameservice.controller;

import com.wipcamp.gameservice.model.UserGamePr;
import com.wipcamp.gameservice.service.UserGamePrService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserGamePrController {

	@Autowired
	UserGamePrService service;

 @PostMapping("/gamePr")
	public UserGamePr getUserGamePr(@RequestParam(name="id") String id,@RequestParam(name="name") String name){
 	if(service.checkUserExist(id)){
 		return service.findById(id);
	}else{
 		service.createUserGamePr(id,name);
 		return service.findById(id);
	}
 }

}
