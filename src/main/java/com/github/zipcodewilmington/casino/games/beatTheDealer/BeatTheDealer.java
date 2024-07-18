package com.github.zipcodewilmington.casino.games.beatTheDealer;

import com.github.zipcodewilmington.casino.Dice;

public class BeatTheDealer extends Dice {

    public int dealerDiceValue;

//    public Player calculateWinner(int playerDiceValue, int dealerDiceValue) {
//    return Player;}

    public boolean checkIf12Hits(int dealerDiceValue) {
        if (dealerDiceValue == 12) {
            return true;
        } else {
            return false;
        }
    }
}
