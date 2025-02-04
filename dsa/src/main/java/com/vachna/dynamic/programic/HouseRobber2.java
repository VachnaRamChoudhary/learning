package com.vachna.dynamic.programic;

public class HouseRobber2 {

    /**
     *You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
     * That means the first house is the neighbor of the last one. Meanwhile,
     * adjacent houses have a security system connected,
     * and it will automatically contact the police if two adjacent houses were broken into on the same night.
     *
     * Given an integer array nums representing the amount of money of each house,
     * return the maximum amount of money you can rob tonight without alerting the police.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,3,2]
     * Output: 3
     * Explanation: You cannot rob house 1 (money = 2) and then rob house 3
     * (money = 2), because they are adjacent houses.
     *
     */

    public HouseRobber2() {
//        int[] nums = {2,7,9,3,1};
        int[] nums = {1};
        System.out.println(rob2(nums));
        System.out.println(robDp(nums));
    }


    public int rob2(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int[] first_element_removed = new int[nums.length-1];
        int[] last_element_removed = new int[nums.length-1];
        for(int i = 0; i < nums.length; i++){
            if(i != 0) first_element_removed[i-1] = nums[i];
            if(i != nums.length-1) last_element_removed[i] = nums[i];
        }
        return Math.max(robDp(first_element_removed), robDp(last_element_removed));
    }

    public int rob(int i, int[] nums){
        if(i >= nums.length) return 0;

        int robbed = nums[i] + rob(i+2, nums);
        int not_robbed = rob(i+1, nums);
        return Math.max(robbed, not_robbed);
    }

    public int robDp(int[] nums){
        int[] dp = new int[nums.length];
        if(nums.length == 0) return 0;
        dp[0] = nums[0];
        if(nums.length == 1) return dp[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i< nums.length; i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        new HouseRobber2();
    }
}
