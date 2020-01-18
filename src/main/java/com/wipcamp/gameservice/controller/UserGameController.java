package com.wipcamp.gameservice.controller;

import com.wipcamp.gameservice.model.UserGame;
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
		public ResponseEntity<Date> setCooldownEnergyTime(@RequestParam(name="id")String id,@RequestParam(name="remainTime")long remainTime){
			return new ResponseEntity<Date>(service.setCooldownEnergyTime(id,remainTime),HttpStatus.OK);
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

		@GetMapping("/setVerifyCookies")
	public ResponseEntity<String> setVerifyCookies(@RequestParam(name="state")String state,@RequestParam(name="nonce")String nonce,
				HttpServletResponse response){
			Cookie cookieState = new Cookie("state", state);
			Cookie cookieNonce = new Cookie("nonce", nonce);

			cookieState.setHttpOnly(true);
			response.addCookie(cookieState);

			cookieNonce.setHttpOnly(true);
			response.addCookie(cookieNonce);
			return new ResponseEntity<String>("create verify cookies", HttpStatus.OK);
		}

	@GetMapping("/setTokenCookies")
	public void setTokenCookies(@RequestParam(name="token")String token,
			HttpServletResponse response){
		Cookie cookieToken = new Cookie("token", token);
		cookieToken.setSecure(true);
		cookieToken.setHttpOnly(true);
		response.addCookie(cookieToken);
	}



}
