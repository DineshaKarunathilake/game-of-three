package me.dhk.game.model;

import me.dhk.game.model.algo.IAlgorithm;
import me.dhk.game.service.IRemoteService;

import java.util.Random;

public class AutomaticPlayer extends Player {


    public AutomaticPlayer(String name, String opponentName, IAlgorithm algorithm, IRemoteService playService){
        super(name,opponentName,algorithm,playService);
        if (isStartingPlayer()){
            Random random= new Random();
            play(random.nextInt(1000));
        }
    }

    boolean isStartingPlayer(){
        return this.name.compareTo(opponentName) > 0;

    }

}
