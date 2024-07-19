package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount extends CasinoAccountManager {
    public String accountName = "testing";
    public String password;
    public int accountBalance;
//    private CasinoAccount account;
//
//
//
//
//    public CasinoAccount getAccount() {
//        return account;
//    }
//
//    public void setAccount(CasinoAccount account) {
//        this.account = account;
//    }


   // CasinoAccount casinoAccount = this.getAccount("mohammed", "mohammed");


    public CasinoAccount() {
    }



    public CasinoAccount(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public static void main(String[] args) {
    }


}
