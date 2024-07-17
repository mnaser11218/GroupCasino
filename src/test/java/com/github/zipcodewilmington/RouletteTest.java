package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RouletteTest {

    RouletteGame roulette = new RouletteGame();

    @Before
    public void setUp() throws Exception {
        roulette = new RouletteGame();
    }

    @Test
    public final void testAskForBetType(){
        //given: Scanner

        //Get: Return String
        String expected = "RED";
        String actual = roulette.askForBetType();
        Assert.assertEquals(actual, expected);
    }

//    @Test
//    public final void testDeterminePayOutForNumber(){
//        //number payout is 35:1
//        int playerBet =500;
//        String betType = "17";
//
//        int actual = roulette.determinePayOutForNumber(playerBet, betType);
//
//        int expected =17500;
//
//        Assert.assertEquals(actual, expected);
//    }
//
//    @Test
//    public final void testDeterminePayOutForColor(){
//        //colour payout is 1:1
//        int playerBet =500;
//        String betType = "RED";
//
//        int actual = roulette.determinePayOutForColor(playerBet, betType);
//
//        int expected = 500;
//
//        Assert.assertEquals(actual, expected);
//    }
//
//    @Test
//    public final void testDeterminePayOutFor12s(){
//        //12s payout is 2:1
//        int playerBet =500;
//        String betType = "1st12";
//
//        int actual = roulette.determinePayOutFor12s(playerBet, betType);
//
//        int expected = 1000;
//
//        Assert.assertEquals(actual, expected);
//    }
//
//    @Test
//    public final void testDeterminePayOutForOddsOrEvens(){
//        //even/odd payout is 1:1
//        int playerBet =500;
//        String betType = "ODD";
//
//        int actual = roulette.determinePayOutForOddsOrEvens(playerBet, betType);
//
//        int expected = 500;
//
//        Assert.assertEquals(actual, expected);
//    }
}
