package com.pepcoding.dsa.stack;

import java.util.Stack;

public class InfixEvaluation {

    public static void evaluateExpression(String input) {

        //we will have 2 stacks ,one for operators and the other for operands
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();


        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(') {
                operators.push(ch);
            } else if (Character.isDigit(ch)) {
                operands.push(ch - '0');
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    char operator = operators.pop();
                    int value2 = operands.pop();
                    int value1 = operands.pop();
                    operands.push(operation(value1, value2, operator));
                }
                operators.pop();//pop the opening bracket
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                //wait for higher precedence operations to be done first
                while (!operators.isEmpty() && operators.peek() != '('
                        && getPrecedence(ch) <= getPrecedence(operators.peek())) {
                    char operator = operators.pop();
                    int value2 = operands.pop();
                    int value1 = operands.pop();
                    operands.push(operation(value1, value2, operator));
                }
                //finally, push the current operator into operator stack
                operators.push(ch);
            }
        }
        //finally, we have to check if there are any remaining operators in stack which remains to be executed
        while (!operators.isEmpty()) {
            char operator = operators.pop();
            int value2 = operands.pop();
            int value1 = operands.pop();
            operands.push(operation(value1, value2, operator));
        }
        System.out.println(operands.peek());
    }

    private static int getPrecedence(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else {
            return 2;
        }
    }

    public static int operation(int value1, int value2, char operator) {

        if (operator == '+') {
            return value1 + value2;
        } else if (operator == '-') {
            return value1 - value2;
        } else if (operator == '*') {
            return value1 * value2;
        } else {
            //division
            return value1 / value2;
        }
    }

    public static void main(String[] args) {

        evaluateExpression("2+(5-3*6/2)");
    }
}
