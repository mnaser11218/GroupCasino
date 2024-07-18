package com.github.zipcodewilmington.casino.games.slots;


import java.util.ArrayList;
import java.util.Random;


/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame {

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
        int[] count = new int[10];

        for (int number : matchThree) {
            count[number]++;
        }

        for (int i = 0; i < 10; i++) {
            if (count[i] == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean checkForMatchFive(ArrayList<Integer> matchFive) {

        return false;
    }

    public boolean jackpot(ArrayList<Integer> allSevens) {

        return false;
    }

    public int payOutForThree(boolean matchThreeTrue) {

        return 0;
    }

    public int payOutForFive(boolean matchFiveTrue) {

        return 0;
    }


    public int payOutForJackpot(boolean JackpotTrue) {

        return 0;
    }
}
