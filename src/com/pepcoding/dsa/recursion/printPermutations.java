package com.pepcoding.dsa.recursion;

public class printPermutations {

    private static void printPermutations(String input) {
        String answer = ""; //first the answer is an empty string
        printPermutations(input, answer);
    }

    private static void printPermutations(String input, String answer) {

        //base case occurs when the question string/input string length is zero ,we need to print it
        if (input.length() == 0) {

            System.out.print(answer + " ");
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            String leftOfChosenChar = input.substring(0, i); //0 till i-1
            String rightIfChosenChar = input.substring(i + 1); //i+1 till end
            String remainingPart = leftOfChosenChar + rightIfChosenChar;
            printPermutations(remainingPart, answer + ch);
        }

    }

    public static void main(String[] args) {
        printPermutations("abc");


    }
}
