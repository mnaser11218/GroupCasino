package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.*;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackGame implements GamblingGameInterface {

     Scanner scanner = new Scanner(System.in);
     CardDeck deck = new CardDeck();
    private  ArrayList<Card> playerHand = new ArrayList<>();
    private  ArrayList<Card> dealerHand = new ArrayList<>();
     boolean turnIsRunning = true;
     int totalOfPlayerHand = 0;
     int totalOfDealerHand = 0;
    private final IOConsole console = new IOConsole(AnsiColor.AUTO);
//    public static final String ANSI_RED = "\u001B[31m";
    public  String userName;
    public  String password;
    public  CasinoAccountManager casinoAccountManager;
    public  BlackJackPlayer player;
    public CasinoAccount myPlayerAccount;
    public int totalPot = 0;

    @Override
    public void addUserNameAndPassword(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    @Override
    public void addCasinoAccountManager(CasinoAccountManager casinoAccountManager){
        this.casinoAccountManager = casinoAccountManager;
        this.myPlayerAccount = this.casinoAccountManager.getAccount(this.userName, this.password);
    }



    public void initializeHands(){
        System.out.println("\nDealer Hand:");
        dealerHand.add(deck.dealACard());
        dealerHand.add(deck.dealACard());
        displayDealerHand();

        System.out.println("\nYour Hand:");
        playerHand.add(deck.dealACard());
        playerHand.add(deck.dealACard());
        displayPlayerHand();
    }

    public void displayPlayerHand(){
        totalOfPlayerHand = 0;
        for (Card x : playerHand){
            System.out.println(x.getCardValue() + " of " + x.getSuit());
            totalOfPlayerHand += x.getCardValue();
        }
        System.out.println("Your hand total: " + totalOfPlayerHand);
    }


    public void displayDealerHand(){
        totalOfDealerHand = 0;
        for (Card x : dealerHand){
            System.out.println(x.getCardValue() + " of " + x.getSuit());
            totalOfDealerHand += x.getCardValue();
        }
        System.out.println("Dealer hand total: " + totalOfDealerHand);
    }

    public void playAgain(){
        displayBeginning();
        resetGame();
        initializeHands();
        playerTurn();
    }

    public void resetGame(){
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
        totalOfPlayerHand = 0;
        totalOfDealerHand = 0;
        turnIsRunning = true;
        deck = new CardDeck();
    }

    public void findTheWinner(){
        int dealerResult = 21 - totalOfDealerHand;
        int playerResult = 21 - totalOfPlayerHand;

        if (playerResult == 0) {
            System.out.println("\u001B[32mYOU HAVE BLACKJACK!!!!!!!!!\u001B[36m");
            myPlayerAccount.setAccountBalance(myPlayerAccount.getAccountBalance() + totalPot);
            displayUpdatedBalance();
            return; // End the method if player has blackjack
        } else if (dealerResult == 0) {
            System.out.println("\u001B[31mDEALER HAS BLACKJACK! YOU LOST!!!\u001B[36m");
//            myPlayerAccount.setAccountBalance(myPlayerAccount.getAccountBalance() - (totalPot / 2));
            displayUpdatedBalance();
            return; // End the method if dealer has blackjack
        }

        if (totalOfPlayerHand > 21) {
            System.out.println("\u001B[31mThe dealer wins...YOU LOSE.\u001B[36m");
//            myPlayerAccount.setAccountBalance(myPlayerAccount.getAccountBalance() - (totalPot / 2));
            displayUpdatedBalance();
            return; // End the method if player busts
        } else if (totalOfDealerHand > 21) {
            System.out.println("\u001B[32mYou win the pot!!! Money, baby!\u001B[36m");
            myPlayerAccount.setAccountBalance(myPlayerAccount.getAccountBalance() + totalPot);
            displayUpdatedBalance();
            return; // End the method if dealer busts
        }

        if (playerResult == dealerResult) {
            System.out.println("\u001B[33mIt's a push.\u001B[36m");
            myPlayerAccount.setAccountBalance(myPlayerAccount.getAccountBalance() + (totalPot / 2));
            displayUpdatedBalance();
            return; // End the method if it's a tie
        }

        if (dealerResult < playerResult) {
            System.out.println("\u001B[31mThe dealer wins... YOU LOSE.\u001B[36m");
//            myPlayerAccount.setAccountBalance(myPlayerAccount.getAccountBalance() - (totalPot / 2));
            displayUpdatedBalance();
        } else if (playerResult < dealerResult) {
            System.out.println("\u001B[32mYou win the pot!!! Money, baby!\u001B[36m");
            myPlayerAccount.setAccountBalance(myPlayerAccount.getAccountBalance() + totalPot);
            displayUpdatedBalance();
        }
    }

    public void displayUpdatedBalance(){
        System.out.println("---------------------------------");
        System.out.println("Your Current Balance is now " + myPlayerAccount.getAccountBalance() + ".");
        System.out.println("---------------------------------");
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
        this.player = (BlackJackPlayer)player;
    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        playAgain();

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

    public void dealersTurn(){
        System.out.println("\u001B[31m*************************");
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
        System.out.println("\u001B[36m************************************");
//        System.out.println("Dealer Hand's FINAL total: " + totalOfDealerHand);

        //if dealerTotal is <= 16, dealer must hit.
        //if the dealerTotal is greater than 21, stop hitting.
        //if it equals 21, stop hitting.
        //if its less than 21, keep hitting.
        //if 17 or more, you must stand.
    }


    public void displayBeginning(){
        boolean initial = true;
        int userInput = 0;
        while (initial) {
            System.out.println("\u001B[36m▀█████████▄   ▄█          ▄████████  ▄████████    ▄█   ▄█▄\n" +
                    "  ███    ███ ███         ███    ███ ███    ███   ███ ▄███▀\n" +
                    "  ███    ███ ███         ███    ███ ███    █▀    ███▐██▀  \n" +
                    " ▄███▄▄▄██▀  ███         ███    ███ ███         ▄█████▀   \n" +
                    "▀▀███▀▀▀██▄  ███       ▀███████████ ███        ▀▀█████▄   \n" +
                    "  ███    ██▄ ███         ███    ███ ███    █▄    ███▐██▄  \n" +
                    "  ███    ███ ███▌    ▄   ███    ███ ███    ███   ███ ▀███▄\n" +
                    "▄█████████▀  █████▄▄██   ███    █▀  ████████▀    ███   ▀█▀\n" +
                    "             ▀                                   ▀        \n" +
                    "     ▄█    ▄████████  ▄████████    ▄█   ▄█▄               \n" +
                    "    ███   ███    ███ ███    ███   ███ ▄███▀               \n" +
                    "    ███   ███    ███ ███    █▀    ███▐██▀                 \n" +
                    "    ███   ███    ███ ███         ▄█████▀                  \n" +
                    "    ███ ▀███████████ ███        ▀▀█████▄                  \n" +
                    "    ███   ███    ███ ███    █▄    ███▐██▄                 \n" +
                    "    ███   ███    ███ ███    ███   ███ ▀███▄               \n" +
                    "█▄ ▄███   ███    █▀  ████████▀    ███   ▀█▀               \n" +
                    "▀▀▀▀▀▀                            ▀                       ");
            System.out.println("************************************");
            System.out.println("Hello, " + myPlayerAccount.getAccountName() + "!");
            System.out.println("\u001B[32mPlease place your bet: (Min: $5 / Max $50)");
            System.out.println("Your Current Balance: " + myPlayerAccount.getAccountBalance());
            System.out.println("\u001B[36m************************************");
            userInput = scanner.nextInt();
            if (userInput < 5) {
                System.out.println("\u001B[31mSorry buddy, you need at least $5.\u001B[36m");
            } else if (userInput > 50) {
                System.out.println("\u001B[31mThe maximum bet is $50, can't you read?\u001B[36m");
            } else if ((myPlayerAccount.getAccountBalance() == 0) || myPlayerAccount.getAccountBalance() < userInput) {
                System.out.println("\u001B[31mYou do NOT have enough funds for this.\u001B[36m");
            } else {
                initial = false;
            }}
        System.out.println("Dealer matches your bet.");
        myPlayerAccount.setAccountBalance(myPlayerAccount.getAccountBalance() - userInput);
        totalPot = userInput * 2;
        System.out.println("Total Pot: " + totalPot);
    }

    public void playerTurn(){
//        turnIsRunning = true;
        while (turnIsRunning) {
            if (totalOfPlayerHand > 21){
                System.out.println("!!! BUST !!!");
                turnIsRunning = false;
                break;
            }
            System.out.println("\nWould you like to hit or stand?\nPress 1): [ Hit ]\nPress 2): [ Stand ]");
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

        System.out.println("\nPlay another hand?\nPress 1): [ Yes ]\nPress 2): [ No ]");
        int userInput2 = scanner.nextInt();
        if (userInput2 == 1){
            playAgain();
        } else if (userInput2 == 2) {
            System.out.println("Goodbye, " + myPlayerAccount.getAccountName() + ". Come back anytime.");
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


//    public static void main(String[] args) {
//        playAgain();
//    }





}

//    @Override
//    public void addCasinoAccountManager(CasinoAccountManager casinoAccountManager) {
//
//    }
//
//    @Override
//    public void addUserNameAndPassword(String userName, String password) {
//
//    }

//
//    @Override
//    public void remove(PlayerInterface player) {
//
//    }
//
//    @Override
//    public void run() {
//        //print blackjack console
//        //set bet
//        //initialize new game/round
//        //while isRunning...
//        //deal hands
//        //check if dealer wins default
//        //player turn
//        //check dealer
//        //confirm next new round or quit
//        //end loop
//    }
//
//    public static void dealersTurn(){
//        System.out.println("*************************");
//        System.out.println("NOW IT'S THE DEALERS TURN...");
//        System.out.println("*************************");
//        if (totalOfDealerHand <= 16){
//            dealerHand.add(deck.dealACard());
//            System.out.println("Dealer hit...");
//        } else if (totalOfDealerHand > 21){
//            System.out.println("Dealer busted...");
//            //do nothing > findWinner will display that dealer busted
//        } else if (totalOfDealerHand == 21){
//            System.out.println("Dealer has blackjack...");
//            //do nothing > findWinner will display blackjack
//        } else if (totalOfDealerHand > 16 && totalOfDealerHand < 21){
//            System.out.println("Dealer stands...");
//            //do nothing > this will indicate dealer just stands
//        }
//        totalOfDealerHand = 0;
//        displayDealerHand();
//        System.out.println("************************************");
////        System.out.println("Dealer Hand's FINAL total: " + totalOfDealerHand);
//
//        //if dealerTotal is <= 16, dealer must hit.
//        //if the dealerTotal is greater than 21, stop hitting.
//        //if it equals 21, stop hitting.
//        //if its less than 21, keep hitting.
//        //if 17 or more, you must stand.
//    }
//
//
//    public static void displayBeginning(){
//        boolean initial = true;
//        int userInput = 0;
//        while (initial){
//        System.out.println("\n****** WELCOME TO BLACK JACK! ******");
//        System.out.println("Please place your bet: (Min: $5 / Max $50)");
//        System.out.println("************************************");
//        userInput = scanner.nextInt();
//
//        if (userInput < 5){
//            System.out.println("Sorry buddy, you need at least $5.");
//        } else if (userInput > 50){
//            System.out.println("The maximum bet is $50, can't you read?");
//        } else {
//            initial = false;
//        }}
//        System.out.println("Dealer matches your bet.");
//        System.out.println("Total Pot: " + (userInput * 2));
//    }
//
//    public static void playerTurn(){
////        turnIsRunning = true;
//        while (turnIsRunning) {
//            if (totalOfPlayerHand > 21){
//                System.out.println("!!! BUST !!!");
//                turnIsRunning = false;
//                break;
//            }
//            System.out.println("\nWould you like to hit or stand?\nPress 1): to Hit\nPress 2): to Stand");
//            int userInput = scanner.nextInt();
//            if (userInput == 1) {
//                playerHand.add(deck.dealACard());
//                displayPlayerHand();
//            } else if (userInput == 2) {
//                System.out.println("You chose to stand!");
//                turnIsRunning = false;
//            } else {
//                System.out.println("Not an option.");
//            }
//        }
//        dealersTurn();
//        findTheWinner();
//
//        System.out.println("\nPlay another hand?\nPress 1): Yes\nPress 2): No");
//        int userInput2 = scanner.nextInt();
//        if (userInput2 == 1){
//            playAgain();
//        } else if (userInput2 == 2) {
//            System.out.println("Goodbye.");
//        } else {
//            System.out.println("Not an option.");
//        }
//
//    }
//
//
//    //welcome to blackjack
//    //collect bet
//    //pot equals bet * 2 (because dealer is matching)
//    //deal hand DEALER (2 cards)
//    //deal hand PLAYER (2 cards)
//    //ask to hit or stand
//    //if bust = subtract wager from playerbalance
//    //if 21 = player wins the whole pot
//    //if < 21, ask to hit or stand again. from line 11
//    //pLAY ANOTHER HAND(PLAY AGAIN?) y/n or quit
//
//
//    public static void main(String[] args) {
//        playAgain();
//    }






