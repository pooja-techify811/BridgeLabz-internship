package com.bridgelabs.numbers;



public class NumberProblem2 {

    // 11. Check Even or Odd
    public static String checkEvenOrOdd(int number) {

        if (number % 2 == 0) {
            return "Even";
        }

        return "Odd";
    }

    // 12. Swap Two Numbers Without Third Variable
    public static int[] swapNumbers(int a, int b) {

        a = a + b;
        b = a - b;
        a = a - b;

        return new int[]{a, b};
    }

    // 13. Largest of Three Numbers
    public static int largestOfThree(int a, int b, int c) {

        int largest = a;

        if (b > largest) {
            largest = b;
        }

        if (c > largest) {
            largest = c;
        }

        return largest;
    }

    // 14. Perfect Number
    public static boolean isPerfectNumber(int number) {

        int sum = 0;

        for (int i = 1; i < number; i++) {

            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }

    // 15. Strong Number
    public static boolean isStrongNumber(int number) {

        int original = number;
        int sum = 0;

        while (number > 0) {

            int digit = number % 10;

            int factorial = 1;

            for (int i = 1; i <= digit; i++) {
                factorial *= i;
            }

            sum += factorial;
            number = number / 10;
        }

        return sum == original;
    }

    // 16. Automorphic Number
    public static boolean isAutomorphicNumber(int number) {

        int square = number * number;

        return String.valueOf(square).endsWith(String.valueOf(number));
    }

    // 17. Decimal to Binary
    public static String decimalToBinary(int number) {

        String binary = "";

        while (number > 0) {

            binary = (number % 2) + binary;
            number = number / 2;
        }

        return binary;
    }

    // 18. Binary to Decimal
    public static int binaryToDecimal(int binary) {

        int decimal = 0;
        int power = 0;

        while (binary > 0) {

            int digit = binary % 10;

            decimal += digit * (int) Math.pow(2, power);

            power++;
            binary = binary / 10;
        }

        return decimal;
    }

    // 19. Check Power of Two
    public static boolean isPowerOfTwo(int number) {

        if (number <= 0) {
            return false;
        }

        while (number > 1) {

            if (number % 2 != 0) {
                return false;
            }

            number = number / 2;
        }

        return true;
    }

    // 20. Count Set Bits
    public static int countSetBits(int number) {

        int count = 0;

        while (number > 0) {

            if (number % 2 == 1) {
                count++;
            }

            number = number / 2;
        }

        return count;
    }

    public static void main(String[] args) {

        int input11 = 15;
        String result11 = checkEvenOrOdd(input11);
        System.out.println(result11);

        int input12a = 10;
        int input12b = 20;
        int[] result12 = swapNumbers(input12a, input12b);
        System.out.println("a = " + result12[0]);
        System.out.println("b = " + result12[1]);

        int input13a = 10;
        int input13b = 30;
        int input13c = 20;
        int result13 = largestOfThree(input13a, input13b, input13c);
        System.out.println(result13);

        int input14 = 28;
        boolean result14 = isPerfectNumber(input14);
        System.out.println(result14 ? "Perfect Number" : "Not Perfect Number");

        int input15 = 145;
        boolean result15 = isStrongNumber(input15);
        System.out.println(result15 ? "Strong Number" : "Not Strong Number");

        int input16 = 25;
        boolean result16 = isAutomorphicNumber(input16);
        System.out.println(result16 ? "Automorphic Number" : "Not Automorphic Number");

        int input17 = 10;
        String result17 = decimalToBinary(input17);
        System.out.println(result17);

        int input18 = 1010;
        int result18 = binaryToDecimal(input18);
        System.out.println(result18);

        int input19 = 16;
        boolean result19 = isPowerOfTwo(input19);
        System.out.println(result19);

        int input20 = 13;
        int result20 = countSetBits(input20);
        System.out.println(result20);
    }
}
