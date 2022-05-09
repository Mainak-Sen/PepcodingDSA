package com.pepcoding.dsa.interviewQuestions;

import java.util.PriorityQueue;

public class GetTotalMinCostOfCombiningRopes {

    private static int getTotalMinCost(int[] input) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(input.length);
        for (int i : input) {
            pq.add(i);
        }

        int totalCost = 0;
        while (pq.size() > 1) {
            int ropePart1 = pq.remove();
            int ropePart2 = pq.remove();

            totalCost += ropePart1 + ropePart2;
            pq.add(ropePart1 + ropePart2);
        }

        return totalCost;

    }

    public static void main(String[] args) {

        int[] input = {5, 17, 100, 11};
        System.out.println(getTotalMinCost(input));


    }
}
