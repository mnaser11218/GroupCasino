package com.github.zipcodewilmington.casino.games.beatTheDealer;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.Dice;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class BeatTheDealerPlayer extends CasinoAccountManager implements PlayerInterface {
    public int playerDiceValue;

    @Override
    public CasinoAccount getArcadeAccount(String userName, String password) {
        return getAccount(userName, password);
    }
}
