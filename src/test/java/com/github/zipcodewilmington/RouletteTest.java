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

//    @Test
//    public final void testAskForBetType(){
//        //given: Scanner
//
//        //Get: Return String
//        String expected = "RED";
//        String actual = roulette.askForBetType();
//        Assert.assertEquals(actual, expected);
//    }

    @Test
    public final void testDeterminePayoutAmount(){
        roulette.storedSpinResult = 17;
        String betType = "17";
        int playerBet = 500;

        int actual = roulette.determinePayOutAmount(playerBet, betType);
        int expected = 17500;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public final void testDeterminePayOutForNumber(){
        //number payout is 35:1
        String betType = "2";
        roulette.storedSpinResult = 2;

        int actual = roulette.determinePayOutForNumber(betType);
        int expected =35;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public final void testDeterminePayOutForColor(){
        //colour payout is 1:1
        String betType = "RED";
        roulette.storedSpinResult = 3;

        int actual = roulette.determinePayOutForColor(betType);
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public final void testDeterminePayOutFor12s(){
        //12s payout is 2:1
        String betType = "1st12";
        roulette.storedSpinResult = 11;

        int actual = roulette.determinePayOutFor12s(betType);
        int expected = 2;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public final void testDeterminePayOutForOddsOrEvens(){
        //even/odd payout is 1:1
        String betType = "EVEN";
        roulette.storedSpinResult = 6;

//        int actual = roulette.determinePayOutAmount(playerBet, betType);
        int actual = roulette.determinePayOutForOddsOrEvens(betType);
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test public final void testIsNumber(){
        String str = "17";

        Assert.assertTrue(roulette.isNumber(str));

    }
}
