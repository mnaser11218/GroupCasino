package com.github.zipcodewilmington.casino.games.beatTheDealer;

import com.github.zipcodewilmington.casino.*;
import com.github.zipcodewilmington.casino.games.roulette.RoulettePlayer;

import java.util.Scanner;

public class BeatTheDealer extends Dice implements GamblingGameInterface {

    private CasinoAccount myPlayerAccount;
    public String userName;
    public String password;
    public CasinoAccountManager casinoAccountManager;
    public BeatTheDealerPlayer player;
    public int playerBet;

    public int dealerDiceValue;
    public int playerDiceValue;

    public static void main(String[] args) {
//
    }

    public int playerDiceRoll() {
        Dice dice = new Dice();
        int playerRoll = dice.rollDice() + dice.rollDice();
        System.out.println("Player rolled " + playerRoll);
        playerDiceValue = playerRoll;
        return playerRoll;
    }

    public boolean playerWon(int playerDiceValue, int dealerDiceValue) {
        if (playerDiceValue > dealerDiceValue) {
            System.out.println("\u001B[32mYou won!\u001B[0m Dealer only had " + dealerDiceValue);
            return true;
        } else if (dealerDiceValue > playerDiceValue) {

            return false;
        } else if (dealerDiceValue == playerDiceValue) {
            return false;
        } else {
            return false;
        }
    }

    public boolean tryAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to play again, Y/N?");
        String userInput = scanner.nextLine().toUpperCase();
        if (userInput.equals("Y")) {
            return true;
        } else if (userInput.equals("N")) {
            return false;
        } else {
            System.out.println("Try typing your option again");
            return tryAgain();
        }
    }

    public void sumOfDealer() {
        Dice dice = new Dice();
        dealerDiceValue = dice.rollDice() + dice.rollDice();
    }

    public boolean checkIf12Hits(int dealerDiceValue) {
        if (dealerDiceValue == 12) {
            System.out.println("wow dealer rolled two 6's, \u001B[31mbad luck!\u001B[0m");
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIfTied() {
        if (dealerDiceValue == playerDiceValue) {
            return true;
        }
        return false;
    }

    @Override
    public int askForWager(int playerBet) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("How much $ would you like to bet?");
            playerBet = scanner.nextInt();
            this.playerBet = playerBet;
            return playerBet;
        } catch (Exception e) {
            System.out.println("Your wager in numbers please");
            return askForWager(playerBet);
        }
    }

    @Override
    public int adjustBalances(int playerBalance) {
        return 0;
    }

    @Override
    public void add(PlayerInterface player) {
        this.player = (BeatTheDealerPlayer) player;
    }

    @Override
    public void addCasinoAccountManager(CasinoAccountManager casinoAccountManager) {
        this.casinoAccountManager = casinoAccountManager;
        myPlayerAccount = this.casinoAccountManager.getAccount(this.userName, this.password);
    }

    @Override
    public void addUserNameAndPassword(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        this.myPlayerAccount.getAccountBalance();
        System.out.println(this.userName);
        System.out.println("Hey there, " + myPlayerAccount.getAccountName() + " your balance is $" + myPlayerAccount.accountBalance + "make it count!");

        int keepGoing = 0;
        while (keepGoing == 0) {
            System.out.println("Welcome to Beat the Dealer, place your luck upon these two dice \n" +
                    "\u001B[33m  ____\n" +
                    " /\\' .\\    _____\n" +
                    "/: \\___\\  / .  /\\\n" +
                    "\\' / . / /____/..\\\n" +
                    " \\/___/  \\'  '\\  /\n" +
                    "          \\'__'\\/\u001B[0m");
            askForWager(this.playerBet);
            playerDiceRoll();
            sumOfDealer();

            if (checkIf12Hits(dealerDiceValue) == true) {
                myPlayerAccount.setAccountBalance(myPlayerAccount.getAccountBalance() - playerBet);
                System.out.println("Your new balance is $" + myPlayerAccount.getAccountBalance());
                if (tryAgain() == false) {
                    keepGoing = -1;
                } else {
                    keepGoing = 0;
                }
            } else {
                if (playerWon(playerDiceValue, dealerDiceValue) == true) {
                    myPlayerAccount.setAccountBalance(myPlayerAccount.getAccountBalance() + playerBet);
                    System.out.println("Your new balance is $" + myPlayerAccount.getAccountBalance());
                    if (tryAgain() == false) {
                        keepGoing = -1;
                    } else {
                        keepGoing = 0;
                    }
                } else if (playerWon(playerDiceValue, dealerDiceValue) == false && checkIfTied() == true) {
                    System.out.println("\u001B[35mYou both tied!!\u001B[0m");
                    System.out.println("Your balance stays at $" + myPlayerAccount.getAccountBalance());
                    if (tryAgain() == false) {
                        keepGoing = -1;
                    } else {
                        keepGoing = 0;
                    }
                } else if (playerWon(playerDiceValue, dealerDiceValue) == false) {
                    myPlayerAccount.setAccountBalance(myPlayerAccount.getAccountBalance() - playerBet);
                    System.out.println("\u001B[31mYou lost!!!\u001B[0m Dealer rolled " + dealerDiceValue);
                    System.out.println("Your new balance is $" + myPlayerAccount.getAccountBalance());
                    if (tryAgain() == false) {
                        keepGoing = -1;
                    } else {
                        keepGoing = 0;
                    }
                }
            }

        }
    }
}
