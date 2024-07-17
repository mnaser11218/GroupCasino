package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.GamblingGameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class BlackJackGame implements GamblingGameInterface {
    @Override
    public int askForWager(int playerBet) {
        return 0;
    }

    @Override
    public int adjustBalances(int playerBalance) {
        return 0;
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {

    }

    @Override
    public void newPlayerTurn() {

    }

    @Override
    public void endGame() {

    }


    //welcome to blackjack
    //collect bet
    //pot equals bet * 2 (because dealer is matching)
    //deal hand DEALER (2 cards)
    //deal hand PLAYER (2 cards)
    //ask to hit or stand
    //if bust = subtract wager from playerbalance
    //if 21 = player wins the whole pot
    //if < 21, ask to hit or stand again. from line 11
    //pLAY ANOTHER HAND(PLAY AGAIN?) y/n or quit








}
