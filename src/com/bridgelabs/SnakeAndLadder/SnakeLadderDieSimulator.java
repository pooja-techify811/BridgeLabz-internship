package com.bridgelabs.SnakeAndLadder;

import java.util.Random;

public class SnakeLadderDieSimulator {

    public static void main(String[] args) {

        int position = 0;

        Random random = new Random();

        int dieRoll = random.nextInt(6) + 1;   // 1 to 6
        int option = random.nextInt(3);        // 0 = No Play, 1 = Ladder, 2 = Snake

        System.out.println("Die Roll: " + dieRoll);

        switch (option) {

            case 0:
                System.out.println("Option: No Play");
                System.out.println("Position remains same: " + position);
                break;

            case 1:
                System.out.println("Option: Ladder");
                position += dieRoll;
                System.out.println("Moved forward to: " + position);
                break;

            case 2:
                System.out.println("Option: Snake");
                position -= dieRoll;
                if (position < 0) {
                    position = 0;
                }
                System.out.println("Moved backward to: " + position);
                break;
        }
    }
}