package com.github.zipcodewilmington.casino.games.numberguess;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame {

    private int userInput =0;
    private int randomNumber=0;
    private ArrayList<Integer> userInputs = new ArrayList<>();
    private boolean appClosed = false;

    public NumberGuessGame() {
    }

    public int getUserInput() {
        return userInput;
    }

    public void setUserInput(int userInput) {
        this.userInput = userInput;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public ArrayList<Integer> getUserInputs() {
        return userInputs;
    }

    public void setUserInputs(ArrayList<Integer> userInputs) {
        this.userInputs = userInputs;
    }

    public boolean isCloseApp() {
        return appClosed;
    }

    public void setCloseApp(boolean appClosed) {
        this.appClosed = appClosed;
    }

    public void checkIfNumberIsTooHighOrTooLow(){
        if(this.userInput > randomNumber){
            System.out.println("Your number is too high");
        } else if(this.userInput < randomNumber){
            System.out.println("Your number is too low");
        }else{
            System.out.println("Congrats! You selected the correct number in " + userInputs.size() + " amount of tries");
        }

    }

    public void generateRandomNumber(){
        int r = (int) (Math.random() * (100 - 1)) + 1;
        this.randomNumber = r;
    }

    public void run(){

        Scanner scanner = new Scanner(System.in);
        while(!appClosed){
            System.out.println("Please enter a number");
           userInput = scanner.nextInt();
            System.out.println("you entered the number " + userInput);

        }
       // System.out.println("hello world");
    }
    public static void main(String[] args) {
        NumberGuessGame numberGuessGame = new NumberGuessGame();
        numberGuessGame.run();

    }


}