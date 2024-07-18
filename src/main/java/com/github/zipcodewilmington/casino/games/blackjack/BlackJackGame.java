package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.Card;
import com.github.zipcodewilmington.casino.CardDeck;
import com.github.zipcodewilmington.casino.GamblingGameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackGame implements GamblingGameInterface {

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
        System.out.println("Your hand total: " + totalOfDealerHand);

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


    public static void displayBeginning(){
        System.out.println("\n****** WELCOME TO BLACK JACK! ******");
        System.out.println("Please place your bet: (Min: $5 / Max $50)");
        System.out.println("************************************");
        int userInput = scanner.nextInt();
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
            System.out.println("\nWould you like to hit or stand?");
            System.out.println("Press 1): to Hit");
            System.out.println("Press 2): to Stand");
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
        displayBeginning();
        initializeHands();
        playerTurn();
    }





}
