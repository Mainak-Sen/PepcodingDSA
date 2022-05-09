package com.pepcoding.dsa.heapAndPriorityQueue;

/*        1. You are given a list of lists, where each list is sorted.
        2. You are required to complete the body of mergeKSortedLists function.
        The function is expected to merge k sorted lists to create one sorted list.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MergeKSortedLists {

    public static class Pair implements Comparable<Pair> {

        int listIndex;
        int dataIndex;
        int data;

        Pair(int listIndex, int dataIndex, int data) {

            this.listIndex = listIndex;
            this.dataIndex = dataIndex;
            this.data = data;
        }

        @Override
        public int compareTo(Pair o) {
            return this.data - o.data;
        }
    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> rv = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        //add the first element of every individual list in lists into the priority queue
        //Pair class implements comparable hence the priority queue of pair will always have
        //smaller elements in the front as dictated by the above compareTo method
        for (int i = 0; i < lists.size(); i++) {
            Pair pair = new Pair(i, 0, lists.get(i).get(0));
            pq.add(pair);
        }

        while (pq.size() > 0) {
            Pair p = pq.remove();
            rv.add(p.data);//adding the data of the pair removed from priority queue

            //now increment the data-index of the pair that we removed last time
            p.dataIndex++;

            //check if the dataindex is in range of the list ,add it to priority queue
            if (p.dataIndex < lists.get(p.listIndex).size()) {
                p.data = lists.get(p.listIndex).get(p.dataIndex); //update the data of pair with data available in next dataIndex
                pq.add(p);
            }
        }
        return rv;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        System.out.println(mergeKSortedLists(lists));
    }
}
