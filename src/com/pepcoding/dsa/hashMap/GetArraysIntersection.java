package com.pepcoding.dsa.hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GetArraysIntersection {

/*1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. You are required to print all elements of a2 which are also present in a1 (in order of their occurence in a2).
    Make sure to not print duplicates (a2 may have same value present many times).*/

    private static void printCommonElements(int[] a1, int[] a2, int n1, int n2) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int value : a1) {
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }

        for (int value : a2) {
            if (map.containsKey(value) && map.get(value) > 0) {
                System.out.println(value);
                map.put(value, map.get(value) - 1);//decrement the count in map
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        //enter number of elements in first array
        int n1 = sc.nextInt();
        int[] a1 = new int[n1];
        //enter the numbers into array 1
        for (int i = 0; i < n1; i++) {
            a1[i] = sc.nextInt();
        }

        //enter number of elements in second  array
        int n2 = sc.nextInt();
        int[] a2 = new int[n2];
        //enter the numbers into array 2
        for (int i = 0; i < n2; i++) {
            a2[i] = sc.nextInt();
        }
        printCommonElements(a1, a2, n1, n2);

    }
}
