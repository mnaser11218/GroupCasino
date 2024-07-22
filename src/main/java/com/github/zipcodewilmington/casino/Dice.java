package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.casino.games.beatTheDealer.BeatTheDealer;
import com.github.zipcodewilmington.casino.games.beatTheDealer.BeatTheDealerPlayer;

import java.util.Random;

public class Dice {

    public int rollDice(){
    Random random = new Random();
    return random.nextInt(7)+1;
    }
}
