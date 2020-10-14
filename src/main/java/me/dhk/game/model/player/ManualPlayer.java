package me.dhk.game.model.player;

import me.dhk.game.model.algo.IAlgorithm;
import me.dhk.game.service.IRemoteService;


public class ManualPlayer extends Player {
    int initMove;

    public ManualPlayer(String name, String opponentName, IAlgorithm algorithm, IRemoteService playService, int initMove){
        super(name,opponentName,algorithm,playService);
        this.initMove=initMove;
    }

    @Override
    public void startPlay() {
        if (isStartingPlayer()){
            this.play(initMove);
        }
    }
}
