package com.pepcoding.dsa.dynamicProgramming;

import java.util.Arrays;

public class MinCoinChange {

    private static int fewestNumberOfCoins(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        Arrays.sort(coins);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                } else {
                    break;
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        System.out.println(fewestNumberOfCoins(coins, 11));
    }
}
