package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class RoulettePlayer extends CasinoAccountManager implements PlayerInterface {
    @Override
    public CasinoAccount getArcadeAccount(String userName, String password) {
        return getAccount(userName, password);
    }
}
