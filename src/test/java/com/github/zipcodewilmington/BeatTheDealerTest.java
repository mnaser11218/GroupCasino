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



}
