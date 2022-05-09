package com.pepcoding.dsa.dynamicProgramming;

import java.util.Arrays;

public class CoinChangeCombinations {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];//initially all elements in an array in java is initialized to zero
        dp[0] = 1; //number of combinations to make 0 amount is 1
        for (int coin : coins) {
            for (int i = 1; i < dp.length; i++) {

                if (i >= coin) {

                    dp[i] += dp[i - coin];

                }
            }

        }
        return dp[amount];
    }


    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 11));
    }
}
