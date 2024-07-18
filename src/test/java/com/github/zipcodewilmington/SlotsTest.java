package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;

public class SlotsTest {

    SlotsGame slots;

    @Before
    public void setUp() throws Exception{
        slots = new SlotsGame();
    }

    @Test
    public final void testSpinWheelTrue(){
        //given boolean
        //return arraylist
        SlotsGame slotsGame = new SlotsGame();
        boolean decision = true;
        //calls spinWheel method to generate an arrayList of random numbers of size 5
        ArrayList<Integer> arrayList = slotsGame.spinWheel(decision, 5);
        Assert.assertEquals(arrayList.size(), 5);
    }

    @Test
    public final void testCheckForMatchThree(){
        //given an arraylist of size 5 with random numbers from 0-9 check if there are 3 matching numbers
        SlotsGame slotsGame = new SlotsGame();
        //creates an ArrayList with random numbers but using 3 matching for testing purposes
        ArrayList<Integer> matchThree = new ArrayList<>(Arrays.asList(1, 3, 5, 5, 5));
        ArrayList<Integer> noMatch = new ArrayList<>(Arrays.asList(1,3,4,6,5));
        //return boolean
        Assert.assertTrue(slotsGame.checkForMatchThree(matchThree));
        Assert.assertFalse(slotsGame.checkForMatchThree(noMatch));
    }

    @Test
    public final void testCheckForMatchFive(){
        //given an arraylist of size 5 with random numbers from 0-9 check if there are 5 matching numbers
        SlotsGame slotsGame = new SlotsGame();
        //creates an ArrayList with random numbers but using all 5's for testing purposes
        ArrayList<Integer> matchThree = new ArrayList<>(Arrays.asList(5, 5, 5, 5, 5));
        ArrayList<Integer> noMatch = new ArrayList<>(Arrays.asList(1,3,4,6,5));
        //return boolean
        Assert.assertTrue(slotsGame.checkForMatchFive(matchThree));
        Assert.assertFalse(slotsGame.checkForMatchFive(noMatch));
    }

    @Test
    public final void testJackpot(){
        //given an arraylist of size 5 with all elements = 7
        SlotsGame slotsGame = new SlotsGame();
        //creates an ArrayList with random numbers but using all 7's for testing purposes
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(7, 7, 7, 7, 7));
        boolean condition = slotsGame.jackpot(arrayList);
        //return boolean
        Assert.assertTrue(condition, "All numbers in ArrayList are 7's");
    }


    @Test
    public final void payOutFor3Test(){
        //given a boolean, return int times three
        SlotsGame slotsGame = new SlotsGame();

        //returns int times three
        boolean resultTrue = true;
        int conditionTrue = slotsGame.payOutForThree(resultTrue);
        Assert.assertEquals(3, conditionTrue);

        boolean resultFalse = false;
        int conditionFalse = slotsGame.payOutForThree(resultFalse);
        Assert.assertEquals(0, conditionFalse);
    }

    @Test
    public final void payOutFor5Test(){
        //given a boolean, return int times seven
        SlotsGame slotsGame = new SlotsGame();

        //return int times seven
        boolean resultTrue = true;
        int conditionTrue = slotsGame.payOutForFive(resultTrue);
        Assert.assertEquals(7, conditionTrue);

        boolean resultFalse = false;
        int conditionFalse = slotsGame.payOutForFive(resultFalse);
        Assert.assertEquals(0, conditionFalse);
    }

    @Test
    public final void payOutJackpot(){
        //given a boolean, return int times 20
        SlotsGame slotsGame = new SlotsGame();

        boolean resultTrue = true;
        int conditionTrue = slotsGame.payOutForJackpot(resultTrue);
        Assert.assertEquals(20, conditionTrue);

        boolean resultFalse = false;
        int conditionFalse = slotsGame.payOutForJackpot(resultFalse);
        Assert.assertEquals(0, conditionFalse);

    }

}
