package me.dhk.game.model.algo;

import org.junit.Test;

import static org.junit.Assert.*;

public class DivideByThreeAlgoTest {

    IAlgorithm algo = new DivideByThreeAlgo();

    @Test
    public void getNextMoveTest() {
        int currentMove = 56;
        assertEquals(19, algo.getNextMove(currentMove));
    }

    @Test
    public void isWonTest() {
        assertTrue(algo.isWon(1));
        assertFalse(algo.isWon(2));


    }
}