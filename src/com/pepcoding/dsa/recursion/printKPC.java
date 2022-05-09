package com.pepcoding.dsa.recursion;

public class printKPC {


    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    private static void printKPC(String question) {
        String answer = "";
        printKPC(question, answer);
    }

    private static void printKPC(String question, String answer) {

        //base case
/*        we will print the answer when the length of the question string is zero following bottom-up
                approach while traversing the recursion tree*/
        if (question.length() == 0) {
            System.out.print(answer + " ");
            return;
        }

        char ch = question.charAt(0);
        String remainingPartOfQuestion = question.substring(1);
        String code = codes[ch - '0'];

        //iterate through each character of the code and recursively call the function for the rest of question string
        for (int i = 0; i < code.length(); i++) {
            printKPC(remainingPartOfQuestion, answer + code.charAt(i));
        }
    }

    public static void main(String[] args) {

        printKPC("678");
    }
}
