package me.dhk.game.model.player;

import me.dhk.game.model.algo.DivideByThreeAlgo;
import me.dhk.game.service.IRemoteService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class PlayerTest {

    @Test
    public void manualPlayerStartingPlayTest() {

        IRemoteService service=Mockito.mock(IRemoteService.class);
        DivideByThreeAlgo divideByThreeAlgo = new DivideByThreeAlgo();
        Player player = new ManualPlayer("player1", "player2", divideByThreeAlgo, service, 19) {
        };
        player.startPlay();

        Mockito.verify(service, Mockito.times(1)).sendMove("player2", 19);
    }

    @Test
    public void firstPlayerSelectionTest() {

        IRemoteService service=Mockito.mock(IRemoteService.class);
        DivideByThreeAlgo divideByThreeAlgo = new DivideByThreeAlgo();
        AutomaticPlayer player1 = new AutomaticPlayer("player1", "player2", divideByThreeAlgo, service) {
        };

        //'player1' is lexicographically first than 'player2'
        Assert.assertTrue(player1.isStartingPlayer());
    }


    @Test
    public void playCalledThenPlayServiceCalledWithCorrectValues() {

        IRemoteService service=Mockito.mock(IRemoteService.class);
        DivideByThreeAlgo divideByThreeAlgo = new DivideByThreeAlgo();
        Player player = new AutomaticPlayer("player1", "player2", divideByThreeAlgo, service);
        player.play(56);

        Mockito.verify(service, Mockito.times(1)).sendMove("player2", 56);

    }

    @Test
    public void acceptThenPlayServiceCalledWithNextMoveValue() {

        IRemoteService service=Mockito.mock(IRemoteService.class);
        DivideByThreeAlgo divideByThreeAlgo = new DivideByThreeAlgo();
        Player player = new AutomaticPlayer("player1", "player2", divideByThreeAlgo, service);
        player.accept(56);

        int nextMove = divideByThreeAlgo.getNextMove(56);
        Mockito.verify(service, Mockito.times(1)).sendMove("player2", nextMove);
    }

    @Test
    public void randomNumberShouldBeAlwaysPositive() {
        IRemoteService service=Mockito.mock(IRemoteService.class);
        DivideByThreeAlgo divideByThreeAlgo = new DivideByThreeAlgo();
        AutomaticPlayer player = new AutomaticPlayer("player1", "player2", divideByThreeAlgo, service);


        Assert.assertTrue(player.getRandomNumber()>0);

    }
}