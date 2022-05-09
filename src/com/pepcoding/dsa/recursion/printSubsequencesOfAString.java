package com.pepcoding.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class printSubsequencesOfAString {

    //wrapper
    private static List<String> getSubSequences(String input) {
        String current = "";
        return getSubSequences(input, current, 0);
    }

    private static List<String> getSubSequences(String input, String current, int index) {

        List<String> output = new ArrayList<>();
        //base case
        if (index >= input.length()) {
            output.add(current);
            return output;
        }

        //exclude item at index
        output.addAll(getSubSequences(input, current, index + 1));

        //include item at index
        output.addAll(getSubSequences(input, current + input.charAt(index), index + 1));

        return output;
    }

    public static void main(String[] args) {

        System.out.println(getSubSequences("ABC"));

    }
}
