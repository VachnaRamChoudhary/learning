package com.vachna.recursion;

import com.vachna.utill.HelperUtil;

import java.util.*;

public class CombinationSum {

    /**
     *Given an array of distinct integers candidates and a target integer target,
     * return a list of all unique combinations of candidates where the chosen numbers sum to target.
     * You may return the combinations in any order.
     *
     * The same number may be chosen from candidates an unlimited number of times.
     * Two combinations are unique if the
     * frequency
     *  of at least one of the chosen numbers is different.
     *
     * The test cases are generated such that the number of unique combinations that sum up to
     * target is less than 150 combinations for the given input.
     *
     * https://leetcode.com/problems/combination-sum/description/
     *
     * Input: candidates = [2,3,6,7], target = 7
     * Output: [[2,2,3],[7]]
     * Explanation:
     * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
     * 7 is a candidate, and 7 = 7.
     * These are the only two combinations.
     * Example 2:
     *
     * Input: candidates = [2,3,5], target = 8
     * Output: [[2,2,2,2],[2,3,3],[3,5]]
     */

    public CombinationSum(){
        List<List<Integer>> combinationSum = combinationSum(new int[]{2, 3, 5}, 8);
        HelperUtil.print(combinationSum);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> combinations = new HashSet<>();
        getCombinationForSum(0, new ArrayList<Integer>(), combinations, candidates, target);
        return new ArrayList<>(combinations);
    }

    private void getCombinationForSum(int i, ArrayList<Integer> com, Set<List<Integer>> combinations, int[] candidates, int target) {
        if(target == 0){
            ArrayList<Integer> ans = new ArrayList<>(com);
            Collections.sort(ans);
            combinations.add(ans);
            return;
        }
        if(target < 0 || i == candidates.length) return;
        com.add(candidates[i]);
        getCombinationForSum(i, com, combinations, candidates, target - candidates[i]);
        com.removeLast();
        getCombinationForSum(i+1, com, combinations, candidates, target);
    }

    public static void main(String[] args) {
        new CombinationSum();
    }
}
