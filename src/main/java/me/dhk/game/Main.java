package me.dhk.game;

import me.dhk.game.model.player.AutomaticPlayer;
import me.dhk.game.model.algo.DivideByThreeAlgo;
import me.dhk.game.model.player.ManualPlayer;
import me.dhk.game.model.player.Player;
import me.dhk.game.service.RabbitRemoteService;

public class Main {
    public static void main(String[] argv) {

        if (argv.length >= 3) {
            startManualPlayer(argv);

        } else if (argv.length == 2 ) {
            startAutoPlayer(argv);

        } else {
            System.out.println("Please enter player name, opponent name, optional initial move in arguments");
        }


    }

    private static void startAutoPlayer(String[] argv) {
        String playerName;
        String opponentName;
        playerName = argv[0];
        opponentName = argv[1];
        Player autoPlayer= new AutomaticPlayer(playerName,opponentName, new DivideByThreeAlgo(),new RabbitRemoteService());
        System.out.println(playerName + " Playing...");
        autoPlayer.startPlay();
    }

    private static void startManualPlayer(String[] argv) {
        String playerName;
        String opponentName;
        playerName = argv[0];
        opponentName = argv[1];
        int startingNumber = Integer.parseInt(argv[2]);
        Player manualPlayer= new ManualPlayer(playerName,opponentName, new DivideByThreeAlgo(),new RabbitRemoteService(),startingNumber);
        System.out.println(playerName + " Playing...");
        manualPlayer.startPlay();
    }
}
