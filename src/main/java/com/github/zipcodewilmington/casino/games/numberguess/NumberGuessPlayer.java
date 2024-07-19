package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessPlayer extends CasinoAccountManager implements PlayerInterface  {
//    public String userName;
//    public String password;
//    public String getUserName() {
//        return userName;
//    }
//    public CasinoAccount theCasinoAccount;
//
//    public NumberGuessPlayer(CasinoAccount casAcct){
//        this.theCasinoAccount = casAcct;
//    }

//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//
//    public void helloWorld(){
//        System.out.println("hello world from number guess player");
//    }

    @Override
    public CasinoAccount getArcadeAccount(String userName, String password) {
        return getAccount(userName, password);
    }

//    @Override
//    public CasinoAccount getAccount(String accountName, String accountPassword) {
//        return getAccount(accountName, accountPassword);
//    }
}