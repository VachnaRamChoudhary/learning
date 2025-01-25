package com.vachna.recursion;

import com.vachna.utill.HelperUtil;

import java.util.*;

public class CombinationSum_ll {

    /**
     *Given a collection of candidate numbers (candidates) and a target number (target),
     *  find all unique combinations in candidates where the candidate numbers sum to target.
     *
     * Each number in candidates may only be used once in the combination.
     *
     * Note: The solution set must not contain duplicate combinations.
     *
     * Example 1:
     *
     * Input: candidates = [10,1,2,7,6,1,5], target = 8
     * Output:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * Example 2:
     *
     * Input: candidates = [2,5,2,1,2], target = 5
     * Output:
     * [
     * [1,2,2],
     * [5]
     * ]
     *
     * https://leetcode.com/problems/combination-sum-ii/description/
     */

    public CombinationSum_ll(){
        List<List<Integer>> combinationSum = combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        HelperUtil.print(combinationSum);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> combinations = new HashSet<>();
        Arrays.sort(candidates);
        getCombinationForSum(0, new ArrayList<Integer>(), combinations, candidates, target);
        return new ArrayList<>(combinations);
    }

    private void getCombinationForSum(int i, ArrayList<Integer> com, Set<List<Integer>> combinations, int[] candidates, int target) {
        if(target == 0){
            combinations.add(new ArrayList<>(com));
            return;
        }
        if(target < 0 || i == candidates.length) return;
        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j] == candidates[j - 1]) continue;
            if (candidates[j] > target) break;

            com.add(candidates[j]);
            getCombinationForSum(j+1, com, combinations, candidates, target - candidates[j]);
            com.removeLast();
        }

    }

    public static void main(String[] args) {
        new CombinationSum_ll();
    }
}
