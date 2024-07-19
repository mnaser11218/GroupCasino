package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer extends CasinoAccountManager implements PlayerInterface {

    @Override
    public CasinoAccount getArcadeAccount(String userName, String password) {
        return getAccount(userName, password);
    }

}