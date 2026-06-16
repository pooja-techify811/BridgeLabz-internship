package com.bridgelabs.strings;



public class Stringproblem1 {

    // 1. Reverse a String
    public static String reverseString(String str) {
        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        return reversed;
    }

    // 2. Check Palindrome String
    public static boolean isPalindrome(String str) {
        String reversed = reverseString(str);
        return str.equals(reversed);
    }

    // 3. Check Anagram
    public static boolean isAnagram(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        for (int i = 0; i < arr1.length - 1; i++) {
            for (int j = i + 1; j < arr1.length; j++) {

                if (arr1[i] > arr1[j]) {
                    char temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                }

                if (arr2[i] > arr2[j]) {
                    char temp = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    // 4. Find First Non-Repeated Character
    public static char firstNonRepeatedCharacter(String str) {

        for (int i = 0; i < str.length(); i++) {

            int count = 0;

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                }
            }

            if (count == 1) {
                return str.charAt(i);
            }
        }

        return ' ';
    }

    // 5. Remove Duplicate Characters
    public static String removeDuplicates(String str) {

        String result = "";

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (result.indexOf(ch) == -1) {
                result += ch;
            }
        }

        return result;
    }

    // 6. Find Duplicate Characters
    public static String findDuplicateCharacters(String str) {

        String duplicates = "";

        for (int i = 0; i < str.length(); i++) {

            int count = 0;

            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                }
            }

            if (count > 0) {

                boolean alreadyPrinted = false;

                for (int k = 0; k < i; k++) {
                    if (str.charAt(k) == str.charAt(i)) {
                        alreadyPrinted = true;
                        break;
                    }
                }

                if (!alreadyPrinted) {
                    duplicates += str.charAt(i) + " ";
                }
            }
        }

        return duplicates.trim();
    }

    // 7. Count Character Occurrences
    public static int countOccurrences(String str, char target) {

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                count++;
            }
        }

        return count;
    }

    // 8. Reverse Each Word in a String
    public static String reverseEachWord(String str) {

        String[] words = str.split(" ");
        String result = "";

        for (String word : words) {

            String reversedWord = "";

            for (int i = word.length() - 1; i >= 0; i--) {
                reversedWord += word.charAt(i);
            }

            result += reversedWord + " ";
        }

        return result.trim();
    }

    // 9. Count Vowels and Consonants
    public static int[] countVowelsAndConsonants(String str) {

        int vowels = 0;
        int consonants = 0;

        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch >= 'a' && ch <= 'z') {

                if (ch == 'a' || ch == 'e' || ch == 'i'
                        || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        return new int[]{vowels, consonants};
    }

    // 10. Longest Substring Without Repeating Characters
    public static int longestSubstringWithoutRepeating(String str) {

        int maxLength = 0;

        for (int i = 0; i < str.length(); i++) {

            String temp = "";

            for (int j = i; j < str.length(); j++) {

                if (temp.indexOf(str.charAt(j)) != -1) {
                    break;
                }

                temp += str.charAt(j);
            }

            if (temp.length() > maxLength) {
                maxLength = temp.length();
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        // 1. Reverse String
        String input1 = "hello";
        String reverseResult = reverseString(input1);
        System.out.println("1. Reverse String: " + reverseResult);

        // 2. Palindrome
        String input2 = "madam";
        boolean palindromeResult = isPalindrome(input2);
        System.out.println("2. Palindrome: "
                + (palindromeResult ? "Palindrome" : "Not Palindrome"));

        // 3. Anagram
        String input3a = "listen";
        String input3b = "silent";
        boolean anagramResult = isAnagram(input3a, input3b);
        System.out.println("3. Anagram: "
                + (anagramResult ? "Anagram" : "Not Anagram"));

        // 4. First Non-Repeated Character
        String input4 = "swiss";
        char firstNonRepeatedResult = firstNonRepeatedCharacter(input4);
        System.out.println("4. First Non-Repeated Character: "
                + firstNonRepeatedResult);

        // 5. Remove Duplicate Characters
        String input5 = "programming";
        String removeDuplicateResult = removeDuplicates(input5);
        System.out.println("5. Remove Duplicates: "
                + removeDuplicateResult);

        // 6. Find Duplicate Characters
        String input6 = "programming";
        String duplicateCharactersResult = findDuplicateCharacters(input6);
        System.out.println("6. Duplicate Characters: "
                + duplicateCharactersResult);

        // 7. Count Character Occurrences
        String input7 = "hello";
        char targetCharacter = 'l';
        int occurrenceResult = countOccurrences(input7, targetCharacter);
        System.out.println("7. Occurrences of '" + targetCharacter + "' : "
                + occurrenceResult);

        // 8. Reverse Each Word
        String input8 = "Java is Easy";
        String reverseWordResult = reverseEachWord(input8);
        System.out.println("8. Reverse Each Word: "
                + reverseWordResult);

        // 9. Count Vowels and Consonants
        String input9 = "hello";
        int[] vowelConsonantResult = countVowelsAndConsonants(input9);
        System.out.println("9. Vowels = " + vowelConsonantResult[0]);
        System.out.println("   Consonants = " + vowelConsonantResult[1]);

        // 10. Longest Substring Without Repeating Characters
        String input10 = "abcabcbb";
        int longestSubstringResult =
                longestSubstringWithoutRepeating(input10);
        System.out.println("10. Longest Substring Length: "
                + longestSubstringResult);
    }
}
