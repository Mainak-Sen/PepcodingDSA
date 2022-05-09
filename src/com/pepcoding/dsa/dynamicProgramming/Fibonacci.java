package com.pepcoding.dsa.dynamicProgramming;

public class Fibonacci {

    private static int getNthFibonacci(int n) {

        int[] memo = new int[n + 1];
        return getNthFibonacci(n, memo);

    }

    private static int getNthFibonacci(int n, int[] memo) {

        if (n == 0 || n == 1) {
            return n;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        int fibN = getNthFibonacci(n - 1, memo) + getNthFibonacci(n - 2, memo);
        memo[n] = fibN;

        return fibN;
    }

    public static void main(String[] args) {

        System.out.println(getNthFibonacci(6));
    }
}
