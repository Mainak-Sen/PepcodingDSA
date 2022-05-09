package com.pepcoding.dsa.dynamicProgramming;

public class LongestIncreasingSubsequence {

    private static int getLisLength(int[] nums) {

        int[] dp = new int[nums.length];
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int j_max = 0;
            dp[i] = 1; //initially LIS length is 1 only considering the element in place
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] > j_max) {
                        j_max = dp[j];
                    }
                }
            }
            //update the dp[i] after comparing with  LIS of all the left elements
            dp[i] = j_max + 1;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(getLisLength(nums));
    }
}
