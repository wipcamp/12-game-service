package com.wipcamp.gameservice.controller;

import com.wipcamp.gameservice.model.UserGame;
import com.wipcamp.gameservice.service.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
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

//    @GetMapping("/allProfile")
//    public List<UserGame> getAll(){
//        return service.findAll();
//    }

		@RequestMapping("/useEnergy")
		@ResponseStatus(value = HttpStatus.OK)
		 public void useEnergy(@RequestParam(name="id")String id){
			 service.useEnergy(id);
		 }

		 @RequestMapping("/setCooldownEnergyTime")
		@ResponseStatus(value = HttpStatus.OK)
		public void setCooldownEnergyTime(@RequestParam(name="id")String id){
			service.setCooldownEnergyTime(id);
		}

	@RequestMapping("/setEnergy")
	@ResponseStatus(value = HttpStatus.OK)
	public void setEnergy(@RequestParam(name="id")String id,@RequestParam(name="energy")int energy){
		service.setEnergy(id,energy);
	}

		@GetMapping("/getCooldowntime")
		public Date getCooldowntime(@RequestParam(name="id") String id){
			return service.getCooldowntime(id);
		}

}
