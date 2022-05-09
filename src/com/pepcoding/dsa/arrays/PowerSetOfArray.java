package com.pepcoding.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class PowerSetOfArray {

/*    Here we will use the concept of generating all binary numbers from 0 to 2^array.length-1 and use the bits to decide
            which number to print and which one to avoid*/

    private static List<List<Integer>> getPowerSet(int[] input) {

        int limit = (int) Math.pow(2, input.length);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < limit; i++) {
            int temp = i;
            List<Integer> current = new ArrayList<>();
            for (int j = input.length - 1; j >= 0; j--)//we need those many bits as the length of the array
            {
                int rem = temp % 2;
                temp = temp / 2;

                if (rem == 0) {
                    current.add(0, null);
                } else {
                    current.add(0, input[j]);
                }
            }
            list.add(current);
        }
        return list;
    }

    public static void main(String[] args) {

        System.out.println(getPowerSet(new int[]{1, 2, 3}));
    }
}
