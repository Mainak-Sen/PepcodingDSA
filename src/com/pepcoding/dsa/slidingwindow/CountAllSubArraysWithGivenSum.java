package com.pepcoding.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountAllSubArraysWithGivenSum {

    private static int returnCountOfAllSubArraysWithGivenSum(int[] input, int target) {

        Map<Integer, Integer> preSumCountMap = new HashMap<>();

        /* we know the key to solve this problem is SUM[i, j]. So if we know SUM[0, i - 1] and SUM[0, j],
        then we can easily get SUM[i, j]. To achieve this, we just need to go through the array,
        calculate the current sum and save number of all seen PreSum to a HashMap.
        Time complexity O(n), Space complexity O(n).*/

        /*to handle the corner case where the current sum counting from 0th index is itself equal to
         * target sum, or in other words preSum should be currentSum-targetSum i.e k-k=0
         * hence we put preSumCount with key zero as 1
         * */

        preSumCountMap.put(0, 1);
        int result = 0;
        int currentSum = 0;

        for (int i = 0; i < input.length; i++) {
            currentSum += input[i];
            if (preSumCountMap.containsKey(currentSum - target)) {
                result += preSumCountMap.get(currentSum - target);
            }
            preSumCountMap.put(currentSum, preSumCountMap.getOrDefault(currentSum, 0) + 1);
        }

        return result;
    }


    public static void main(String[] args) {

        //int[] input = {10, 2, -2, -20, 10};
        int[] input = {0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(returnCountOfAllSubArraysWithGivenSum(input, 0));

    }
}
