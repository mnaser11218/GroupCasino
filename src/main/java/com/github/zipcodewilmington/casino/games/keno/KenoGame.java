package com.github.zipcodewilmington.casino.games.keno;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GamblingGameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class KenoGame implements GamblingGameInterface {
    public String userName;
    public String password;
    public CasinoAccountManager casinoAccountManager;
    public KenoPlayer player;
    private CasinoAccount myPlayer;
    public int pay;

    // this is going to display a little welcome note in the beginning of the opening for the user
    public void displayWelcomeMessage() {
        System.out.println("Welcome to Keno Game!");
        // second phrase of welcome
        System.out.println("User please select your 10 numbers");
    }

    // this
    public List<Integer> generateWinningNumbers() {
        //total possible numbers that can be selected
        int numberOfNumbersToGenerate = 10;
        // I don't think we need a min and max number???
        //the minimum value is 1
        int minNumber = 1;
        //the max value is 80
        int maxNumber = 80;

        //The winningNumbers will create a list of 20 random numbers. This will be converted in an ArrayList
        List<Integer> winningNumbers = new ArrayList<>();
        Random random = new Random();


        // this loop continues to run as long as the size of the winningNumbers list is less than numberOfNumbersToGenerate(which is up tp twenty.
        while (winningNumbers.size() < numberOfNumbersToGenerate) {

            // because I have a min & max I can use this instead of writing (81)
            int randomNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            // to ensure that numbers that are being random, the random number being created will loop through
            // to make sure it's not adding a duplicate of a number
            if (!winningNumbers.contains(randomNumber)) {
                winningNumbers.add(randomNumber);
            }
        }
        // this will return a  new array list with all 20 of the winning numbers
        return winningNumbers;
    }



    // need to figure out how to get this method in the player interface
    public List<Integer> userSelectedNumbers() {
        int numberOfNumbersToSelect = 10;
        int minNumber = 1;
        int maxNumber = 80;

        List<Integer> selectedNumbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (selectedNumbers.size() < numberOfNumbersToSelect) {
            try {
                // reads the user input as a string and parses it into an integer (number).
                int number = Integer.parseInt(scanner.nextLine());
                //
                // if the number is less than  1 and higher than 80
                if (number < minNumber || number > maxNumber) {
                    System.out.println("Number out of range. Please enter a number between " + minNumber + " and " + maxNumber + ".");
                    // this is created to make sure that the user does not enter the same number twice
                } else if (selectedNumbers.contains(number)) {
                    System.out.println("You have already selected this number. Please enter a different number.");
                } else {
                    // if all these things are false then the game system will add the number to the list
                    selectedNumbers.add(number);
                }
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a number");
            }
        }
        // will return the selected numbers into an array list
        return selectedNumbers;
    }


    //method to compare selectedNumbers and winningNumbers
    public int compareSelectedAndWinningNumbers(List<Integer> selectedNumbers, List<Integer> winningNumbers) {
        //initializing it with 0 matches
        int matches = 0;

        // loop through selectedNumbers
        for (int number : selectedNumbers) {
            // need a way to identify if there are numbers that match with the winning numbers
            // the contains method allows me to see if the number that I have matches with any number in the winningNumber list
            if (winningNumbers.contains(number)) {
                // as matches are found the number of matches will go up by 1
                matches++;
            }
        }
        // this will return the amount of matches
        return matches;
    }

    public int getCalculatePayOut(int numbersMatched, int amount) {
        // this double array holds the payout rates based on the number of matches
        int[] payOuts = {
                0,      // 0 matches
                1,    // 1 match
                5,      // 2 matches
                10,     // 3 matches
                15,     // 4 matches
                50,    // 5 matches
                100,   // 6 matches
                250,   // 7 matches
                500,  // 8 matches
                1000,  // 9 matches
                5000,  // 10 matches
        };


        // calculate payout based on numbers matched and amount bet
        pay = payOuts [numbersMatched] * amount;
        System.out.println(pay);
        return payOuts [numbersMatched] * amount;
    }

    // method to display an ending message
    public int displayEnding(int userInput) {
        int userInputResponse;
        System.out.println("Thank you for playing Keno! We hope you won more than you lost. Would you like to play again (1) Yes  (2) No");
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextInt();
        if (userInput == 1) {
            displayWelcomeMessage();
            return 1;
        } else if (userInput == 2) {
            System.out.println("Have a nice day");
            return 2;
        } else {
            System.out.println("null");
        }
        return 1;
    }

    public void playAgain(){

    }






    public int[] getPayoutRates() {
        return new int[] {
                0,
                1,    // 1 match
                5,      // 2 matches
                10,     // 3 matches
                15,     // 4 matches
                50,    // 5 matches
                100,   // 6 matches
                250,   // 7 matches
                500,  // 8 matches
                1000,  // 9 matches
                5000,  // 10 matches
        };
    }


    @Override
    public int askForWager(int playerBet) {
        Scanner scanner = new Scanner(System.in);
        int wager = 0;
        System.out.println("Please enter your wager amount: ");
        wager = Integer.parseInt(scanner.nextLine());
        return wager;
    }

    @Override
    public int adjustBalances(int playerBalance) {
        return 0;
    }

    @Override
    public void add(PlayerInterface player) {
        this.player = (KenoPlayer)player;
    }

    @Override
    public void addCasinoAccountManager(CasinoAccountManager casinoAccountManager) {
        this.casinoAccountManager = casinoAccountManager;
        myPlayer = this.casinoAccountManager.getAccount(this.userName, this.password);
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

        KenoGame kenoGame = new KenoGame();
        int userInput = 1;


        // begins game
        kenoGame.displayWelcomeMessage();

        while (userInput == 1) {
            // user is prompted to insert 20 different numbers between 1-80
            List<Integer> selectedNumbers = kenoGame.userSelectedNumbers();
            System.out.println("Selected Numbers: " + selectedNumbers);


            List<Integer> winningNumbers = kenoGame.generateWinningNumbers();
            System.out.println("Winning Numbers: " + winningNumbers);


            int matches = kenoGame.compareSelectedAndWinningNumbers(selectedNumbers, winningNumbers);
            System.out.println("Number of Matches: " + matches);


            int betAmount = 1;
            int payout = kenoGame.getCalculatePayOut(matches, betAmount);
            pay = payout;
            myPlayer.setAccountBalance(myPlayer.getAccountBalance() + pay);
            System.out.println("Payout: $" + payout);
            System.out.println("Your new current balance is " + myPlayer.getAccountBalance() );


            if (kenoGame.displayEnding(1) == 2) {
                userInput = 2;
            }


        }

    }
}

