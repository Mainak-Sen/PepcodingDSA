package com.pepcoding.dsa.interviewQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesisChecker {

    private static Map<Character, Character> map = new HashMap<>();

    private static int checkIfValidParenthesis(String input) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '}' || input.charAt(i) == ')' || input.charAt(i) == ']') {
                char top = stack.isEmpty() ? '*' : stack.pop();
                if (top == map.get(input.charAt(i))) {
                    continue;
                } else {
                    return 0;
                }
            } else {
                stack.push(input.charAt(i));
            }
        }

        return stack.isEmpty() ? 1 : 0;

    }

    public static void main(String[] args) {

        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        System.out.println(checkIfValidParenthesis("()"));


    }

}
