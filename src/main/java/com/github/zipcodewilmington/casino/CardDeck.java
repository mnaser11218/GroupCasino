package com.github.zipcodewilmington.casino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CardDeck {

    public ArrayList<Card> getCardDeck() {
        return cardDeck;
    }
    private ArrayList<Card> cardDeck;

    public CardDeck(){
        this.cardDeck = new ArrayList();
        for (int i = 0; i < 13; i++){
            CardValue value = CardValue.values()[i];
            for (int j = 0; j < 4; j++){
                Card card = new Card(value, Suit.values()[j]);
                this.cardDeck.add(card);
            }
        }
//        Collections.shuffle(cardDeck);
        Iterator cardIterator = cardDeck.iterator();
        while (cardIterator.hasNext()){
            Card aCard = (Card) cardIterator.next();
            System.out.println(aCard.getCardValue() + " of " + aCard.getSuit());
        }
    }

}
