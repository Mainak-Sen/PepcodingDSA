package com.pepcoding.dsa.recursion;

public class printAllPossibleParenthesis {

    private static void printAllParenthesis(int n) {
        int maxLength = 2 * n;
        String answer = "";
        int open = 0, close = 0; //initially both are zero
        printAllParenthesis(answer, open, close, n, maxLength);
    }

    private static void printAllParenthesis(String answer, int open, int close, int n, int maxLength) {

        //base case
        if (answer.length() == maxLength) {
            System.out.println(answer);
            return;
        } else {
            if (open < n) {
                printAllParenthesis(answer + "(", open + 1, close, n, maxLength);
            }
            if (open > close) {
                printAllParenthesis(answer + ")", open, close + 1, n, maxLength);
            }
        }
    }

    public static void main(String[] args) {
        printAllParenthesis(5);

    }
}
