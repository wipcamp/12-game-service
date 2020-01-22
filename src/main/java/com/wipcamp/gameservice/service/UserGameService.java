package com.wipcamp.gameservice.service;

import com.wipcamp.gameservice.model.UserGame;
import com.wipcamp.gameservice.model.UserGamePr;
import com.wipcamp.gameservice.repository.UserGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserGameService {

	private final int USED_SCORE_PER_EXP = 100;
	private final int EXP_ADDED_PER_LEVEL = 150;
	private final int MAX_ENERGY_ADDED_PER_LEVEL = 2;
	private final int STR_ADDED_PER_LEVEL = 1;
	private final int DEX_ADDED_PER_LEVEL = 1;
	private final int LUK_ADDED_PER_LEVEL = 1;
	private final int USED_ENERGY_PER_TIME = 1;
	private final int ENERGY_ADD_PER_TIME = 1;

    @Autowired
    UserGameRepository gameRepository;


	private UserGame findById(String id){
		return gameRepository.findById(id).get();
	}

	private UserGame checkUserExist(String id){
		Optional<UserGame> userGame = gameRepository.findById(id);
		return userGame.orElse(null);
	}

	private void createUserGame(String id){// need user from user_service
//		UserGame userGame = new UserGame();
//		userGame.setId(id);
//		userGame.setName(name);
//		userGame.setHighScore(0);
//		gameRepository.save(userGame);
	}

	public UserGame getUserGame(String id){
		if(checkUserExist(id)==null){
			return null;
		}else{
			return this.findById(id);
		}
	}

    private float convertScoreToExp(long score){
    	float exp =  score/this.USED_SCORE_PER_EXP;
    	return exp;
		}

	  private void addMaxEnergy(UserGame userGame){
    	userGame.setMaxEnergy(userGame.getMaxEnergy()+this.MAX_ENERGY_ADDED_PER_LEVEL);
			userGame.setEnergy(userGame.getMaxEnergy());
    }

    private void addMaxExp(UserGame userGame){
    	userGame.setMaxExp(userGame.getMaxExp()+this.EXP_ADDED_PER_LEVEL);
		}

	  private void addStatus(UserGame userGame){
    	userGame.setStr(userGame.getStr()+this.STR_ADDED_PER_LEVEL);
    	userGame.setDex(userGame.getDex()+this.DEX_ADDED_PER_LEVEL);
    	userGame.setLuk(userGame.getLuk()+this.LUK_ADDED_PER_LEVEL);
    }

    public void updateStatus(String id,String statusName,int quantity){
			UserGame userGame = this.checkUserExist(id);
			if(userGame!=null){
				if(userGame.getPoint()>=quantity) {
					if(statusName.equals("str")){
						userGame.setStr(userGame.getStr()+(this.STR_ADDED_PER_LEVEL*quantity));
						userGame.setPoint(userGame.getPoint()-quantity);
						gameRepository.save(userGame);
					}else  if(statusName.equals("dex")){
						userGame.setDex(userGame.getDex()+(this.DEX_ADDED_PER_LEVEL*quantity));
						userGame.setPoint(userGame.getPoint()-quantity);
						gameRepository.save(userGame);
					}else  if(statusName.equals("luk")){
						userGame.setLuk(userGame.getLuk()+(this.LUK_ADDED_PER_LEVEL*quantity));
						userGame.setPoint(userGame.getPoint()-quantity);
						gameRepository.save(userGame);
					}
				}
			}
		}

		private void checkLevelUp(UserGame userGame,long score){
			float exp = this.convertScoreToExp(score);
			int userMaxExp = userGame.getMaxExp();
			float userExpAdded = userGame.getExp() + exp;
			while(userExpAdded>=userMaxExp){
				userGame.setLevel(userGame.getLevel()+1);
				//this.addStatus(userGame);
				this.addPoint(userGame);
				this.addMaxEnergy(userGame);
				this.addMaxExp(userGame);
				userExpAdded = userExpAdded - userMaxExp;
				userMaxExp = userGame.getMaxExp();
			}
			userGame.setExp(userExpAdded);
			gameRepository.save(userGame);
		}

		public void addPoint(UserGame userGame){
			userGame.setPoint(userGame.getPoint()+1);
			gameRepository.save(userGame);
		}

		public boolean useEnergy(String id){
			UserGame userGame = this.checkUserExist(id);
			if(userGame==null){
				return false;
			}
			int remainEnergy = userGame.getEnergy();
			if(remainEnergy>=this.USED_ENERGY_PER_TIME){
				userGame.setEnergy(remainEnergy-this.USED_ENERGY_PER_TIME);
				this.gameRepository.save(userGame);
				return true;
			}else{
				return false;
			}
		}

	public boolean gameOver(String id, long score) {
		UserGame userGame = checkUserExist(id);
		if(userGame==null){
			return false;
		}else{
			int remainEnergy = userGame.getEnergy();
			int maxEnergy = userGame.getMaxEnergy();
			if(remainEnergy>=maxEnergy){
				Date newCooldown = new Date();
				newCooldown.setHours(newCooldown.getHours() + 1);
				this.setCooldownEnergyTime(id,newCooldown.getTime());
				 this.useEnergy(id);
				 this.checkLevelUp(userGame,score);
				 return true;
			}
				this.useEnergy(id);
			this.checkLevelUp(userGame,score);
			return true;
		}
	}

		private UserGame addExp(String id,long score){
    	Optional<UserGame> userGameLOptional = gameRepository.findById(id);
    	UserGame userGame = userGameLOptional.orElse(null);
    	if(userGame==null){
    		return null;
			}
    	this.checkLevelUp(userGame,score);
      this.gameRepository.save(userGame);
			return userGame;
		}

	public void setCooldownEnergyTime(String id,long newDate) {
		UserGame userGame = this.checkUserExist(id);
		if(this.checkUserExist(id)!=null){
			Date newCooldown = new Date(newDate);
			userGame.setCooldownTime(newCooldown);
			this.gameRepository.save(userGame);
	}
	}

	public Date getCooldowntime(String id) {
		UserGame userGame = this.checkUserExist(id);
		if(userGame!=null){
			return userGame.getCooldownTime();
		}else{
			return null;
		}
	}

	public void setEnergy(String id, int energy) {
		UserGame userGame = this.checkUserExist(id);
		if(userGame!=null){
			userGame.setEnergy(energy);
			this.gameRepository.save(userGame);
		}
	}


	//	public List<UserGame> findAll() {
//		return gameRepository.findAll();
//	}
}
