package me.dhk.game.model.player;

import me.dhk.game.model.algo.IAlgorithm;
import me.dhk.game.service.IRemoteService;

import java.util.Random;

public class AutomaticPlayer extends Player {


    public AutomaticPlayer(String name, String opponentName, IAlgorithm algorithm, IRemoteService playService){
        super(name,opponentName,algorithm,playService);


    }

    @Override
    public void startPlay() {
        if (isStartingPlayer()){
            play(getRandomNumber());
        }
    }

    int getRandomNumber() {
        Random random= new Random();
        return Math.abs(random.nextInt());
    }


}
