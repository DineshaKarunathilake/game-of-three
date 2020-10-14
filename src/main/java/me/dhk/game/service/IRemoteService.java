package me.dhk.game.service;

import me.dhk.game.model.Acceptable;

public interface  IRemoteService {

    void sendMove(String opponent, int move);

    void registerAcceptor(Acceptable acceptable, String player);
}
