package com.vachna.dynamic.programic;

import com.vachna.utill.HelperUtil;

public class CoinChange {

    public CoinChange() {
        int[] coins = {2};
        System.out.println(coinChange(coins, 3));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for(int a = 1; a <= amount; a++){
            int val = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (a - coin >= 0) {
                    val = Math.min(dp[a - coin], val);
                }
            }
            dp[a] = val == Integer.MAX_VALUE? Integer.MAX_VALUE : val + 1;
        }
        HelperUtil.print(dp);
        return dp[amount] == Integer.MAX_VALUE? -1 : dp[amount];

    }

    public static void main(String[] args) {
        new CoinChange();
    }

}
