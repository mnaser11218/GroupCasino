package com.github.zipcodewilmington.casino.games.slots;


import java.util.ArrayList;
import java.util.Random;


/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame {

    public static void main(String[] args) {


    }

    public ArrayList<Integer> spinWheel(boolean isLeverPulled, int size) {
        ArrayList<Integer> newArray = new ArrayList<>();
        Random random = new Random();

        if(isLeverPulled) {
            // creates an array random numbers from 0-9 with size 5
            for (int i = 0; i < size; i++){
                newArray.add(random.nextInt(10));
            }
        }
        return newArray;
    }

    public boolean checkForMatchThree(ArrayList<Integer> matchThree) {
        //creates an array 'duplicate' from 0-9
        int[] duplicate = new int[10];
        //counts occurences of each number in the array 'duplicate'
        for (int number : matchThree) {
            duplicate[number]++;
        }
        //iterates through the 'duplicate' array if any number has a value of 3 or 4 return true
        for (int i = 0; i < 10; i++) {
            if (duplicate[i] == 3 ) {
                return true;
            } else if (duplicate[i] == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean checkForMatchFive(ArrayList<Integer> matchFive) {
        //creates an array 'duplicate' from 0-9
        int[] duplicate = new int[10];
        //counts occurences of each number in the array 'duplicate'
        for (int number : matchFive) {
            duplicate[number]++;
        }
        //iterates through the 'duplicate' array if any number has a value of 5
        for (int i = 0; i < 10; i++) {
            if (duplicate[i] == 5) {
                return true;
            }
        }
        return false;
    }

    public boolean jackpot(ArrayList<Integer> allSevens) {
        for(int number : allSevens) {
            if (number != 7){
                return false;
            }
        }
        return true;
    }

    public int payOutForThree(boolean matchThreeTrue) {
        int payOutThree = matchThreeTrue ? 1 : 0;
        return payOutThree * 3;
    }

    public int payOutForFive(boolean matchFiveTrue) {
        int payOutThree = matchFiveTrue ? 1 : 0;
        return payOutThree * 7;
    }

    public int payOutForJackpot(boolean jackpotTrue) {
        int payOutThree = jackpotTrue ? 1 : 0;
        return payOutThree * 20;
    }
}
