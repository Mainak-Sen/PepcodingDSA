package com.pepcoding.dsa.heapAndPriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElementsInIncreasingOrder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //enter number of elements in first array
        int n1 = sc.nextInt();
        int[] a = new int[n1];
        //enter the numbers into array 1
        for (int i = 0; i < n1; i++) {
            a[i] = sc.nextInt();
        }

        //naive way
        /*PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++) {
            pq.add(a[i]);
        }
        int k = 3;
        for (int i = 0; i < a.length - k; i++) {
            pq.remove();//remove from front to have only the k biggest elements in increasing order
        }

        for (int i = 0; i < k; i++) {
            System.out.println(pq.peek());
            pq.remove();
        }*/
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int k = 3;
        //alternate way (efficient)
        for (int i = 0; i < a.length; i++) {
            if (i < k) //add the first 3 elements in priority queue
            {
                pq.add(a[i]);
            } else {
                //compare the current array element with the head of the queue
                //if greater then only remove the head and add the greater element
                //because we are concerned of the greatest elements only
                if (a[i] > pq.peek()) {
                    pq.remove();
                    pq.add(a[i]);
                }
            }
        }
        //print the elements of the priority queue
        while (pq.size() > 0) {
            System.out.println(pq.remove());
        }

        //same logic can be implemented to find the nth largest element of an array
    }
}
