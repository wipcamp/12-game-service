package com.wipcamp.gameservice.service;

import com.wipcamp.gameservice.model.UserGame;
import com.wipcamp.gameservice.repository.UserGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserGameService {

	private final int USED_SCORE_PER_EXP = 100;
	private final int EXP_ADDED_PER_LEVEL = 150;
	private final int ENERGY_ADDED_PER_LEVEL = 2;
	private final int STR_ADDED_PER_LEVEL = 1;
	private final int DEX_ADDED_PER_LEVEL = 1;
	private final int LUK_ADDED_PER_LEVEL = 1;

    @Autowired
    UserGameRepository gameRepository;

    public UserGame findById(String id){
			Optional<UserGame> userGame = gameRepository.findById(id);
			return userGame.orElse(null);
    }

    public List<UserGame> findAll(){
        return gameRepository.findAll();
    }

    private float convertScoreToExp(long score){
    	float exp =  score/this.USED_SCORE_PER_EXP;
    	return exp;
		}

	  private void addMaxEnergy(UserGame userGame){
    	userGame.setMaxEnergy(userGame.getMaxEnergy()+this.ENERGY_ADDED_PER_LEVEL);
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

		private void checkLevelUp(UserGame userGame,long score){
			float exp = this.convertScoreToExp(score);
			int userMaxExp = userGame.getMaxExp();
			float userExpAdded = userGame.getExp() + exp;
			while(userExpAdded>=userMaxExp){
				userGame.setLevel(userGame.getLevel()+1);
				this.addStatus(userGame);
				this.addMaxEnergy(userGame);
				this.addMaxExp(userGame);
				userExpAdded = userExpAdded - userMaxExp;
				userMaxExp = userGame.getMaxExp();
			}
			userGame.setExp(userExpAdded);
		}

		public UserGame addExp(String id,long score){
    	Optional<UserGame> userGameLOptional = gameRepository.findById(id);
    	UserGame userGame = userGameLOptional.orElse(null);
    	if(userGame==null){
    		return null;
			}
    	this.checkLevelUp(userGame,score);
      this.gameRepository.save(userGame);
			return userGame;
		}

}
