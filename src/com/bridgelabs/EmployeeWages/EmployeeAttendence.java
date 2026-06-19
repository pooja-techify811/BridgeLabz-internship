package com.bridgelabs.EmployeeWages;
import java.util.Random;
public class EmployeeAttendence {
    public static void main(String[] args) {

        Random random = new Random();

        int attendance = random.nextInt(2);

        if (attendance == 1) {
            System.out.println("Employee is Present");
        } else {
            System.out.println("Employee is Absent");
        }
    }
}