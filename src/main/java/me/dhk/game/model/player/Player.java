package me.dhk.game.model.player;

import me.dhk.game.model.Acceptable;
import me.dhk.game.model.algo.IAlgorithm;
import me.dhk.game.service.IRemoteService;

public abstract class Player  implements Acceptable {

    String name;
    String opponentName;
    private IRemoteService playService;
    private IAlgorithm algorithm;

    Player(String name, String opponentName,IAlgorithm algorithm ,IRemoteService playService){
        this.name = name;
        this.opponentName = opponentName;
        this.playService = playService;
        this.algorithm =algorithm;
        playService.registerAcceptor(this,name);
    }

    void play(int move) {
        playService.sendMove(opponentName, move);
    }

    public void accept(int move) {
        int currentMove=algorithm.getNextMove(move);
        if(algorithm.isWon(currentMove)){
            System.out.println("I won");
            return;
        }
        play(currentMove);
    }

    boolean isStartingPlayer(){
        return this.name.compareTo(opponentName) < 0;
    }

    public abstract void startPlay();
}
