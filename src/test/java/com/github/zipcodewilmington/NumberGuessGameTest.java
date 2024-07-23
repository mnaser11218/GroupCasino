package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NumberGuessGameTest {
    @Test
    public void generateRandomNumberTest(){
        NumberGuessGame numberGuessGame = new NumberGuessGame();
        Integer randomNum =(Integer) numberGuessGame.generateRandomNumber();

        assertTrue(randomNum instanceof Integer);
    }
//
    @Test
    public void getAndSetRandomNumberTest(){
        NumberGuessGame numberGuessGame = new NumberGuessGame();
        numberGuessGame.setRandomNumber(50);
        int expected = numberGuessGame.getRandomNumber();
        Assert.assertEquals(expected, 50);
    }
////
//    @Test
//    public void checkIfNumberTooHighOrTooLowTest(){
//        NumberGuessGame numberGuessGame = new NumberGuessGame();
//        // check if number is too low
//        numberGuessGame.setRandomNumber(67);
//        numberGuessGame.setUserNumber(32);
//        assertEquals(false, numberGuessGame.checkIfNumberTooHighOrTooLow());
//
//
//        // check if number is too low
//
//        numberGuessGame.setRandomNumber(67);
//        numberGuessGame.setUserNumber(98);
//        assertEquals(false, numberGuessGame.checkIfNumberTooHighOrTooLow());
//
//        // check if number is a match
//
//        numberGuessGame.setRandomNumber(67);
//        numberGuessGame.setUserNumber(67);
//        assertEquals(true, numberGuessGame.checkIfNumberTooHighOrTooLow());
//
//    }
//
//    @Test
//    public void checkSizeOfUserInputNumberTest(){
//        NumberGuessGame numberGuessGame = new NumberGuessGame();
//        numberGuessGame.setUserNumber(56);
//        numberGuessGame.setUserNumber(5);
//        numberGuessGame.setUserNumber(6);
//        numberGuessGame.setUserNumber(43);
//        int inputSizeAmount = numberGuessGame.getUserInputs().size();
//
//        Assert.assertEquals(inputSizeAmount, 4);
//
//    }







}
