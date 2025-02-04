package com.vachna.dynamic.programic;

public class HouseRobber {

    /**
     *You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
     *
     * Given an integer array nums representing the amount of money of each house,
     * return the maximum amount of money you can rob tonight without alerting the police.
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     * Total amount you can rob = 1 + 3 = 4.
     * Example 2:
     *
     * Input: nums = [2,7,9,3,1]
     * Output: 12
     * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
     * Total amount you can rob = 2 + 9 + 1 = 12.
     *
     */

    public HouseRobber() {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
        System.out.println(robDp(nums));
    }


    public int rob(int[] nums) {
        return rob(0, nums);
    }

    public int rob(int i, int[] nums){
        if(i >= nums.length) return 0;

        int robbed = nums[i] + rob(i+2, nums);
        int not_robbed = rob(i+1, nums);
        return Math.max(robbed, not_robbed);
    }

    public int robDp(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if(nums.length == 1) return dp[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i< nums.length; i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        new HouseRobber();
    }
}
