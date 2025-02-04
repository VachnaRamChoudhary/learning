package com.vachna.dynamic.programic;

import com.vachna.utill.HelperUtil;

public class JumpGame {
    /**
     * You are given an integer array nums. You are initially positioned at the array's first index,
     * and each element in the array represents your maximum jump length at that position.
     *
     * Return true if you can reach the last index, or false otherwise.
     * Example 1:
     *
     * Input: nums = [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     *
     * Input: nums = [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum
     * jump length is 0, which makes it impossible to reach the last index.
     *
     * https://leetcode.com/problems/jump-game/
     */

    public JumpGame() {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
        System.out.println(canJump(nums));
    }
    public boolean canJump(int[] nums) {
         return jump(0, nums);
    }


    private boolean jump(int i, int[] nums) {
        if(i >= nums.length) return false;
        if(i == nums.length-1) return true;

        int x = nums[i];
        for(int j = 1; j <= x; j++){
            if(jump(i+j, nums)) return true;
        }
        return false;
    }

    public boolean canJumpDP(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false; // If we can't reach this index, return false
            maxReach = Math.max(maxReach, i + nums[i]); // Update max reachable index
        }

        return true; // If we finish the loop, we can reach the last index
    }

    public static void main(String[] args) {
        new JumpGame();
    }

}
