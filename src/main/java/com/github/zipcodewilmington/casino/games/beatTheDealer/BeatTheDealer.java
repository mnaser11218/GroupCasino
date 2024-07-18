package com.github.zipcodewilmington.casino.games.beatTheDealer;

import com.github.zipcodewilmington.casino.Dice;

public class BeatTheDealer extends Dice {

    public int dealerDiceValue;

//    public BeatTheDealerPlayer calculateWinner(int playerDiceValue, int dealerDiceValue) {
//        if (checkIf12Hits(dealerDiceValue) == true){
//            return Dealer;
//        } else if (playerDiceValue > dealerDiceValue){
//            return Player;
//        }else if (dealerDiceValue > playerDiceValue){
//            return Dealer;
//        }else{
//        return null;
//        }
//    }

    public boolean checkIf12Hits(int dealerDiceValue) {
        if (dealerDiceValue == 12) {
            return true;
        } else {
            return false;
        }
    }
}
