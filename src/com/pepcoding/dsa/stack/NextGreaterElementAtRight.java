package com.pepcoding.dsa.stack;

import java.util.Stack;

public class NextGreaterElementAtRight {

    private static int[] getNextGreaterElementsAtRight(int[] input) {

        Stack<Integer> stack = new Stack<Integer>();
        //result array
        int[] result = new int[input.length];
        //the element at the extreme right would not have any element to its right ,so lets put -1 there from very beginning
        result[result.length - 1] = -1;
        stack.push(input[input.length - 1]);
        for (int i = input.length - 2; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() < input[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(input[i]); //no matter what always push the current element into the stack
        }
        return result;
    }

    public static void main(String[] args) {

        int[] result = getNextGreaterElementsAtRight(new int[]{2, 5, 9, 3, 1, 12, 6, 8, 7});
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
