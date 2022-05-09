package com.pepcoding.dsa.recursion;

public class SortedOrUnsorted {

    /*Here we will use recursion to guage whether the given input array is sorted or unsorted*/

    //wrapper
    private static boolean sortedOrUnsorted(int[] input) {
        return sortedOrUnsorted(input, 1);
    }

    private static boolean sortedOrUnsorted(int[] input, int index) {
        //write base cases

        //1.
        if (index >= input.length) {
            return true;
        }
        //2.
        if (input[index] < input[index - 1]) {
            return false;
        }

        //recursive call
        return sortedOrUnsorted(input, index + 1);
    }

    public static void main(String[] args) {

        int[] sorted = {1, 4, 6, 8, 9};
        int[] unsorted = {7, 1, 0, 6, 5, 3};
        System.out.println(sortedOrUnsorted(unsorted));
    }
}
