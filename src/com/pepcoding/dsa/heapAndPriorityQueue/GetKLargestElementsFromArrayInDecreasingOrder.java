package com.pepcoding.dsa.heapAndPriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class GetKLargestElementsFromArrayInDecreasingOrder {

    private static int[] getKLargestElementsInDecreasingOrder(int[] input, int k) {

        int[] result = new int[k];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(Collections.reverseOrder());

        for (int i = 0; i < input.length; i++) {
            priorityQueue.add(input[i]);
        }
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            result[i++] = priorityQueue.remove();
            if (i == k) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] input = {5, 3, 6, 2, 4, 7, 9};
        int[] result = getKLargestElementsInDecreasingOrder(input, 4);
        for (int i : result) {
            System.out.println(i + " ");
        }
    }
}
