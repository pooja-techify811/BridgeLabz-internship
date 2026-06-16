package com.bridgelabs.numbers;


public class NumberProblems1 {

    // 1. Check Prime Number
    public static boolean isPrime(int number) {

        if (number <= 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {

            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    // 2. Print Prime Numbers in Range
    public static String primeNumbersInRange(int n) {

        String result = "";

        for (int i = 2; i <= n; i++) {

            boolean prime = true;

            for (int j = 2; j < i; j++) {

                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime) {
                result += i + " ";
            }
        }

        return result.trim();
    }

    // 3. Factorial of a Number
    public static int factorial(int number) {

        int factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        return factorial;
    }

    // 4. Fibonacci Series
    public static String fibonacciSeries(int n) {

        int first = 0;
        int second = 1;

        String result = "";

        for (int i = 1; i <= n; i++) {

            result += first + " ";

            int next = first + second;
            first = second;
            second = next;
        }

        return result.trim();
    }

    // 5. Reverse a Number
    public static int reverseNumber(int number) {

        int reverse = 0;

        while (number > 0) {

            int digit = number % 10;
            reverse = reverse * 10 + digit;
            number = number / 10;
        }

        return reverse;
    }

    // 6. Palindrome Number
    public static boolean isPalindrome(int number) {

        int original = number;
        int reverse = 0;

        while (number > 0) {

            int digit = number % 10;
            reverse = reverse * 10 + digit;
            number = number / 10;
        }

        return original == reverse;
    }

    // 7. Armstrong Number
    public static boolean isArmstrong(int number) {

        int original = number;
        int sum = 0;

        while (number > 0) {

            int digit = number % 10;
            sum += digit * digit * digit;
            number = number / 10;
        }

        return original == sum;
    }

    // 8. Sum of Digits
    public static int sumOfDigits(int number) {

        int sum = 0;

        while (number > 0) {

            sum += number % 10;
            number = number / 10;
        }

        return sum;
    }

    // 9. Count Digits
    public static int countDigits(int number) {

        int count = 0;

        while (number > 0) {

            count++;
            number = number / 10;
        }

        return count;
    }

    // 10. Find GCD/HCF
    public static int findGCD(int number1, int number2) {

        int gcd = 1;

        for (int i = 1; i <= number1 && i <= number2; i++) {

            if (number1 % i == 0 && number2 % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }

    public static void main(String[] args) {

        int input1 = 7;
        boolean result1 = isPrime(input1);
        System.out.println(result1 ? "Prime" : "Not Prime");

        int input2 = 20;
        String result2 = primeNumbersInRange(input2);
        System.out.println(result2);

        int input3 = 5;
        int result3 = factorial(input3);
        System.out.println(result3);

        int input4 = 7;
        String result4 = fibonacciSeries(input4);
        System.out.println(result4);

        int input5 = 12345;
        int result5 = reverseNumber(input5);
        System.out.println(result5);

        int input6 = 121;
        boolean result6 = isPalindrome(input6);
        System.out.println(result6 ? "Palindrome" : "Not Palindrome");

        int input7 = 153;
        boolean result7 = isArmstrong(input7);
        System.out.println(result7 ? "Armstrong" : "Not Armstrong");

        int input8 = 1234;
        int result8 = sumOfDigits(input8);
        System.out.println(result8);

        int input9 = 12345;
        int result9 = countDigits(input9);
        System.out.println(result9);

        int input10a = 12;
        int input10b = 18;
        int result10 = findGCD(input10a, input10b);
        System.out.println(result10);
    }
}
