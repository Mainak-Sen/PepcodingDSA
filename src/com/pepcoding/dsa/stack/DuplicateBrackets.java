package com.pepcoding.dsa.stack;

import java.util.Stack;

public class DuplicateBrackets {

    //the condition given for this problem is that the input expression is balanced.
    private static boolean checkIfRedundantBracketsPresent(String input) {

        Stack<Character> stack = new Stack<Character>();

        for (char c : input.toCharArray()) {
            if (c != ')') {
                stack.push(c);
            } else {
                char top = stack.pop();
                if (top == '(') {
                    //entering here signifies there is not a single character at least within the 2 brackets
                    //which implicates that the bracket is needless
                    return true;
                } else {
                    //when there is at least one element between the brackets
                    //pop all elements from stack until we get to see an opening bracket
                    while (stack.peek() != '(') {
                        stack.pop();
                    }
                    //then pop out the opening bracket at the top
                    stack.pop();
                }
            }
        }

        //if it reaches here that means there are no duplicate brackets
        return false;

    }

    public static void main(String[] args) {

        System.out.println(checkIfRedundantBracketsPresent("(a + b) + ((c + d))"));
    }
}
