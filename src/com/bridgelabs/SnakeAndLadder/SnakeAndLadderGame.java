package com.bridgelabs.SnakeAndLadder;

import java.util.Random;

public class SnakeAndLadderGame {

    public static void main(String[] args) {

        int position = 0;

        Random random = new Random();

        while (position < 100) {

            int dieRoll = random.nextInt(6) + 1;
            int option = random.nextInt(3); // 0 = No Play, 1 = Ladder, 2 = Snake

            switch (option) {
                case 1:
                    position += dieRoll;
                    System.out.println("Ladder! Moved forward by " + dieRoll);
                    break;

                case 2:
                    position -= dieRoll;
                    if (position < 0) {
                        position = 0;
                    }
                    System.out.println("Snake! Moved backward by " + dieRoll);
                    break;

                default:
                    System.out.println("No Play");
            }

            System.out.println("Current Position: " + position);
        }

        System.out.println("Player reached 100. Game Won!");
    }
}