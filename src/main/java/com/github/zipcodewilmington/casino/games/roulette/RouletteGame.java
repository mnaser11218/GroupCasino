package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GamblingGameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Random;
import java.util.Scanner;

public class RouletteGame implements GamblingGameInterface {


    private CasinoAccount myPlayerAccount;
    public String userName;
    public String password;
    public CasinoAccountManager casinoAccountManager;
    public RoulettePlayer player;
    public int storedSpinResult;


    public static void main(String[] args) {
        RouletteGame roulette = new RouletteGame();
        roulette.runRoulette();
    }

    public void runRoulette(){
        //   red   [31m
        //   auto   [0m
        int keepGoing = 0;
        while (keepGoing == 0) {
            System.out.println(
                    "\u001B[0m     _____________________________________________________________________\t\n" +
                            "    /|    |    |    |    |    |    |    |    |    |    |    |     |      |  \n" +
                            "   / | \u001B[31m3\u001B[0m  |  6 |  \u001B[31m9\u001B[0m | \u001B[31m12\u001B[0m | 15 | \u001B[31m18\u001B[0m | \u001B[31m21\u001B[0m | 24 | \u001B[31m27\u001B[0m | \u001B[31m30\u001B[0m | 33 |  \u001B[31m36\u001B[0m | 2to1 |\n" +
                            "  /  |____|____|____|____|____|____|____|____|____|____|____|____ |______|\n" +
                            " /   |    |    |    |    |    |    |    |    |    |    |    |     |      |\n" +
                            "| 0  |  2 |  \u001B[31m5\u001B[0m |  8 | 11 | \u001B[31m14\u001B[0m | 17 | 20 | \u001B[31m23\u001B[0m | 26 | 29 | \u001B[31m32\u001B[0m | 35  | 2to1 |\n" +
                            " \\   |____|____|____|____|____|____|____|____|____|____|____|_____|______|\n" +
                            "  \\  |    |    |    |    |    |    |    |    |    |    |    |     |      |\n" +
                            "   \\ |  \u001B[31m1\u001B[0m |  4 |  \u001B[31m7\u001B[0m | 10 | 13 | \u001B[31m16\u001B[0m | \u001B[31m19\u001B[0m | 22 | \u001B[31m25\u001B[0m | 28 | 31 |  \u001B[31m34\u001B[0m | 2to1 |\n" +
                            "    \\|____|____|____|____|____|____|____|____|____|____|____|_____|______|\n" +
                            "     |                   |                   |                    |\n" +
                            "     |      1st 12       |       2nd 12      |      3rd  12       |\n" +
                            "     |___________________|___________________|____________________|\n" +
                            "     |              |              |              |               |\n" +
                            "     |    EVEN      |     \u001B[31mRED\u001B[0m      |     WHITE    |       ODD     |\n" +
                            "     |______________|______________|______________|_______________|\n" +
                            "        ---------Welcome to Roulette! Place your wager---------");
            Random rouletteSpin = new Random();
            int playerBet = this.askForWager(0);
            if (playerBet == 0){
                break;
            }
            System.out.println("" + "Which bet type do you feel is luckiest? \n" +
                    "ANY NUMBER || 1ST12 || 2ND12 || 3RD12 || WHITE || RED || ODD || EVEN");
            String betType = this.askForBetType().toUpperCase();
            this.storedSpinResult = rouletteSpin.nextInt(36)+1;
            int payout =+ this.determinePayOutAmount(playerBet,betType);
            if (payout == 0){
                System.out.println("the winning number was " + this.storedSpinResult + ", \u001B[31mlol you lost\u001B[0m");
                myPlayerAccount.setAccountBalance(myPlayerAccount.accountBalance - playerBet);
                System.out.println("your current balance is " + myPlayerAccount.getAccountBalance());
            } else if (payout > 0){
                System.out.println("\u001B[32mwow you actually got it\u001B[0m, the winning number was " + this.storedSpinResult + "\n" +
                        "your payout is $" + payout);
                myPlayerAccount.setAccountBalance(myPlayerAccount.accountBalance + payout);
                System.out.println("your current balance is $" + myPlayerAccount.getAccountBalance());
                if (myPlayerAccount.accountBalance < 1){
                    System.out.println("you ran out of money, security is coming to kick you out");
                    keepGoing = -1;
                }
            }
            if (this.playAgain() == false) {
                keepGoing = -1;
            }
        }
    }

    public int determinePayOutAmount(int playerBet, String betType) {
        int multiplier = 0;
        int payout = playerBet;

        if (isNumber(betType)) {
            multiplier += determinePayOutForNumber(betType);
        } else{
            switch (betType) {
                case "ODD":
                case "EVEN":
                    multiplier += determinePayOutForOddsOrEvens(betType);
                    break;
                case "1ST12":
                case "2ND12":
                case "3RD12":
                    multiplier += determinePayOutFor12s(betType);
                    break;
                case "WHITE":
                case "RED":
                    multiplier += determinePayOutForColor(betType);
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
            if (element == storedSpinResult && betType.equals("1ST12")) {
                return 2;
            }
        }
        for (int element : second12) {
            if (element == storedSpinResult && betType.equals("2ND12")) {
                return 2;
            }
        }
        for (int element : third12) {
            if (element == storedSpinResult && betType.equals("3RD12")) {
                return 2;
            }
        }
        return 0;
    }

    public int determinePayOutForColor(String betType) {
        int[] red = new int[]{1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        int[] white = new int[]{15, 4, 2, 17, 6, 13, 11, 8, 10, 24, 33, 20, 31, 22, 29, 28, 35, 26};
        for (int element: red){
            if (element == storedSpinResult && betType.equals("RED")){
                return 1;
            }
        }
        for (int element : white){
            if (element == storedSpinResult && betType.equals("WHITE")){
                return 1;
            }
        }
        return 0;
    }

    public int determinePayOutForNumber(String betType) {
        if (isNumber(betType) && storedSpinResult == Integer.parseInt(betType) && Integer.parseInt(betType) > 0 && Integer.parseInt(betType) < 37){
            return 35;
        } else if (isNumber(betType) && storedSpinResult == Integer.parseInt(betType) && Integer.parseInt(betType) < 0 || Integer.parseInt(betType) > 37){
            System.out.println("please try again");
            return 0;
        } else{
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

    public String askForBetType() {
        Scanner scanner = new Scanner(System.in);

        String betType = scanner.nextLine();
        return betType;
    }

    public boolean playAgain(){
        System.out.println("\nwould you like to play again, Y/N?");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine().toUpperCase();
        if (userInput.equals("Y")){
            return true;
        } else if (userInput.equals("N")){
            return false;
        } else {
            return playAgain();
        }
    }

    @Override
    public void add(PlayerInterface player) {
        this.player=(RoulettePlayer)player;

    }

    @Override
    public void addCasinoAccountManager(CasinoAccountManager casinoAccountManager) {

        this.casinoAccountManager=casinoAccountManager;
         myPlayerAccount = this.casinoAccountManager.getAccount(this.userName,this.password);
    }

    @Override
    public void addUserNameAndPassword(String userName, String password) {

        this.userName=userName;
        this.password=password;
    }


    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        this.myPlayerAccount.getAccountBalance();
        System.out.println(this.userName);
        System.out.println("Hey there " + myPlayerAccount.getAccountName()+ ", your balance is $" +myPlayerAccount.accountBalance + "make it count!");
        runRoulette();
    }

    @Override
    public int askForWager(int playerBet) {
        Scanner scanner = new Scanner(System.in);
        try {
            playerBet = scanner.nextInt();
            if (playerBet > myPlayerAccount.getAccountBalance() || (myPlayerAccount.getAccountBalance() - playerBet) < 0 || playerBet < 0){
                System.out.println("You currently only have $" + myPlayerAccount.getAccountBalance() + " to bet with, try again!");
                return askForWager(playerBet);
            }
            return playerBet;
        }catch(Exception e){
            System.out.println("Your wager in numbers please");
            return askForWager(playerBet);
        }
    }

    @Override
    public int adjustBalances(int playerBalance) {
        return 0;
    }
}
