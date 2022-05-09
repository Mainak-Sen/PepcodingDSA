package com.pepcoding.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

public class PythagoreanTriplet {

    private static boolean checkTriplet(int[] arr, int n) {
        // code here
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put((int) (Math.pow((int) arr[i], 2.0)), true);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (map.containsKey(arr[i] * arr[i] + arr[j] * arr[j])) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] arr = {3, 8, 5};
        System.out.println(checkTriplet(arr, arr.length));
        System.out.println(-2 % 2);

    }
}
