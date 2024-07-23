package com.github.zipcodewilmington.casino;

public class Card {

    private Suit suit;
    private int cardValue;

    public Card (int cardValue, Suit suit){
        this.cardValue = cardValue;
        this.suit = suit;
    }

    public Suit getSuit(){
        return suit;
    }

    public void setSuit(Suit suit){
        this.suit = suit;
    }

    public int getCardValue(){
        return cardValue;
    }

    public void setCardValue(int cardValue){
        this.cardValue = cardValue;
    }

//    public static void displayCardAsString(Card card){
//        System.out.println(card.getCardValue() + " of " + card.getSuit());
//    }


}
