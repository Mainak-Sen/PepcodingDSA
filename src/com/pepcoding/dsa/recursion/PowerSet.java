package com.pepcoding.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {

    //use recursion to print power set of a given array

    //wrapper
    private static List<List<Integer>> getPowerSet(List<Integer> input) {
        List<Integer> current = new ArrayList<Integer>();
        return getPowerSet(input, current, 0);
    }

    private static List<List<Integer>> getPowerSet(List<Integer> input, List<Integer> current, int index) {

        List<List<Integer>> output = new ArrayList<>();
        //base case
        if (index >= input.size()) {
            output.add(new ArrayList<>(current));
            return output;
        }

        //case1. exclude the item at current index

        output.addAll(getPowerSet(input, new ArrayList<>(current), index + 1));

        //case2. include the item at current index
        current.add(input.get(index));
        output.addAll(getPowerSet(input, new ArrayList<>(current), index + 1));

        return output;
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3);
        System.out.println(getPowerSet(list));
    }
}
