package com.bridgelabs.EmployeeWages;

import java.util.Random;

public class PartTimeEmployeeWage {

    public static void main(String[] args) {

        final int WAGE_PER_HOUR = 20;
        final int FULL_TIME_HOURS = 8;
        final int PART_TIME_HOURS = 4;

        Random random = new Random();
        int empCheck = random.nextInt(3); // 0 = Absent, 1 = Full Time, 2 = Part Time

        int empHours = 0;

        if (empCheck == 1) {
            empHours = FULL_TIME_HOURS;
            System.out.println("Employee is Full Time Present");
        } else if (empCheck == 2) {
            empHours = PART_TIME_HOURS;
            System.out.println("Employee is Part Time Present");
        } else {
            System.out.println("Employee is Absent");
        }

        int dailyWage = empHours * WAGE_PER_HOUR;

        System.out.println("Daily Employee Wage: " + dailyWage);
    }
}