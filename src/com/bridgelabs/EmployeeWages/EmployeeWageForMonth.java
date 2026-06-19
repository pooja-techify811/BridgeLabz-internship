package com.bridgelabs.EmployeeWages;

import java.util.Random;

public class EmployeeWageForMonth {

    public static void main(String[] args) {

        final int WAGE_PER_HOUR = 20;
        final int FULL_TIME_HOURS = 8;
        final int PART_TIME_HOURS = 4;
        final int MAX_WORKING_DAYS = 20;
        final int MAX_WORKING_HOURS = 100;

        int totalWorkingHours = 0;
        int totalWorkingDays = 0;

        Random random = new Random();

        while (totalWorkingHours < MAX_WORKING_HOURS &&
                totalWorkingDays < MAX_WORKING_DAYS) {

            totalWorkingDays++;

            int empCheck = random.nextInt(3);
            int empHours = 0;

            switch (empCheck) {
                case 1:
                    empHours = FULL_TIME_HOURS;
                    break;
                case 2:
                    empHours = PART_TIME_HOURS;
                    break;
                default:
                    empHours = 0;
            }

            totalWorkingHours += empHours;
        }

        int totalWage = totalWorkingHours * WAGE_PER_HOUR;

        System.out.println("Total Working Days: " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalWorkingHours);
        System.out.println("Total Employee Wage: " + totalWage);
    }
}