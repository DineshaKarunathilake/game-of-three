package me.dhk.game.model.algo;

public interface IAlgorithm {
    int getNextMove(int move);
    boolean isWon(int move);
}
