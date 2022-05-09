package com.pepcoding.dsa.recursion;

public class NumberOfWaysToReachNStairs {

    private static int noOfWays(int stairs) {
        //condition given is a person can make 1,2 or at most 3 jumps to reach a particular stair

        //base cases
        if (stairs < 0) {
            return 0;
        } else if (stairs <= 1) {
            return 1;
        }
        return noOfWays(stairs - 1) + noOfWays(stairs - 2) + noOfWays(stairs - 3);
    }

    public static void main(String[] args) {

        System.out.println(noOfWays(4));
    }
}
