package com.pepcoding.dsa.recursion;

public class PrintSpelling {

    // input 432 Output : Four Three Two
    //we will use recursion to solve the problem

    private static void printSpelling(int input) {

        String[] array = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        //base case
        if (input == 0) {
            return;
        }
        printSpelling(input / 10);
        System.out.print(array[input % 10] + " ");
    }

    public static void main(String[] args) {

        printSpelling(432);
    }
}
