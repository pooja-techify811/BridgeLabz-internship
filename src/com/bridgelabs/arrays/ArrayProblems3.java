package com.bridgelabs.arrays;



public class ArrayProblems3 {

    // 21. Product of Array Except Self
    public static int[] productExceptSelf(int[] arr) {

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            int product = 1;

            for (int j = 0; j < arr.length; j++) {

                if (i != j) {
                    product *= arr[j];
                }
            }

            result[i] = product;
        }

        return result;
    }

    // 22. Find Longest Consecutive Sequence
    public static int longestConsecutiveSequence(int[] arr) {

        // Simple Bubble Sort
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        int longest = 1;
        int current = 1;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == arr[i - 1] + 1) {

                current++;

                if (current > longest) {
                    longest = current;
                }

            } else if (arr[i] != arr[i - 1]) {

                current = 1;
            }
        }

        return longest;
    }

    // 23. Two Sum
    public static int[] twoSum(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    // 24. Three Sum
    public static void threeSum(int[] arr) {

        // Bubble Sort
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length - 2; i++) {

            for (int j = i + 1; j < arr.length - 1; j++) {

                for (int k = j + 1; k < arr.length; k++) {

                    if (arr[i] + arr[j] + arr[k] == 0) {

                        System.out.println(
                                "[" + arr[i] + "," + arr[j] + "," + arr[k] + "]"
                        );
                    }
                }
            }
        }
    }

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

        int[] input21 = {1, 2, 3, 4};
        int[] result21 = productExceptSelf(input21);
        printArray(result21);

        int[] input22 = {100, 4, 200, 1, 3, 2};
        int result22 = longestConsecutiveSequence(input22);
        System.out.println(result22);

        int[] input23 = {2, 7, 11, 15};
        int target23 = 9;
        int[] result23 = twoSum(input23, target23);
        printArray(result23);

        int[] input24 = {-1, 0, 1, 2, -1, -4};
        threeSum(input24);
    }
}
