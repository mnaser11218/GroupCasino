package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.keno.KenoGame;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class KenoTest {
    private KenoGame kenoGame;

    @Before
    public void setUp() {
        kenoGame = new KenoGame();
    }

    @Test
    public void testGenerateWinningNumbers() {
        // given
        int expectedSize = 10;
        int minNumber = 1;
        int maxNumber = 80;

        // when
        List<Integer> winningNumbers = kenoGame.generateWinningNumbers();

        // then
        assertEquals(expectedSize, winningNumbers.size());
    }

    @Test
    public void testCompareSelectedAndWinningNumbers() {
        // given
        List<Integer> selectedNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> winningNumbers = List.of(1, 11, 21, 31, 41, 51, 61, 71, 81, 10);
        int expectedMatches = 2;

        // when
        int actualMatches = kenoGame.compareSelectedAndWinningNumbers(selectedNumbers, winningNumbers);

        // then
        assertEquals(expectedMatches, actualMatches);
    }

    @Test
    public void testGetCalculatePayOut() {
        // given
        int numbersMatched = 4;
        int amount = 1;
        int expectedPayout = 15;

        // when
        int actualPayout = kenoGame.getCalculatePayOut(numbersMatched, amount);

        // then
        assertEquals(expectedPayout, actualPayout, 0);

    }

}