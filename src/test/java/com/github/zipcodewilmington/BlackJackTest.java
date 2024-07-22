package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.blackjack.BlackJackGame;
import org.junit.Assert;
import org.testng.annotations.Test;

public class BlackJackTest {

    @Test
    public void checkBlackJackWinner(){
      BlackJackGame bjGame = new BlackJackGame();
      String actual = bjGame.userName;

      //then
      Assert.assertTrue(actual == null);
    }

    @Test
    public void checkBlackJackHand(){
        BlackJackGame bjGame = new BlackJackGame();
        String actual = bjGame.password;

        //then
        Assert.assertTrue(actual == null);
    }

    @Test
    public void checkBlackJackRound(){
        BlackJackGame bjGame = new BlackJackGame();
        //then
        Assert.assertTrue(bjGame.myPlayerAccount == null);
    }

    @Test
    public void checkBlackJackTurn(){
        BlackJackGame bjGame = new BlackJackGame();

        //then
        Assert.assertTrue(bjGame.myPlayerAccount == null);
    }

}
