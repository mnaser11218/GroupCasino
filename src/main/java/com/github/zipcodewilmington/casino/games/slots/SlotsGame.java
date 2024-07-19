package com.github.zipcodewilmington.casino.games.slots;


import java.util.*;


/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame {
    Scanner scanner = new Scanner(System.in);
    int wagerAmount;
    ArrayList<Integer> randomList;

    public static void main(String[] args) {
        int startGambling = 0;

        while (startGambling == 0) {
            SlotsGame slots = new SlotsGame();
            slots.placeWager(slots.wagerAmount);

            if (slots.checkForjackpot(slots.randomList)){
                slots.payOutForJackpot(100, slots.wagerAmount);
                System.out.println("You got paid: " + slots.payOutForJackpot(0, slots.wagerAmount));
                if (slots.pullLever() == false) {
                    startGambling = 1;
                }
            } else if (slots.checkForMatchFive(slots.randomList)) {
                slots.payOutForFive(40, slots.wagerAmount);
                System.out.println("You got paid: " + slots.payOutForFive(0, slots.wagerAmount));
                if (slots.pullLever() == false) {
                    startGambling = 1;
                }

            } else if (slots.checkForMatchThree(slots.randomList)) {
                slots.payOutForThree(15, slots.wagerAmount);
                System.out.println("You got paid: " + slots.payOutForThree(0, slots.wagerAmount));
                if (slots.pullLever() == false) {
                    startGambling = 1;

                }
            }
        }
    }

    /*===================================
     UML
     ===================================*/

    public ArrayList<Integer> spinWheelYes(boolean isLeverPulled, int size) {
        ArrayList<Integer> newArray = new ArrayList<>();
        Random random = new Random();

        if(isLeverPulled) {
            // creates an array random numbers from 0-9 with size 5
            for (int i = 0; i < size; i++){
                newArray.add(random.nextInt(10));
            }
            System.out.println(newArray);
        }
        this.randomList = newArray;
        return newArray;
    }

    public boolean checkForMatchThree(ArrayList<Integer> matchThree) {
        int maxCount = 0;
//        int mostFrequent = 0;

        for (int i = 0; i < matchThree.size(); i++){
            int count = 0;
            //checks each element to see how often it appears
            //then adds it to the mostFrequent if it beats
            for (int j = 0; j < matchThree.size(); j++){
                if (matchThree.get(i) == matchThree.get(j)){
                    count++;
                }
            }
            if (count > maxCount){
                maxCount = count;
//                mostFrequent = matchThree.get(i);
            }
        }
        if (maxCount < 5 && maxCount >=3){
            System.out.println("You matched 3!");
            return true;
        } else {
            return false;
        }
    }

    public boolean checkForMatchFive(ArrayList<Integer> matchFive) {
        int maxCount = 0;

        for (int i = 0; i < matchFive.size(); i++){
            int count = 0;

            for (int j = 0; j < matchFive.size(); j++){
                if (matchFive.get(i) == matchFive.get(j)){
                    count++;
                }
            }
            if (count > maxCount){
                maxCount = count;
            }
        }

        if (maxCount == 5){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkForjackpot(ArrayList<Integer> allSevens) {
        for(int number : allSevens) {
            if (number != 7){
                return false;
            }
        }
        return true;
    }

    public int payOutForThree(int payOutThree, int wagerAmount) {
        payOutThree = 15;
        int payout = payOutThree * wagerAmount;
        return payout;
    }

    public int payOutForFive(int payOutFive, int wagerAmount) {
        payOutFive = 100;
        int payout = payOutFive * wagerAmount;
        return payout;
    }

    public int payOutForJackpot(int payOutJackpot, int wagerAmount) {
        payOutJackpot = 1000;
        int payout = payOutJackpot * wagerAmount;
        return payout;
    }

    /*===================================
    NEW METHODS
    ===================================*/

    public void placeWager(int bet) {
        System.out.print("How much would you like to bet? 5, 10, 20, 50, 100, 250: ");
        bet = 0;
        while (true) {
            bet = scanner.nextInt();
            switch (bet) {
                case 5:
                    this.wagerAmount = bet;
                    System.out.println("You've bet: 5");
                    this.spinWheelYes(true, 5);
                    return;
                case 10:
                    this.wagerAmount = bet;
                    System.out.println("You've bet: 10");
                    this.spinWheelYes(true, 5);
                    return;
                case 20:
                    this.wagerAmount = bet;
                    System.out.println("You've bet: 20");
                    this.spinWheelYes(true, 5);
                    return;
                case 50:
                    this.wagerAmount = bet;
                    System.out.println("You've bet: 50");
                    this.spinWheelYes(true, 5);
                    return;
                case 100:
                    this.wagerAmount = bet;
                    System.out.println("You've bet: 100");
                    this.spinWheelYes(true, 5);
                    return;
                case 250:
                    this.wagerAmount = bet;
                    System.out.println("You've bet: 250");
                    this.spinWheelYes(true, 5);
                    return;
                default:
                    System.out.println("That's not an option." +
                            "\nHow much would you like to bet? 5, 10, 20, 50, 100, 250");
                }
            }
        }


    public boolean pullLever() {
        System.out.println("Would you like to continue? [Yes] [No]");

        while (true) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "yes":
                    return true;
                case "no":
                    return false;
                default:
                    System.out.println("That's not an option. Would you like to continue? [Yes] [No]");
            }
        }
    }
}
