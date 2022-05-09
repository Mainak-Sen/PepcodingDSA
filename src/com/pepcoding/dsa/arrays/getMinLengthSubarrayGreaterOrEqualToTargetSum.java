package com.pepcoding.dsa.arrays;

public class getMinLengthSubarrayGreaterOrEqualToTargetSum {


    private static int getMinLengthSubarray(int[] input, int target) {


        //[2, 1, 5, 2, 3, 2]

        int windowStart = 0;
        int currentLength = 1;
        int minLength = Integer.MAX_VALUE;
        int runningSum = input[0];

        if (input[0] == target) {
            return 1;
        }

        for (int i = 1; i < input.length; i++) {
            runningSum += input[i];
            currentLength++;

            while (runningSum - input[windowStart] >= target) {
                windowStart++;
                currentLength = i - windowStart + 1;
                runningSum -= input[windowStart];
                if (currentLength < minLength) {
                    minLength = currentLength;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;

    }

    public static void main(String[] args) {

        int[] input = {2, 1, 4, 1};
        System.out.println(getMinLengthSubarray(input, 7));
    }


}
