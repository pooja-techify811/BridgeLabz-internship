package com.oops.java;



import java.util.Random;

public class DeckOfCards {
    public static void main(String[] args) {
        // Define suits and ranks arrays
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        // Initialize deck containing 52 cards total
        int totalCards = suits.length * ranks.length;
        String[] deck = new String[totalCards];

        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }

        // Shuffle the deck using a Random index swapping pattern
        Random random = new Random();
        for (int i = 0; i < deck.length; i++) {
            int randomIndex = random.nextInt(deck.length);
            // Swap elements
            String temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }

        // Create a 2D array to hold 9 cards for 4 players
        // Dimensions: 4 rows (Players), 9 columns (Cards)
        String[][] playerHands = new String[4][9];

        int cardIndex = 0;
        for (int player = 0; player < 4; player++) {
            for (int card = 0; card < 9; card++) {
                playerHands[player][card] = deck[cardIndex++];
            }
        }

        // Print the cards received by each player
        System.out.println("===== CARD DISTRIBUTION REPORT (2D Array) =====");
        for (int player = 0; player < 4; player++) {
            System.out.println("\nPlayer " + (player + 1) + "'s Hand:");
            System.out.print(" -> ");
            for (int card = 0; card < 9; card++) {
                System.out.print("[" + playerHands[player][card] + "]");
                if (card < 8) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
