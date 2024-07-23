package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.beatTheDealer.BeatTheDealer;
import com.github.zipcodewilmington.casino.games.beatTheDealer.BeatTheDealerPlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BeatTheDealerTest {

    BeatTheDealer beatDealer = new BeatTheDealer();
    BeatTheDealerPlayer player = new BeatTheDealerPlayer();

    @Before
    public void setUp() throws Exception {
        beatDealer = new BeatTheDealer();
    }

    @Test
    public void calculateWinnerTest(){
        player.playerDiceValue = 10;
        int dealerDiceValue = 8;
        BeatTheDealerPlayer expected = player;

//        Assert.assertEquals(player, beatDealer.calculateWinner(player.playerDiceValue, dealerDiceValue));
    }

    @Test
    public void checkIf12HitsTest(){
        int dealerDiceValue = 12;
        Assert.assertTrue(beatDealer.checkIf12Hits(dealerDiceValue));
    }

    @Test
    public void checkIfTied(){
        int dealerDiceValue = 10;
        int playerDiceValue = 10;
        Assert.assertTrue(beatDealer.checkIfTied());
    }

    @Test
    public void playerDiceRollTest(){
    // tests that the dice was rolled, returning 2 or higher score for
    // rolling two dice.
        Assert.assertTrue(beatDealer.playerDiceRoll() > 2);
    }

    @Test
    public void playerWonTest1(){
        int playerDiceValue = 10;
        int dealerDiceValue = 9;

        Assert.assertTrue(beatDealer.playerWon(playerDiceValue,dealerDiceValue));
    }

    @Test
    public void playerWonTest2(){
        int playerDiceValue = 10;
        int dealerDiceValue = 10;

        Assert.assertFalse(beatDealer.playerWon(playerDiceValue,dealerDiceValue));
    }

    @Test
    public void playerWonTest3(){
        int playerDiceValue = 1;
        int dealerDiceValue = 9;

        Assert.assertFalse(beatDealer.playerWon(playerDiceValue,dealerDiceValue));
    }


    @Test
    public void addUserNameAndPasswordTest(){
        String userName = "NotDealer";
        String password = "29";
        beatDealer.addUserNameAndPassword(userName, password);
        String actual = beatDealer.userName;
        Assert.assertEquals(userName, actual);
    }




}
