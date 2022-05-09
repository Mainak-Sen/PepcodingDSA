package com.pepcoding.dsa.interviewQuestions;

import java.util.HashMap;
import java.util.Map;


public class CheckIf2ndArraySubsequenceOf1st {

    private static boolean checkIf2ndArraySubsequenceOf1st(int[] input1, int[] input2) {

        //map to store integers and their indices
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input1.length; i++) {
            map.put(input1[i], i);
        }

        int matchedIndexInFirstArray = -1;
        for (int i = 0; i < input2.length; i++) {
            if (map.containsKey(input2[i])) {
                int temp = matchedIndexInFirstArray;
                matchedIndexInFirstArray = map.get(input2[i]);
                if (matchedIndexInFirstArray > temp) {
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return matchedIndexInFirstArray == -1 && input2.length != 0 ? false : true;
    }

    public static void main(String[] args) {

        //{1,3,4,7,6},{1,6}
        int[] firstArrray = {1, 3, 4, 7, 6};
        int[] secondArrray = {7, 6};

        System.out.println(checkIf2ndArraySubsequenceOf1st(firstArrray, secondArrray));
    }
}
