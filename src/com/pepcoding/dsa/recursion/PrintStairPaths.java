package com.pepcoding.dsa.recursion;

public class PrintStairPaths {

    /*As mentioned in our problem you are given a number n representing the number of stairs in a staircase.
     You are standing at the bottom of the staircase. And you are allowed to climb 1 step, 2 steps or 3 steps in one move.*/

    /*reaching from bottom to up or reaching the 0th step from nth step ,the number of paths remain still the same */
    private static void printStairPaths(int n) {
        printStairPaths(n, "");
    }

    private static void printStairPaths(int n, String pathSoFar) {

        //base case is reached when we reach 0th stair or a negative stair
        if (n <= 0) {
            if (n == 0) {
                System.out.print(pathSoFar+" ");
            }
            return;
        }

        printStairPaths(n - 1, 1 + pathSoFar);
        printStairPaths(n - 2, 2 + pathSoFar);
        printStairPaths(n - 3, 3 + pathSoFar);
    }


    public static void main(String[] args) {

        printStairPaths(4);
    }
}
