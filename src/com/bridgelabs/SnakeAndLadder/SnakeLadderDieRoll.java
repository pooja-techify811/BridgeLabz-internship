package com.bridgelabs.SnakeAndLadder;

import java.util.Random;

public class SnakeLadderDieRoll {

    public static void main(String[] args) {

        Random random = new Random();

        int dieRoll = random.nextInt(6) + 1;

        System.out.println("Die Roll: " + dieRoll);
    }
}