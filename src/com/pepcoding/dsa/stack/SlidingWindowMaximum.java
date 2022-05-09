package com.pepcoding.dsa.stack;

/*Consider an array = {7, 5, 2, 6, 4, 3, 8, 1, 5} and window size k = 4. Then the maximum of each window will be:
        Ans = [7, 6, 6, 8, 8, 8].*/

import java.util.Stack;

public class SlidingWindowMaximum {

    private static void getSlidingWindowMaximum(int[] input, int window) {

        //strategy first is to find the next greater element to the right for every element in the array
        Stack<Integer> stack = new Stack<>();
        stack.push(input.length - 1);
        int[] nextGreaterElements = new int[input.length];
        nextGreaterElements[input.length - 1] = input.length;

        for (int i = input.length - 2; i >= 0; i--) {
            while (stack.size() > 0 && input[i] >= input[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nextGreaterElements[i] = input.length;
            } else {
                nextGreaterElements[i] = stack.peek();
            }
            stack.push(i);
        }

        int j = 0;
        for (int i = 0; i <= input.length - window; i++) {

            if (j < i)//when j gets behind i
            {
                j = i;
            }
            while (nextGreaterElements[j] < i + window) {
                j = nextGreaterElements[j];
            }

            System.out.print(input[j] + " ");

        }
    }

    public static void main(String[] args) {

        int[] input = {7, 5, 2, 6, 4, 3, 8, 1, 5};
        getSlidingWindowMaximum(input, 5);
    }
}
