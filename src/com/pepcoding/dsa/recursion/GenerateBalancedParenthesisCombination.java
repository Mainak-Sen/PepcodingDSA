package com.pepcoding.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateBalancedParenthesisCombination {

    private static List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        String current = "";
        int max = n;
        int open = 0;
        int close = 0;
        return generateParenthesis(result, current, open, close, max);
    }

    private static List<String> generateParenthesis(List<String> result, String current, int open, int close, int max) {


        //base case
        if (current.length() == 2 * max) {
            result.add(current);
        } else {

            if (open < max) {
                generateParenthesis(result, current + "(", open + 1, close, max);
            }

            if (close < open) {
                //append a close bracket
                generateParenthesis(result, current + ")", open, close + 1, max);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(generateParenthesis(4));
    }
}
