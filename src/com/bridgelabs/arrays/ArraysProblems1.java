package com.bridgelabs.arrays;



public class ArraysProblems1 {

    // 1. Find Largest Element
    public static int findLargest(int[] arr) {

        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        return largest;
    }

    // 2. Find Second Largest Element
    public static int findSecondLargest(int[] arr) {

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }

    // 3. Reverse an Array
    public static int[] reverseArray(int[] arr) {

        int[] reversed = new int[arr.length];

        int index = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            reversed[index++] = arr[i];
        }

        return reversed;
    }

    // 4. Find Missing Number
    public static int findMissingNumber(int[] arr) {

        int n = arr.length + 1;

        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int i = 0; i < arr.length; i++) {
            actualSum += arr[i];
        }

        return expectedSum - actualSum;
    }

    // 5. Find Duplicate Elements
    public static String findDuplicates(int[] arr) {

        String duplicates = "";

        for (int i = 0; i < arr.length; i++) {

            boolean alreadyPrinted = false;

            for (int k = 0; k < i; k++) {
                if (arr[i] == arr[k]) {
                    alreadyPrinted = true;
                    break;
                }
            }

            if (alreadyPrinted) {
                continue;
            }

            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > 1) {
                duplicates += arr[i] + " ";
            }
        }

        return duplicates.trim();
    }

    // 6. Remove Duplicates
    public static int[] removeDuplicates(int[] arr) {

        int[] temp = new int[arr.length];
        int size = 0;

        for (int i = 0; i < arr.length; i++) {

            boolean found = false;

            for (int j = 0; j < size; j++) {
                if (arr[i] == temp[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                temp[size++] = arr[i];
            }
        }

        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    // 7. Move Zeros To End
    public static int[] moveZerosToEnd(int[] arr) {

        int[] result = new int[arr.length];

        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                result[index++] = arr[i];
            }
        }

        return result;
    }

    // 8. Rotate Array Left by K
    public static int[] rotateLeft(int[] arr, int k) {

        int[] result = new int[arr.length];

        int index = 0;

        for (int i = k; i < arr.length; i++) {
            result[index++] = arr[i];
        }

        for (int i = 0; i < k; i++) {
            result[index++] = arr[i];
        }

        return result;
    }

    // 9. Find Pair With Given Sum
    public static String findPairWithSum(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] + arr[j] == target) {
                    return arr[i] + " " + arr[j];
                }
            }
        }

        return "No Pair Found";
    }

    // 10. Merge Two Arrays
    public static int[] mergeArrays(int[] arr1, int[] arr2) {

        int[] merged = new int[arr1.length + arr2.length];

        int index = 0;

        for (int i = 0; i < arr1.length; i++) {
            merged[index++] = arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            merged[index++] = arr2[i];
        }

        return merged;
    }

    // Utility Method
    public static void printArray(int[] arr) {

        System.out.print("[");

        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i]);

            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }

        System.out.println("]");
    }

    public static void main(String[] args) {

        int[] input1 = {10, 20, 5, 40};
        int result1 = findLargest(input1);
        System.out.println(result1);

        int[] input2 = {10, 20, 5, 40};
        int result2 = findSecondLargest(input2);
        System.out.println(result2);

        int[] input3 = {1, 2, 3, 4, 5};
        int[] result3 = reverseArray(input3);
        printArray(result3);

        int[] input4 = {1, 2, 4, 5};
        int result4 = findMissingNumber(input4);
        System.out.println(result4);

        int[] input5 = {1, 2, 3, 2, 4, 1};
        String result5 = findDuplicates(input5);
        System.out.println(result5);

        int[] input6 = {1, 2, 2, 3, 3, 4};
        int[] result6 = removeDuplicates(input6);
        printArray(result6);

        int[] input7 = {0, 1, 0, 3, 12};
        int[] result7 = moveZerosToEnd(input7);
        printArray(result7);

        int[] input8 = {1, 2, 3, 4, 5};
        int k = 2;
        int[] result8 = rotateLeft(input8, k);
        printArray(result8);

        int[] input9 = {2, 7, 11, 15};
        int target = 9;
        String result9 = findPairWithSum(input9, target);
        System.out.println(result9);

        int[] input10a = {1, 2, 3};
        int[] input10b = {4, 5, 6};
        int[] result10 = mergeArrays(input10a, input10b);
        printArray(result10);
    }
}