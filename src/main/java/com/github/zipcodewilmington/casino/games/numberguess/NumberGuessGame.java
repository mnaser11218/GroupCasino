package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame extends CasinoAccountManager implements GameInterface {

    private int userNumber =0;
    private int randomNumber=0;
    private ArrayList<Integer> userInputs = new ArrayList<>();
    private boolean appClosed = false;
    public NumberGuessPlayer player;
    private CasinoAccount myPlayerAccount;
    public String userName;
    public String password;
    public CasinoAccountManager casinoAccountManager;
    public CasinoAccount secondPlayer;
    public ArrayList<CasinoAccount> arcadeAccountList;

    public void addUserNameAndPassword(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    public void addCasinoAccountManager(CasinoAccountManager casinoAccountManager){
        this.casinoAccountManager = casinoAccountManager;
        this.myPlayerAccount = this.casinoAccountManager.getAccount(this.userName, this.password);
        arcadeAccountList = (ArrayList<CasinoAccount>) casinoAccountManager.getArcadeAccountList();
    }
    public NumberGuessGame() {
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber= userNumber;
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

    public boolean checkIfNumberTooHighOrTooLow(){
        Scanner scanner = new Scanner(System.in);
       this.userInputs.add(this.userNumber);
        if(this.userNumber > randomNumber){
            System.out.println("My Number is less than " + this.userNumber);
            return false;
        } else if(this.userNumber < randomNumber){
            System.out.println("My Number is greater than " + this.userNumber);
            return false;
        }
            System.out.println("Well Done ! It took you " + userInputs.size() + " amount of tries");
        System.out.println("Would you like to play again? yes/no");
        String userInput = scanner.nextLine();
        if(userInput.equalsIgnoreCase("no")){
            this.appClosed = true;
            return true;
        }
        userInputs.clear();
        return true;
    }

    public int generateRandomNumber(){
        int r = (int) (Math.random() * (100 - 1)) + 1;
        this.randomNumber = r;
        return r;
    }
    public void add(PlayerInterface player){
        this.player = (NumberGuessPlayer)player;
    }



    public void run(){
         //implementing two players:
                System.out.println("Please choose a second player: ");
                for(CasinoAccount c:  arcadeAccountList){
                 if(!c.getAccountName().equals(userName)) {
                     System.out.println("player name -> " + c.getAccountName() + " \nBalance amount: " + c.getAccountBalance());
                 }
        }

        System.out.println("Welcome, your balance is : " + myPlayerAccount.getAccountBalance());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a number between 0 to 100");
        generateRandomNumber();
        while(!appClosed){
            System.out.println("Please enter a number");
           userNumber = scanner.nextInt();
            checkIfNumberTooHighOrTooLow();
        }

    }


    @Override
    public void remove(PlayerInterface player) {
        this.player = null;
    }

}