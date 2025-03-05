package com.Lucky9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameController {
    private final Scanner userInput = new Scanner(System.in);
    

    public void choiceView() {
        System.out.println("""
                ===================================================================
                -----------------------[WELCOME TO LUCKY 9]------------------------
                ===================================================================
                """);

        System.out.println("""
                1) Start Game
                2) View Leaderboard
                3) EXit Game
                """);

        System.out.print("Choose the number to proceed: ");
        try {
            byte userChoice = userInput.nextByte();

            switch (userChoice) {

            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter numbers within 1-3 only.");
        }
    }

    public void userChoice1() {
        try {
            System.out.print("Please enter your dealer name: ");
            String dealerName = userInput.nextLine();
            if (dealerName.isEmpty()) {
                throw new InvalidDealerNameException();
            }

            System.out.print("\nPlease enter your cash fund: ");
            int dealerFund = userInput.nextInt();
            if (dealerFund <= 0) {
                throw new InvalidDealerFundException();
            }

            System.out.print("\nPlease enter number of player(s): ");
            byte numberOfPlayers = userInput.nextByte();
            if (numberOfPlayers <= 0 || numberOfPlayers > 20) {
                throw new InvalidNumberOfPlayerException();
            }

        } catch (InvalidDealerNameException e) {
            System.out.println("Dealer name can't be empty or the same with the default names. (Player 1-2)");
        } catch (InvalidDealerFundException e) {
            System.out.println("Initial fund can't be empty or negative.");
        } catch (InvalidNumberOfPlayerException e) {
            System.out.println("Number of players can't be empty or exceed 20.");
        }

    }

    private void userChoice2() {

    }
    private void userChoice3() {

    }

    private void gameSet(){

    }
    private static class InvalidDealerNameException extends Exception {}
    private static class InvalidDealerFundException extends Exception {}
    private static class InvalidNumberOfPlayerException extends Exception {}
}



