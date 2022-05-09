package com.pepcoding.dsa.stack;

import java.util.Stack;

public class CelebrityProblem {

    private static boolean checkIfCelebrityExists(int[][] input) {

        int n = input.length;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        //get the potential celebrity candidate
        //there are two conditions
        // 1. input[i][j] = 1 which indicates i knows j ,so i cannot be a celebrity
        // 2. input[i][j] = 0 which indicates i doesn't know j ,so j cannot be a celebrity

        while (stack.size() > 1) {

            int i = stack.pop();
            int j = stack.pop();

            if (input[i][j] == 1) {
                stack.push(j); //i eliminated as i knows j so i is not a potential celebrity candidate
            } else if (input[i][j] == 0) {
                stack.push(i); // j eliminated as i does not know j so j is not a potential celebrity candidate
            }
        }

        //here stack size reduces to 1 giving us the only  potential celebrity candidate
        int potential_candidate = stack.pop();

        //check if all row elements are 0 and column elements are 1 for the potential index aka candidate
        //we need not check  for diagonal elements as a person if he knows himself is not being considered here
        for (int i = 0; i < n; i++) {
            if (i != potential_candidate) {
                if (input[potential_candidate][i] == 1 || input[i][potential_candidate] == 0) {
                    //above violates condition of being celebrity
                    return false;
                }
            }
        }
        //if we end up here ,celebrity is found we should return true
        System.out.println("The celebrity is found: " + potential_candidate);
        return true;
    }

    public static void main(String[] args) {

        int[][] input = {{0, 1, 0, 0},
                         {1, 0, 1, 1},
                         {1, 1, 0, 1},
                         {1, 1, 1, 0}};//positive

        System.out.println(checkIfCelebrityExists(input));

    }
}
