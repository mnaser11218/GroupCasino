package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.GamblingGameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Random;
import java.util.Scanner;

public class RouletteGame implements GamblingGameInterface {

    public int storedSpinResult;

//    public String askForBetType() {
//        //this will take in what RoulettePlayer will input
//        // for example "1" or "RED" or "1st12"
//        //is done via overriden methods
////        String userInputUpper = userInput.toUpperCase();
//    }

    public int determinePayOutAmount(int playerBet, String betType) {
        int multiplier = 0;
        int payout = playerBet;

        if (isNumber(betType)) {
            multiplier = determinePayOutForNumber(betType);
        } else{
        switch (betType) {
            case "ODD":
            case "EVEN":
                multiplier = determinePayOutForOddsOrEvens(betType);
                break;
            case "1ST12":
            case "2ND12":
            case "3RD12":
                multiplier = determinePayOutFor12s(betType);
                break;
            case "BLACK":
            case "RED":
                multiplier = determinePayOutForColor(betType);
                break;
            default:
                break;
        }
        }
        return payout*multiplier;
    }

    public int determinePayOutForOddsOrEvens(String betType) {
        if (storedSpinResult%2==0 && betType.equals("EVEN")){
            return 1;
        } else if (storedSpinResult%2!=0 && betType.equals("ODD")){
            return 1;
        } else {
            return 0;
        }
    }

    public int determinePayOutFor12s(String betType) {
        int[] first12 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        int[] second12 = new int[]{13,14,15,16,17,18,19,20,21,22,23,24};
        int[] third12 = new int[]{25,26,27,28,29,30,31,32,33,34,35,36};

        for (int element : first12) {
            if (element == storedSpinResult && betType.equals("1st12")) {
                return 2;
            }
        }
        for (int element : second12) {
            if (element == storedSpinResult && betType.equals("2nd12")) {
                return 2;
            }
        }
        for (int element : third12) {
            if (element == storedSpinResult && betType.equals("3rd12")) {
                return 2;
            }
        }
        return 0;
    }

    public int determinePayOutForColor(String betType) {
        int[] red = new int[]{1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        int[] black = new int[]{15, 4, 2, 17, 6, 13, 11, 8, 10, 24, 33, 20, 31, 22, 29, 28, 35, 26};
        for (int element: red){
            if (element == storedSpinResult && betType.equals("RED")){
                return 1;
            }
        }
        for (int element : black){
            if (element == storedSpinResult && betType.equals("BLACK")){
                return 1;
            }
        }
        return 0;
    }

    public int determinePayOutForNumber(String betType) {
        if (isNumber(betType) && storedSpinResult == Integer.parseInt(betType)){
            return 35;
        } else {
            return 0;
        }
    }

    public boolean isNumber(String betType){
        if (betType != null && !betType.isEmpty()) {
            for (int i = 0; i < betType.length(); i++) {
                if (!Character.isDigit(betType.charAt(i)))
                    return false;
            }
        }
        return true;
    }

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
    Random rouletteSpin = new Random();
    storedSpinResult = rouletteSpin.nextInt(37)+1;
    }
}
