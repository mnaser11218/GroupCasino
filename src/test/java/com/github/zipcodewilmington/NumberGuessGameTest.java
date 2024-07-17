//package com.github.zipcodewilmington;
//
//import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
//import org.junit.Assert;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//public class NumberGuessGameTest {
//    @Test
//    public void generateRandomNumberTest(){
//        NumberGuessGame numberGuessGame = new NumberGuessGame();
//        int randomNum = numberGuessGame.generateRandomNumber();
//
//        assertTrue(randomNum instanceof Integer);
//    }
////
//    @Test
//    public void getAndSetRandomNumberTest(){
//        NumberGuessGame numberGuessGame = new NumberGuessGame();
//        numberGuessGame.setRandomNumber(50);
//        int expected = numberGuessGame.getRandomNumber();
//        Assert.assertEquals(expected, 50);
//    }
//
//    @Test
//    public void checkIfNumberTooHighOrTooLowTest(){
//        NumberGuessGame numberGuessGame = new NumberGuessGame();
//        // check if number is too low
//        numberGuessGame.setRandomNumber(67);
//        numberGuessGame.setUserNumber(32);
//        assertEquals("Your number is too low", numberGuessGame.checkIfNumberTooHighOrTooLow());
//
//
//        // check if number is too low
//
//        numberGuessGame.setRandomNumber(67);
//        numberGuessGame.setUserNumber(98);
//        assertEquals("Your number is too high", numberGuessGame.checkIfNumberTooHighOrTooLow());
//
//        // check if number is a match
//
//        numberGuessGame.setRandomNumber(67);
//        numberGuessGame.setUserNumber(67);
//        assertEquals("You selected the correct number", numberGuessGame.checkIfNumberTooHighOrTooLow());
//
//    }
//
//    @Test
//    public void checkSizeOfUserInputNumberTest(){
//        NumberGuessGame numberGuessGame = new NumberGuessGame();
//        numberGuessGame.setUserInput(56);
//        numberGuessGame.setUserInput(5);
//        numberGuessGame.setUserInput(6);
//        numberGuessGame.setUserInput(43);
//        int inputSizeAmount = numberGuessGame.getinputs().size();
//
//        Assert.assertEquals(inputSizeAmount, 4);
//
//    }
//
//
//
//
//
//
//
//
//
//}
