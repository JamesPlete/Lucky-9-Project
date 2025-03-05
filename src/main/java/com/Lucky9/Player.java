package com.Lucky9;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private Set<Card> playerHand;
    private final String playerName;
    private final int initialFund;
    private int balance;
    private int betAmount;

    public Player (int initialFund, String playerName){
        this.initialFund = initialFund;
        this.playerName = playerName;
        this.balance = initialFund;
        this.playerHand = new HashSet<>();
    }

    public Set <Card> getPlayerHand(){
        return playerHand;
    }

    public int getBetAmount(){
        return betAmount;
    }

    public int getInitialFund() {
        return initialFund;
    }

    public int getBalance() {
        return balance;
    }

    public String getPlayerName(){
        return playerName;
    }

    public int getTotalCardsValue() {
     return PlayerController.getTotalCardsValue(this);
    }

    public void addCard(Card card){
        if (!PlayerController.isDeckThreeCards(this)){
            playerHand.add(card);
        } else {
            System.out.println("Player can only hold up to 3 cards in their hand.");
        }
    }

    @Override
    public String toString(){
        return PlayerController.forToString(this);
    }
}

class Dealer extends Player {

    public Dealer (int initialFund, String dealerName){
        super (initialFund, dealerName);
    }

    public int getTakeHomeCash(){
        return PlayerController.getCashHomeTakeOut(this);
    }
}
