package me.dhk.game.model;

import me.dhk.game.model.algo.IAlgorithm;
import me.dhk.game.service.IRemoteService;


public class ManualPlayer extends Player {

    public ManualPlayer(String name, String opponentName, IAlgorithm algorithm, IRemoteService playService, int initMove){
        super(name,opponentName,algorithm,playService);
        this.play(initMove);
    }

}
