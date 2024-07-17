package com.github.zipcodewilmington.casino.games.roulette;

import java.util.Scanner;

public class RouletteGame{

    public int storedSpinResult;

    public String askForBetType(){
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String userInputUpper = userInput.toUpperCase();
        return userInputUpper;
    }

//
//    public int determinePayOutForOddsOrEvens(int playerBet, String betType) {
//
//    }
//
//    public int determinePayOutFor12s(int playerBet, String betType) {
//    }
//
//    public int determinePayOutForColor(int playerBet, String betType) {
//    }
//
//    public int determinePayOutForNumber(int playerBet, String betType) {
//    }
}
