package com.bridgelabs.basicCorePrograms;

public class MathematicalPrograms1 {

    // 1. Flip Coin → return result as String
    public static String flipCoin(int flips) {

        int heads = 6;
        int tails = 4;

        double headPercent = (heads * 100.0) / flips;
        double tailPercent = (tails * 100.0) / flips;

        return "Heads % = " + headPercent + ", Tails % = " + tailPercent;
    }

    // 2. Leap Year → return result
    public static String checkLeapYear(int year) {

        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
            return year + " is a Leap Year";
        else
            return year + " is NOT a Leap Year";
    }

    // 3. Power of 2 → return result as String
    public static String powerOfTwo(int n) {

        String result = "";

        for (int i = 0; i <= n; i++) {
            result += "2^" + i + " = " + (int) Math.pow(2, i) + "\n";
        }

        return result;
    }

    // 4. Harmonic Number → return value
    public static double harmonicNumber(int n) {

        double sum = 0.0;

        for (int i = 1; i <= n; i++) {
            sum += (1.0 / i);
        }

        return sum;
    }

    // 5. Prime Factors → return result as String
    public static String primeFactors(int n) {

        String result = "";

        while (n % 2 == 0) {
            result += 2 + " ";
            n /= 2;
        }

        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                result += i + " ";
                n /= i;
            }
        }

        if (n > 2) {
            result += n;
        }

        return result;
    }

    // MAIN METHOD → ONLY INPUT + PRINT
    public static void main(String[] args) {

        System.out.println("1. Flip Coin:");
        System.out.println(flipCoin(10));

        System.out.println("\n2. Leap Year:");
        System.out.println(checkLeapYear(2024));

        System.out.println("\n3. Power of 2:");
        System.out.println(powerOfTwo(5));

        System.out.println("\n4. Harmonic Number:");
        System.out.println(harmonicNumber(5));

        System.out.println("\n5. Prime Factors:");
        System.out.println(primeFactors(84));
    }
}