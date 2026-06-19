package com.bridgelabs.SnakeAndLadder;

import java.util.Random;

public class SnakeLadderTwoPlayerGame {

    public static void main(String[] args) {

        int player1Position = 0;
        int player2Position = 0;

        final int WINNING_POSITION = 100;

        int currentPlayer = 1;

        Random random = new Random();

        while (player1Position < WINNING_POSITION && player2Position < WINNING_POSITION) {

            int dieRoll = random.nextInt(6) + 1;
            int option = random.nextInt(3); // 0 No Play, 1 Ladder, 2 Snake

            System.out.println("\nPlayer " + currentPlayer + " turn");
            System.out.println("Die Roll: " + dieRoll);

            boolean playAgain = false;

            switch (option) {

                case 0:
                    System.out.println("Option: No Play");
                    break;

                case 1:
                    System.out.println("Option: Ladder");
                    playAgain = true;
                    if (currentPlayer == 1) {
                        player1Position += dieRoll;
                    } else {
                        player2Position += dieRoll;
                    }
                    break;

                case 2:
                    System.out.println("Option: Snake");
                    if (currentPlayer == 1) {
                        player1Position -= dieRoll;
                        if (player1Position < 0) player1Position = 0;
                    } else {
                        player2Position -= dieRoll;
                        if (player2Position < 0) player2Position = 0;
                    }
                    break;
            }

            if (currentPlayer == 1) {
                System.out.println("Player 1 Position: " + player1Position);
            } else {
                System.out.println("Player 2 Position: " + player2Position);
            }

            // Check winner
            if (player1Position >= WINNING_POSITION) {
                System.out.println("\n🎉 Player 1 Wins the Game!");
                break;
            }

            if (player2Position >= WINNING_POSITION) {
                System.out.println("\n🎉 Player 2 Wins the Game!");
                break;
            }

            // If ladder → same player plays again
            if (!playAgain) {
                currentPlayer = (currentPlayer == 1) ? 2 : 1;
            }
        }
    }
}