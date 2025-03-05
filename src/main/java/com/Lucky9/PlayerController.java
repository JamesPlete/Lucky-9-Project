package com.Lucky9;

public class PlayerController {

    private PlayerController(){}

    public static boolean isNameInvalid(String playerName){
        return playerName.isEmpty();
    }

    public static boolean isInitialFundEmpty(int initialFund){
        return initialFund <= 0;
    }

    public static void playerNameValidator(String player){
        if (PlayerController.isNameInvalid(player)){
            throw new IllegalArgumentException("Name can't be empty.");
        }
    }

    public static void playerInitialFundValidator(int initialFund){
        if (isInitialFundEmpty(initialFund)) {
            throw new IllegalStateException("Initial fund can't be empty.");
        }
    }

    public static boolean isBalanceEnough(Player player, int totalBet){
        return player.getBalance() - totalBet < 0;
    }

    public static boolean isBalanceZero(Player player){
        return player.getBalance() == 0;
    }

    public static boolean isDeckThreeCards(Player player) {
        return player.getPlayerHand().size() == 3;
    }

    public static int getCashHomeTakeOut(Player player){
        if (player.getBalance() == player.getInitialFund()){
            return player.getBalance();
        }

        return Math.max(player.getBalance() - player.getInitialFund(), 0);
    }

    public static int getTotalCardsValue(Player player) {
        int totalCardsValue = player.getPlayerHand()
                .stream()
                .mapToInt(Card:: getValue)
                .sum();

        if (totalCardsValue >= 10){
            return totalCardsValue % 10;
        }

        return totalCardsValue;
    }

    public static String forToString(Player player){
        Card[] playerCards = player.getPlayerHand().toArray(new Card[0]);
        if (isDeckThreeCards(player)){
            return "1st card: " + playerCards[0]+ "\n2nd card: " + playerCards[1] + "\n3rd card: " + playerCards[2] + "\n" + player.getPlayerName() + " deck value: " +player.getTotalCardsValue();
        }

        return "1st card: " + playerCards[0] + "\n2nd card: " + playerCards[1] + "\n" + player.getPlayerName() + " deck value: " + player.getTotalCardsValue();
    }
}
