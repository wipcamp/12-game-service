package com.wipcamp.gameservice.controller;

import com.wipcamp.gameservice.model.Items;
import com.wipcamp.gameservice.model.UserGame;
import com.wipcamp.gameservice.model.Team;
import com.wipcamp.gameservice.service.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Collection;
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

    @PutMapping("/gameOver")
		private ResponseEntity<Boolean> gameOver(@RequestParam(name="id")String id,@RequestParam(name="score")int score){
		long scoreLong = Long.valueOf(score);
		return new ResponseEntity<Boolean>(service.gameOver(id,scoreLong),HttpStatus.OK);
		}

		@GetMapping("/scoreBoardCamp")
		private ResponseEntity<List<Team>> getScoreBoard(){
     	return new ResponseEntity<List<Team>>(service.getScoreBoard(),HttpStatus.OK);
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

	@PutMapping("/setCooldownEnergyTime")
	@ResponseStatus(value = HttpStatus.OK)
	public void setCooldownEnergyTime(@RequestParam(name="id")String id,long newDate){
		service.setCooldownEnergyTime(id,newDate);
	}

	@PutMapping("/updateStatus")
	@ResponseStatus(value = HttpStatus.OK)
	public  void updateStatus(@RequestParam(name="id")String id,@RequestParam(name="status")String status,@RequestParam(name="quantity")int quantity){
     	service.updateStatus(id,status,quantity);
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

 @GetMapping("/getDecorationItems")
 private ResponseEntity<List<Items>> getAllDecorationItems(){
     	return new ResponseEntity<List<Items>>(service.getDecorationItems(),HttpStatus.OK);
 }

	@GetMapping("/getStatusItems")
	private ResponseEntity<List<Items>> getAllStatusItems(){
		return new ResponseEntity<List<Items>>(service.getStatusItems(),HttpStatus.OK);
	}

	@GetMapping("/getUserItems")
	private ResponseEntity<List<Items>> getAllUserItems(@RequestParam(name="id")String id){
     	return new ResponseEntity<List<Items>>(service.getAllUserItems(id),HttpStatus.OK);
	}

	@GetMapping("/checkUser")
	public boolean checkUser(@RequestParam(name="id")String id){
     	if(service.checkUserExist(id)==null){
     		return false;
			}else{
     		return true;
			}
	}





}
