package me.dhk.game;

import me.dhk.game.model.AutomaticPlayer;
import me.dhk.game.model.algo.DivideByThreeAlgo;
import me.dhk.game.model.ManualPlayer;
import me.dhk.game.model.Player;
import me.dhk.game.service.RabbitRemoteService;

public class Main {
    public static void main(String[] argv) {
        String playerName = "player1";
        String opponentName = "player2";

        if (argv.length >= 3) {
            playerName = argv[0];
            opponentName = argv[1];
            int startingNumber = Integer.valueOf(argv[2]);
            Player manualPlayer= new ManualPlayer(playerName,opponentName, new DivideByThreeAlgo(),new RabbitRemoteService(),startingNumber);

        } else if (argv.length == 2 ) {
            playerName = argv[0];
            opponentName = argv[1];
            Player autoPlayer= new AutomaticPlayer(playerName,opponentName, new DivideByThreeAlgo(),new RabbitRemoteService());
        }


    }
}
