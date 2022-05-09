package com.pepcoding.dsa.recursion;

public class PrintSubsequences2 {

    private static void printSubsequences(String input) {

        String ans = "";
        printSubsequences(input, ans);
    }

    private static void printSubsequences(String input, String ans) {
        //base case
        if (input.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        char ch = input.charAt(0);
        String remainingPart = input.substring(1);

        //now two recursive calls
        //1. without including ch
        printSubsequences(remainingPart, ans + "");
        //2.including character ch
        printSubsequences(remainingPart, ans + ch);
    }

    public static void main(String[] args) {

        printSubsequences("abc");
    }
}
