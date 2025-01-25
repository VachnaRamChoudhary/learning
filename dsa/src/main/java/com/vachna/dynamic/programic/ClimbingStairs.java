package com.vachna.dynamic.programic;

public class ClimbingStairs {

    /**
     *  You are climbing a staircase. It takes n steps to reach the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * https://leetcode.com/problems/climbing-stairs/submissions/1517527062/
     */
    public ClimbingStairs(){
        System.out.println(climbStairs(6));
    }

    public int climbStairs(int n) {
//        if(n == 0) return 1;
//        if(n < 0) return 0;
//
//        return climbStairs(n-1) + climbStairs(n-2);
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        new ClimbingStairs();
    }
}
