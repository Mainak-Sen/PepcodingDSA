package com.pepcoding.dsa.sorting;

public class FindPivotOfRotatedArray {

    private static int findPivot(int[] input) {
        int lo = 0;
        int hi = input.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (input[mid] < input[hi]) {
                hi = mid;//pivot should lie
            } else {
                lo = mid + 1;
            }
        }
        return input[lo];
    }

    public static void main(String[] args) {

        int[] input = {30, 40, 50, 10, 15, 20};
        System.out.println(findPivot(input));
    }
}
