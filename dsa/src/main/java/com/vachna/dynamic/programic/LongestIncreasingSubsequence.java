package com.vachna.dynamic.programic;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    //https://leetcode.com/problems/longest-increasing-subsequence/description/


    public LongestIncreasingSubsequence() {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return lis(0, nums, -1, dp);
    }

    private int lis(int i, int[] nums, int prev_index, int[][] dp) {
        if(i == nums.length) return 0;

        if(dp[i][prev_index + 1] != -1) return dp[i][prev_index+1];

        int take = 0, notTake = 0;

        notTake = lis(i+1, nums, prev_index, dp);

        if(prev_index == -1 || nums[prev_index] < nums[i]){
            take = 1 + lis(i+1, nums, i, dp);
        }

        return dp[i][prev_index + 1] = Math.max(take, notTake);

    }

    public static void main(String[] args) {
        new LongestIncreasingSubsequence();
    }
}
