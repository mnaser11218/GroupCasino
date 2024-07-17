package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.Card;
import com.github.zipcodewilmington.casino.CardDeck;
import com.github.zipcodewilmington.casino.CardValue;
import com.github.zipcodewilmington.casino.Suit;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    @Test
    public void getSuitTest(){
        Card oneCard = new Card(CardValue.TWO, Suit.SPADES);
        oneCard.setSuit(Suit.HEARTS);
        Suit expected = Suit.HEARTS;
        Suit actual = oneCard.getSuit();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getCardValueTest(){
        Card oneCard = new Card(CardValue.TWO, Suit.SPADES);
        oneCard.setCardValue(CardValue.JACK);
        CardValue expected = CardValue.JACK;
        CardValue actual = oneCard.getCardValue();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getDeckOfCardsTest(){
        CardDeck deck = new CardDeck();
        int actual = deck.getCardDeck().size();
        int expected = 52;
        Assert.assertEquals(actual,expected);
    }


}
