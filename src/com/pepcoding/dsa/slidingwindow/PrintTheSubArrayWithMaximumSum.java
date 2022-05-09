package com.pepcoding.dsa.slidingwindow;

public class PrintTheSubArrayWithMaximumSum {


    private static void printSubArrayWithMaxSum(int[] input) {

        //Kadane's algorithm

        int currentSum = input[0];
        int maxSumSoFar = input[0];
        int startIndex = 0;
        int endIndex = 0;
        int startIndexOfMaxSumSubArray = 0;
        int endIndexOfMaxSumSubArray = 0;
        //e
        //[-2,1,-3,4,-1,2,1,-5,4]

        for (int i = 1; i < input.length; i++) {
            currentSum += input[i];

            if (currentSum > input[i]) {
                endIndex = i;
            } else if (currentSum < input[i]) {
                currentSum = input[i];
                startIndex = i;
            }

            if (currentSum > maxSumSoFar) {
                maxSumSoFar = currentSum;
                startIndexOfMaxSumSubArray = startIndex;
                endIndexOfMaxSumSubArray = endIndex;
            }
        }

        //print the subarray with maxinum sum
        for (int i = startIndexOfMaxSumSubArray; i <= endIndexOfMaxSumSubArray; i++) {
            System.out.print(input[i] + " ");
        }

    }


    public static void main(String[] args) {

        int[] input = {5, 4, -1, 7, 8};
        printSubArrayWithMaxSum(input);
    }


}
