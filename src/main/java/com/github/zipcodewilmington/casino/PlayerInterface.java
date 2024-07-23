package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 * All players of a game should abide by `PlayerInterface`.
 * All players must have reference to the `ArcadeAccount` used to log into the `Arcade` system.
 * All players are capable of `play`ing a game.
 */
public interface PlayerInterface {
    public String userName = "";
    public String password="";

    /**
     * @return the `ArcadeAccount` used to log into the `Arcade` system to play this game
     */
  //  CasinoAccount getArcadeAccount();
   // @Override
    CasinoAccount getArcadeAccount(String userName, String password);
//    default CasinoAccount getArcadeAccount(String currentUser, String currentPass){
//        CasinoAccount casinoAccount = new CasinoAccount();
//        return casinoAccount.getAccount(currentUser, currentPass);
//    };


//    void getArcadeAccount(String accountSignedIn, String passwordSignedIn);

    /**
     * Defines how a specific implementation of `PlayerInterface` plays their respective game.
     * @param <SomeReturnType> specify any return type you would like here
     * @return whatever return value you would like
     */
//    <SomeReturnType> SomeReturnType play();
}
