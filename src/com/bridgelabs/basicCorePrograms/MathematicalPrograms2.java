package com.bridgelabs.basicCorePrograms;

public class MathematicalPrograms2 {

    // 6. Quotient and Remainder
    public static int[] quotientRemainder(int dividend, int divisor) {

        int quotient = dividend / divisor;
        int remainder = dividend % divisor;

        return new int[]{quotient, remainder};
    }

    // 7. Swap Two Numbers
    public static int[] swapNumbers(int a, int b) {

        a = a + b;
        b = a - b;
        a = a - b;

        return new int[]{a, b};
    }

    // 8. Even or Odd
    public static String evenOrOdd(int num) {

        return (num % 2 == 0) ? "Even" : "Odd";
    }

    // 9. Vowel or Consonant
    public static String vowelOrConsonant(char ch) {

        ch = Character.toLowerCase(ch);

        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return "Vowel";
        else
            return "Consonant";
    }

    // 10. Largest Among Three Numbers
    public static int largestOfThree(int a, int b, int c) {

        return Math.max(a, Math.max(b, c));
    }

    // MAIN METHOD → only sample inputs + printing outputs
    public static void main(String[] args) {

        // 6
        int[] qr = quotientRemainder(20, 6);
        System.out.println("6. Quotient = " + qr[0] + ", Remainder = " + qr[1]);

        // 7
        int[] swapped = swapNumbers(10, 20);
        System.out.println("7. Swapped Numbers: a = " + swapped[0] + ", b = " + swapped[1]);

        // 8
        System.out.println("8. Even or Odd: " + evenOrOdd(15));

        // 9
        System.out.println("9. Vowel or Consonant: " + vowelOrConsonant('e'));

        // 10
        System.out.println("10. Largest Number: " + largestOfThree(10, 25, 18));
    }
}