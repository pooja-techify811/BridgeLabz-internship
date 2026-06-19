package com.bridgelabs.SnakeAndLadder;

import java.util.Random;

public class SnakeLadderGameTillWin {

    public static void main(String[] args) {

        int position = 0;
        final int WINNING_POSITION = 100;

        Random random = new Random();

        while (position < WINNING_POSITION) {

            int dieRoll = random.nextInt(6) + 1; // 1 to 6
            int option = random.nextInt(3);      // 0 = No Play, 1 = Ladder, 2 = Snake

            System.out.println("\nDie Roll: " + dieRoll);

            switch (option) {

                case 0:
                    System.out.println("Option: No Play");
                    break;

                case 1:
                    System.out.println("Option: Ladder");
                    position += dieRoll;
                    break;

                case 2:
                    System.out.println("Option: Snake");
                    position -= dieRoll;
                    break;
            }

            // if position goes below 0, reset to 0
            if (position < 0) {
                position = 0;
            }

            System.out.println("Current Position: " + position);
        }

        System.out.println("\n🎉 Player reached 100. Game Won!");
    }
}