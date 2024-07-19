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

    public void addUserNameAndPassword(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    public void addCasinoAccountManager(CasinoAccountManager casinoAccountManager){
        this.casinoAccountManager = casinoAccountManager;
        this.myPlayerAccount = this.casinoAccountManager.getAccount(this.userName, this.password);
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
        //this.player = (NumberGuessPlayer)player;
        this.player = (NumberGuessPlayer)player;

       //this.playerAccount = player.getArcadeAccount();
    }



    public void run(){
       // System.out.println(this.player.getArcadeAccount());
        //System.out.println(player.getAccount());
//        System.out.println(this.player.getAccountName());
     // this.myPlayerAccount.setAccountBalance(myPlayerAccount.getAccountBalance() + 5);
     //   System.out.println("your balance is :" + myPlayerAccount.getAccountBalance());
       // System.out.println("username is: " + casino123.getAccountName() + " password is: " + casino123.getPassword() + " your balance is: "+ casino123.getAccountBalance());
//      CasinoAccount user123 =  this.player.getArcadeAccount(this.userName, this.password);
//        System.out.println( "your account name is: " + user123.getAccountName());

        System.out.println("Hello there, " + "");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a number between 0 to 100");
        generateRandomNumber();
        while(!appClosed){
            System.out.println("Please enter a number");
           userNumber = scanner.nextInt();
           // System.out.println("you entered the number " + userNumber);
            checkIfNumberTooHighOrTooLow();
        }

    }



    @Override
    public void remove(PlayerInterface player) {
        this.player = null;
    }


//    public static void main(String[] args) {
//        NumberGuessGame numberGuessGame = new NumberGuessGame();
//        numberGuessGame.run();
//
//    }


}