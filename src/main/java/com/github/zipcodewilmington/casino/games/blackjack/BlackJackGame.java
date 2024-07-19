package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.*;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackGame implements  GameInterface {

    static Scanner scanner = new Scanner(System.in);
    static CardDeck deck = new CardDeck();
    private static ArrayList<Card> playerHand = new ArrayList<>();
    private static ArrayList<Card> dealerHand = new ArrayList<>();
    static boolean turnIsRunning = true;
    static int totalOfPlayerHand = 0;
    static int totalOfDealerHand = 0;



    public static void initializeHands(){
        System.out.println("\nDealer Hand:");
        dealerHand.add(deck.dealACard());
        dealerHand.add(deck.dealACard());
        displayDealerHand();

        System.out.println("\nYour Hand:");
        playerHand.add(deck.dealACard());
        playerHand.add(deck.dealACard());
        displayPlayerHand();
    }

    public static void displayPlayerHand(){
        totalOfPlayerHand = 0;
        for (Card x : playerHand){
            System.out.println(x.getCardValue() + " of " + x.getSuit());
            totalOfPlayerHand += x.getCardValue();
        }
        System.out.println("Your hand total: " + totalOfPlayerHand);
    }


    public static void displayDealerHand(){
        totalOfDealerHand = 0;
        for (Card x : dealerHand){
            System.out.println(x.getCardValue() + " of " + x.getSuit());
            totalOfDealerHand += x.getCardValue();
        }
        System.out.println("Dealer hand total: " + totalOfDealerHand);

    }

    public static void playAgain(){
        displayBeginning();
        resetGame();
        initializeHands();
        playerTurn();
    }

    public static void resetGame(){
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
        totalOfPlayerHand = 0;
        totalOfDealerHand = 0;
        turnIsRunning = true;
        deck = new CardDeck();
    }

    public static void findTheWinner(){
        int dealerResult = 21 - totalOfDealerHand;
        int playerResult = 21 - totalOfPlayerHand;

        if (playerResult == 0) {
            System.out.println("YOU HAVE BLACKJACK!!!!!!!!!");
            return; // End the method if player has blackjack
        } else if (dealerResult == 0) {
            System.out.println("DEALER HAS BLACKJACK! YOU LOST!!!");
            return; // End the method if dealer has blackjack
        }

        if (totalOfPlayerHand > 21) {
            System.out.println("The dealer wins... YOU LOSE.");
            return; // End the method if player busts
        } else if (totalOfDealerHand > 21) {
            System.out.println("You win the pot!!! Money, baby!");
            return; // End the method if dealer busts
        }

        if (playerResult == dealerResult) {
            System.out.println("It's a push.");
            return; // End the method if it's a tie
        }

        if (dealerResult < playerResult) {
            System.out.println("The dealer wins... YOU LOSE.");
        } else if (playerResult < dealerResult) {
            System.out.println("You win the pot!!! Money, baby!");
        }
    }

//    @Override
//    public int askForWager(int playerBet) {
//        return 0;
//    }
//
//    @Override
//    public int adjustBalances(int playerBalance) {
//        return 0;
//    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void addCasinoAccountManager(CasinoAccountManager casinoAccountManager) {

    }

    @Override
    public void addUserNameAndPassword(String userName, String password) {

    }


    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        //print blackjack console
        //set bet
        //initialize new game/round
        //while isRunning...
        //deal hands
        //check if dealer wins default
        //player turn
        //check dealer
        //confirm next new round or quit
        //end loop
    }

    public static void dealersTurn(){
        System.out.println("*************************");
        System.out.println("NOW IT'S THE DEALERS TURN...");
        System.out.println("*************************");
        if (totalOfDealerHand <= 16){
            dealerHand.add(deck.dealACard());
            System.out.println("Dealer hit...");
        } else if (totalOfDealerHand > 21){
            System.out.println("Dealer busted...");
            //do nothing > findWinner will display that dealer busted
        } else if (totalOfDealerHand == 21){
            System.out.println("Dealer has blackjack...");
            //do nothing > findWinner will display blackjack
        } else if (totalOfDealerHand > 16 && totalOfDealerHand < 21){
            System.out.println("Dealer stands...");
            //do nothing > this will indicate dealer just stands
        }
        totalOfDealerHand = 0;
        displayDealerHand();
        System.out.println("************************************");
//        System.out.println("Dealer Hand's FINAL total: " + totalOfDealerHand);

        //if dealerTotal is <= 16, dealer must hit.
        //if the dealerTotal is greater than 21, stop hitting.
        //if it equals 21, stop hitting.
        //if its less than 21, keep hitting.
        //if 17 or more, you must stand.
    }


    public static void displayBeginning(){
        boolean initial = true;
        int userInput = 0;
        while (initial){
        System.out.println("\n****** WELCOME TO BLACK JACK! ******");
        System.out.println("Please place your bet: (Min: $5 / Max $50)");
        System.out.println("************************************");
        userInput = scanner.nextInt();

        if (userInput < 5){
            System.out.println("Sorry buddy, you need at least $5.");
        } else if (userInput > 50){
            System.out.println("The maximum bet is $50, can't you read?");
        } else {
            initial = false;
        }}
        System.out.println("Dealer matches your bet.");
        System.out.println("Total Pot: " + (userInput * 2));
    }

    public static void playerTurn(){
//        turnIsRunning = true;
        while (turnIsRunning) {
            if (totalOfPlayerHand > 21){
                System.out.println("!!! BUST !!!");
                turnIsRunning = false;
                break;
            }
            System.out.println("\nWould you like to hit or stand?\nPress 1): to Hit\nPress 2): to Stand");
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                playerHand.add(deck.dealACard());
                displayPlayerHand();
            } else if (userInput == 2) {
                System.out.println("You chose to stand!");
                turnIsRunning = false;
            } else {
                System.out.println("Not an option.");
            }
        }
        dealersTurn();
        findTheWinner();

        System.out.println("\nPlay another hand?\nPress 1): Yes\nPress 2): No");
        int userInput2 = scanner.nextInt();
        if (userInput2 == 1){
            playAgain();
        } else if (userInput2 == 2) {
            System.out.println("Goodbye.");
        } else {
            System.out.println("Not an option.");
        }

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


    public static void main(String[] args) {
        playAgain();
    }





}
