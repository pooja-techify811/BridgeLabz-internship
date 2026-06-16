package com.bridgelabs.arrays;

public class ArrayProblems2 {

    // 11. Find Intersection of Arrays
    public static int[] findIntersection(int[] arr1, int[] arr2) {

        int[] temp = new int[Math.min(arr1.length, arr2.length)];
        int size = 0;

        for (int i = 0; i < arr1.length; i++) {

            for (int j = 0; j < arr2.length; j++) {

                if (arr1[i] == arr2[j]) {

                    boolean alreadyExists = false;

                    for (int k = 0; k < size; k++) {
                        if (temp[k] == arr1[i]) {
                            alreadyExists = true;
                            break;
                        }
                    }

                    if (!alreadyExists) {
                        temp[size++] = arr1[i];
                    }
                }
            }
        }

        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    // 12. Kadane's Algorithm
    public static int maximumSubArraySum(int[] arr) {

        int maxSum = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (currentSum + arr[i] > arr[i]) {
                currentSum = currentSum + arr[i];
            } else {
                currentSum = arr[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }

    // 13. Find Smallest Element
    public static int findSmallest(int[] arr) {

        int smallest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }

        return smallest;
    }

    // 14. Find Second Smallest Element
    public static int findSecondSmallest(int[] arr) {

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] < secondSmallest && arr[i] != smallest) {
                secondSmallest = arr[i];
            }
        }

        return secondSmallest;
    }

    // 15. Check Array is Sorted
    public static boolean isSorted(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    // 16. Find Union of Two Arrays
    public static int[] findUnion(int[] arr1, int[] arr2) {

        int[] temp = new int[arr1.length + arr2.length];
        int size = 0;

        for (int i = 0; i < arr1.length; i++) {

            boolean exists = false;

            for (int j = 0; j < size; j++) {
                if (temp[j] == arr1[i]) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                temp[size++] = arr1[i];
            }
        }

        for (int i = 0; i < arr2.length; i++) {

            boolean exists = false;

            for (int j = 0; j < size; j++) {
                if (temp[j] == arr2[i]) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                temp[size++] = arr2[i];
            }
        }

        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    // 17. Find Majority Element
    public static int findMajorityElement(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > arr.length / 2) {
                return arr[i];
            }
        }

        return -1;
    }

    // 18. Find Leaders in Array
    public static String findLeaders(int[] arr) {

        String leaders = "";

        for (int i = 0; i < arr.length; i++) {

            boolean leader = true;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] > arr[i]) {
                    leader = false;
                    break;
                }
            }

            if (leader) {
                leaders += arr[i] + " ";
            }
        }

        return leaders.trim();
    }

    // 19. Maximum Consecutive Ones
    public static int maximumConsecutiveOnes(int[] arr) {

        int maxCount = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 1) {
                count++;

                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }

        return maxCount;
    }

    // 20. Stock Buy and Sell
    public static int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            int profit = prices[i] - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
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

        int[] input11a = {1, 2, 3, 4};
        int[] input11b = {3, 4, 5, 6};
        int[] result11 = findIntersection(input11a, input11b);
        printArray(result11);

        int[] input12 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result12 = maximumSubArraySum(input12);
        System.out.println(result12);

        int[] input13 = {10, 20, 5, 40};
        int result13 = findSmallest(input13);
        System.out.println(result13);

        int[] input14 = {10, 20, 5, 40};
        int result14 = findSecondSmallest(input14);
        System.out.println(result14);

        int[] input15 = {1, 2, 3, 4, 5};
        boolean result15 = isSorted(input15);
        System.out.println(result15);

        int[] input16a = {1, 2, 3};
        int[] input16b = {3, 4, 5};
        int[] result16 = findUnion(input16a, input16b);
        printArray(result16);

        int[] input17 = {2, 2, 1, 2, 3, 2, 2};
        int result17 = findMajorityElement(input17);
        System.out.println(result17);

        int[] input18 = {16, 17, 4, 3, 5, 2};
        String result18 = findLeaders(input18);
        System.out.println(result18);

        int[] input19 = {1, 1, 0, 1, 1, 1};
        int result19 = maximumConsecutiveOnes(input19);
        System.out.println(result19);

        int[] input20 = {7, 1, 5, 3, 6, 4};
        int result20 = maxProfit(input20);
        System.out.println(result20);
    }
}
