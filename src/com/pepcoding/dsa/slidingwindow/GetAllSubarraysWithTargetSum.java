package com.pepcoding.dsa.slidingwindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAllSubarraysWithTargetSum {

    /*private static void printAllSubArrayStartAndEndIndicesWithGivenSum(int[] input, int target) {

        //{1,3,2,1,4,1,3,2,1,1}
        int startIndex = 0;
        int runningSum = input[startIndex];

        if (runningSum == target) {
            System.out.println(startIndex + "," + startIndex);
        }

        for (int endIndex = 1; endIndex < input.length; endIndex++) {
            runningSum += input[endIndex];
            while (runningSum > target && startIndex < endIndex) {
                runningSum -= input[startIndex];
                startIndex++;
            }
            if (runningSum == target) {
                System.out.println(startIndex + "," + endIndex);
                continue;
            } else if (runningSum < target) {
                continue;
            }
        }


    }*/

    //optimized solution to handle negative numbers
    private static void printAllSubArrayStartAndEndIndicesWithGivenSum(int[] input, int target) {

        //{1,3,2,1,4,1,3,2,1,1}
        int currentSum = 0;
        int startIndex = 0;
        int endIndex = -1;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            currentSum += input[i];

            if (currentSum - target == 0)//we have got the required subarray
            {
                startIndex = 0;
                endIndex = i;
                System.out.println(startIndex + "," + endIndex);
            }

            //{10, 2, -2, -20, 10}
            if (map.containsKey(currentSum - target)) {
                startIndex = map.get(currentSum - target) + 1;
                endIndex = i;
                System.out.println(startIndex + "," + endIndex);
            }

            map.put(currentSum, i);
            //System.out.println(map);
        }

        System.out.println(map);

    }

    //{4,-8,3,-6,1,-2}      -4           4:0,-4:1,-1:2,-7:3,-6:4,

    public static void main(String[] args) {

        //int[] input = {8, 3, 2, 1, -4, 1, 3, 2, 1, 1, 8};
        //int[] input = {4, -8, 3, -6, 1, -2};
        int[] input = {10, 2, -4, -20, 10};
        printAllSubArrayStartAndEndIndicesWithGivenSum(input, -10);
    }

}
