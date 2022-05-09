package com.pepcoding.dsa.sorting;

import java.util.Scanner;

public class Sort012 {

/*    Maintain three indexes. Initialize first index i as 0 and second index j as 0, and third index k as n-1.
    Run the loop until i becomes equal to k
    If arr[i] = 1, then increment i (i++).
    Else if arr[i] = 0,
    Swap values at arr[i] and arr[j]
    Increment both i and j (i++, j++).
    Else (arr[i] = 2),
    Swap values at arr[i] and arr[k]
    Decrement k only (k--).*/

    public static void sort012(int[] arr) {

        //3 pointer technique
        int i = 0;
        int j = 0;
        int k = arr.length - 1;

        while (i <= k) {
            if (arr[i] == 0) {
                swap(arr, i, j);
                i++;
                j++;

            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, k);
                k--;
            }
        }


    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        //System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        sort012(arr);
        print(arr);
    }
}
