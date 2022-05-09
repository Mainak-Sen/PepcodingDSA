package com.pepcoding.dsa.heapAndPriorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SortKSortedArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //enter number of elements in first array
        int n1 = sc.nextInt();
        int[] a = new int[n1];
        //enter the numbers into array 1
        for (int i = 0; i < n1; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        //sample array : {2,3,1,4,6,5,9,8,7,10}

        //we will use priority queue to filter out the smallest from  k+1 elements
        //the priority queue will hold at max k+1 elements

        //adding k+1 elements in the priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            pq.add(a[i]);
        }

        for (int i = k + 1; i < a.length; i++) {
            System.out.println(pq.remove());
            pq.add(a[i]);
        }

        //when we surpass end of the array ,we cannot add any more elements to funnel
        //hence we print the remainder of the funnel which is already sorted
        while (pq.size() > 0) {
            System.out.println(pq.remove());
        }

    }
}
