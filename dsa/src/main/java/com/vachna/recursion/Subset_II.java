package com.vachna.recursion;

import com.vachna.utill.HelperUtil;

import java.util.*;

public class Subset_II {
    /**
     * Given an integer array nums that may contain duplicates, return all possible
     * subsets
     *  (the power set).
     *
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     * https://leetcode.com/problems/subsets-ii/description/
     */

    public Subset_II(){
        int[] arr = {5,6,7};
        List<List<Integer>> subsetsSum = subsetSums(arr);
        HelperUtil.print(subsetsSum);
    }

    public List<List<Integer>> subsetSums(int[] arr) {
        Set<List<Integer>> subsetSet = new HashSet<>(); // Use Set to eliminate duplicates
        generateSubsetSums(0, new ArrayList<>(), subsetSet, arr);
        return new ArrayList<>(subsetSet); // Convert Set back to List
    }

    private void generateSubsetSums(int i, ArrayList<Integer> sets, Set<List<Integer>> subsetSet, int[] arr) {
        if (i == arr.length) {
            // Add a sorted copy of the current set to the Set
            List<Integer> sortedSet = new ArrayList<>(sets);
            Collections.sort(sortedSet);
            subsetSet.add(sortedSet);
            return;
        }

        // Include the current element in the subset
        sets.add(arr[i]);
        generateSubsetSums(i + 1, sets, subsetSet, arr);

        // Backtrack: remove the last element and exclude it from the subset
        sets.removeLast();
        generateSubsetSums(i + 1, sets, subsetSet, arr);
    }


    public static void main(String[] args) {
        new Subset_II();
    }
}
