package com.pepcoding.dsa.recursion;

public class PrintEncodings {

    private static void printEncodings(String question) {

        printEncodings(question, "");
    }

    private static void printEncodings(String question, String answer) {

        //base case
        if (question.length() == 0) {
            System.out.println(answer + " ");
            return;
        } else if (question.length() == 1) {
            char ch = question.charAt(0);
            if (ch == '0') {
                return;
            } else {
                String code = (char) ('a' + (ch - '0') - 1) + "";
                System.out.println(answer + code);
            }
        } else { //case when length is 2 or more

            //taking one character only
            char ch1 = question.charAt(0);
            String remainingQuestion1 = question.substring(1);
            if (ch1 == '0') {
                return;
            } else {
                String code = (char) ('a' + (ch1 - '0') - 1) + "";
                printEncodings(remainingQuestion1, answer + code);
            }

            //taking 2 characters and checking if its less than or equal to 26
            String ch12 = question.substring(0, 2);
            int ch12Int = Integer.parseInt(ch12);
            String remainingQuestion12 = question.substring(2);

            if (ch12Int <= 26) {
                char code = (char) ('a' + ch12Int - 1);
                printEncodings(remainingQuestion12, answer + code);
            }

        }
    }

    public static void main(String[] args) {

        printEncodings("126203");
    }
}
