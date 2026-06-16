package com.bridgelabs.strings;




    public class StringProblems2 {

        // 11. Check Whether Two Strings Are Rotations
        public static boolean isRotation(String str1, String str2) {

            if (str1.length() != str2.length()) {
                return false;
            }

            String temp = str1 + str1;
            return temp.contains(str2);
        }

        // 12. Find Longest Common Prefix
        public static String longestCommonPrefix(String[] arr) {

            String prefix = arr[0];

            for (int i = 1; i < arr.length; i++) {

                while (!arr[i].startsWith(prefix)) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                }
            }

            return prefix;
        }

        // 13. Remove All White Spaces
        public static String removeWhiteSpaces(String str) {

            String result = "";

            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) != ' ') {
                    result += str.charAt(i);
                }
            }

            return result;
        }

        // 14. Count Words in a String
        public static int countWords(String str) {

            String[] words = str.split(" ");
            return words.length;
        }

        // 15. Find Character Frequency
        public static String characterFrequency(String str) {

            String result = "";

            for (int i = 0; i < str.length(); i++) {

                char ch = str.charAt(i);
                int count = 0;

                boolean alreadyCounted = false;

                for (int k = 0; k < i; k++) {
                    if (str.charAt(k) == ch) {
                        alreadyCounted = true;
                        break;
                    }
                }

                if (!alreadyCounted) {

                    for (int j = 0; j < str.length(); j++) {
                        if (str.charAt(j) == ch) {
                            count++;
                        }
                    }

                    result += ch + "=" + count + "\n";
                }
            }

            return result;
        }

        // 16. Toggle Case
        public static String toggleCase(String str) {

            String result = "";

            for (int i = 0; i < str.length(); i++) {

                char ch = str.charAt(i);

                if (Character.isUpperCase(ch)) {
                    result += Character.toLowerCase(ch);
                } else {
                    result += Character.toUpperCase(ch);
                }
            }

            return result;
        }

        // 17. Check String Contains Only Digits
        public static boolean containsOnlyDigits(String str) {

            for (int i = 0; i < str.length(); i++) {

                if (!Character.isDigit(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        }

        // 18. Remove Special Characters
        public static String removeSpecialCharacters(String str) {

            String result = "";

            for (int i = 0; i < str.length(); i++) {

                char ch = str.charAt(i);

                if (Character.isLetterOrDigit(ch)) {
                    result += ch;
                }
            }

            return result;
        }

        // 19. Find Largest Word in a Sentence
        public static String largestWord(String str) {

            String[] words = str.split(" ");

            String largest = words[0];

            for (int i = 1; i < words.length; i++) {

                if (words[i].length() > largest.length()) {
                    largest = words[i];
                }
            }

            return largest;
        }

        // 20. String Compression
        public static String stringCompression(String str) {

            String result = "";
            int count = 1;

            for (int i = 0; i < str.length(); i++) {

                if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                } else {
                    result += str.charAt(i) + "" + count;
                    count = 1;
                }
            }

            return result;
        }

        public static void main(String[] args) {

            String input11a = "ABCD";
            String input11b = "CDAB";
            boolean result11 = isRotation(input11a, input11b);
            System.out.println(result11);

            String[] input12 = {"flower", "flow", "flight"};
            String result12 = longestCommonPrefix(input12);
            System.out.println(result12);

            String input13 = "Java Is Easy";
            String result13 = removeWhiteSpaces(input13);
            System.out.println(result13);

            String input14 = "Java is easy to learn";
            int result14 = countWords(input14);
            System.out.println(result14);

            String input15 = "banana";
            String result15 = characterFrequency(input15);
            System.out.println(result15);

            String input16 = "JaVa";
            String result16 = toggleCase(input16);
            System.out.println(result16);

            String input17 = "12345";
            boolean result17 = containsOnlyDigits(input17);
            System.out.println(result17);

            String input18 = "Ja@va#123";
            String result18 = removeSpecialCharacters(input18);
            System.out.println(result18);

            String input19 = "Java Spring Boot Microservices";
            String result19 = largestWord(input19);
            System.out.println(result19);

            String input20 = "aaabbcc";
            String result20 = stringCompression(input20);
            System.out.println(result20);
        }
    }

