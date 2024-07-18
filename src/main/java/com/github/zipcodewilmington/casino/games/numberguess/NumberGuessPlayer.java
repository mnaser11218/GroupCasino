package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessPlayer extends CasinoAccountManager implements PlayerInterface  {

    public void helloWorld(){
        System.out.println("hello world from number guess player");
    }

    @Override
    public CasinoAccount getArcadeAccount() {

        return null;
    }
}