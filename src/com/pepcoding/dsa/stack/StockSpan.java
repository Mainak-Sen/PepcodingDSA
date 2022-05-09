package com.pepcoding.dsa.stack;

/*        1. You are given a number n, representing the size of array a.
        2. You are given n numbers, representing the prices of a share on n days.
        3. You are required to find the stock span for n days.
        4. Stock span is defined as the number of days passed between the current day
        and the first day before today when price was higher than today.

        e.g.
        for the array [2 5 9 3 1 12 6 8 7]
        span for 2 is 1
        span for 5 is 2
        span for 9 is 3
        span for 3 is 1
        span for 1 is 1
        span for 12 is 6
        span for 6 is 1
        span for 8 is 2
        span for 7 is 1*/

import java.util.Stack;

public class StockSpan {

    public static int[] solve(int[] arr) {

        //taking a stack to store the indices of the elements in the array
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[arr.length];
        //the first value would always have a span of 1
        result[0] = 1;
        //push the first element index in stack
        stack.push(0);

        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            //after popping if stack turns out to be empty
            if (stack.isEmpty()) {
                result[i] = i + 1;//0 based indexing ,hence adding a 1
            } else {
                result[i] = i - stack.peek();
            }
            stack.push(i); //push the current index into the stack
        }
        return result;
    }

    public static void main(String[] args) {

        int[] result = solve(new int[]{2, 5, 9, 3, 1, 12, 6, 8, 7});
        for (int i : result) {
            System.out.print(i + " ");
        }

    }


}
