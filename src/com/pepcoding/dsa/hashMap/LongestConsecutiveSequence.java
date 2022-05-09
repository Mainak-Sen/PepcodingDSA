package com.pepcoding.dsa.hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestConsecutiveSequence {

/*    1. You are given a number n, representing the size of array a.
    2. You are given n numbers, representing elements of array a.
    3. You are required to print the longest sequence of consecutive elements in the array (ignoring duplicates).

    Note -> In case there are two sequences of equal length (and they are also the longest),
    then print the one for which the starting point of which occurs first in the array.*/

    private static void printLongestConsecutiveSequence(int[] input, int len) {

        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        //initially map all the values in the array to true in the hashmap
        for (int val : input) {
            map.put(val, true);
        }

        for (int val : input) {
            if (map.containsKey(val - 1)) {
                //this means it cannot be start of a sequence
                map.put(val, false);
            }
        }
        //after the above loop,we will have only those elements as true in the map from which
        //a sequence can be started
        int minValOfSequence = 0;
        int maxLen = 0;

        for (int val : input) {
            if (map.get(val) == true) {
                int curLen = 1;
                while (map.containsKey(val + curLen)) {
                    curLen++;
                }
                if (curLen > maxLen) {
                    maxLen = curLen;
                    minValOfSequence = val;
                }
            }
        }

        //print the maxSequence
        for (int i = 0; i < maxLen; i++) {
            System.out.println((minValOfSequence + i));
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        //enter number of elements in first array
        int n1 = sc.nextInt();
        int[] a = new int[n1];
        //enter the numbers into array 1
        for (int i = 0; i < n1; i++) {
            a[i] = sc.nextInt();
        }
        printLongestConsecutiveSequence(a, n1);

        //int[] input = {12, 5, 1, 2, 10, 2, 13, 7, 11, 8, 9, 11, 8, 9, 5, 6, 11};
        /*int[] input = {10, 5, 9, 1, 11, 8, 6, 15, 3, 12, 2};
        int n = input.length;
        printLongestConsecutiveSequence(input, n);*/

    }

}
