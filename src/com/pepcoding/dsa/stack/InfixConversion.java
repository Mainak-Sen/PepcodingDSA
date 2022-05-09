package com.pepcoding.dsa.stack;

import java.util.Stack;

public class InfixConversion {

    /*
    In this problem you are provided with an infix expression
    and you are required to convert it to postfix and prefix and print both these expressions.

    What are postfix and prefix expressions?
    Postfix Expression:
    When operator is post fixed to operands, i.e. operator is placed after operands.
    For example: Infix expression: x*y
    Postfix expression: xy*

    Prefix Expression
    When operator is prefixed to operands, i.e. operator is placed before operands.
    For example: Infix expression: x*y
    Prefix expression: *xy
    Sample Input: 2 * ( 6 - 4 + 8 ) / 3
    Sample Output: 2 6 4 - 8 + * 3 / / * 2 + - 6 4 8 3
    */

    private static void printPrefixAndPostfixEquivalentOfGivenInfixExpression(String input) {

        Stack<String> postStack = new Stack<>();
        Stack<String> preStack = new Stack<>();

        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '(') {
                operators.push(currentChar);
            } else if ((currentChar >= 'a' && currentChar <= 'z')
                    || (currentChar >= 'A' && currentChar <= 'Z')
                    || Character.isDigit(currentChar)) {
                preStack.push(currentChar + "");
                postStack.push(currentChar + "");
            } else if (currentChar == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {

                    //prefix
                    char operator = operators.pop();
                    String preValue2 = preStack.pop();
                    String preValue1 = preStack.pop();
                    preStack.push(operator + preValue1 + preValue2); //operator comes first in case of prefix expression

                    //postfix
                    String postValue2 = postStack.pop();
                    String postValue1 = postStack.pop();
                    postStack.push(postValue1 + postValue2 + operator); //operator comes first in case of prefix expression
                }
                //pop the opening bracket
                operators.pop();
            } else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {

                //wait for higher or equal precedence operations to happen first
                while (!operators.isEmpty() && operators.peek() != '('
                        && getPrecedence(currentChar) <= getPrecedence(operators.peek())) {

                    //prefix
                    char operator = operators.pop();
                    String preValue2 = preStack.pop();
                    String preValue1 = preStack.pop();
                    preStack.push(operator + preValue1 + preValue2); //operator comes first in case of prefix expression

                    //postfix
                    String postValue2 = postStack.pop();
                    String postValue1 = postStack.pop();
                    postStack.push(postValue1 + postValue2 + operator); //operator comes first in case of prefix expression
                }
                //push the current operator to operators stack after we are done with higher or equal precedence operations
                operators.push(currentChar);
            }

        }

        //here comes the condition when still operations are there to be done
        while (!operators.isEmpty()) {
            char operator = operators.pop();
            String preValue2 = preStack.pop();
            String preValue1 = preStack.pop();
            preStack.push(operator + preValue1 + preValue2); //operator comes first in case of prefix expression

            //postfix
            String postValue2 = postStack.pop();
            String postValue1 = postStack.pop();
            postStack.push(postValue1 + postValue2 + operator); //operator comes first in case of prefix expression
        }

        //print the prefix and postfix expressions
        System.out.println("Prefix expression of the given infix expression is " + preStack.peek());
        System.out.println("Postfix expression of the given infix expression is " + postStack.peek());
    }

    private static int getPrecedence(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else {
            return 2;
        }
    }

    public static void main(String[] args) {

        printPrefixAndPostfixEquivalentOfGivenInfixExpression("2*(6-4+8)/3");
    }

}
