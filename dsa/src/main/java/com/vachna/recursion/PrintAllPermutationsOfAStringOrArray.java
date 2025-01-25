package com.vachna.recursion;

import com.vachna.utill.HelperUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintAllPermutationsOfAStringOrArray {

    /**
     * Input: arr = [1, 2, 3]
     *
     * Output:
     * [
     *   [1, 2, 3],
     *   [1, 3, 2],
     *   [2, 1, 3],
     *   [2, 3, 1],
     *   [3, 1, 2],
     *   [3, 2, 1]
     * ]
     * https://leetcode.com/problems/permutations/description/
     */
    public PrintAllPermutationsOfAStringOrArray(){

        int[] nums = {1,2,3};
        List<List<Integer>> permute = permute(nums);
        HelperUtil.print(permute);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> allPer = new ArrayList<>();
        generateAllPermutation(0, nums, allPer);
        return allPer;
    }

    private void generateAllPermutation(int index, int[] nums, List<List<Integer>> allPer) {
        if(index==nums.length){
            List<Integer> per = new ArrayList<>();
            for(Integer x : nums){
                per.add(x);
            }
            allPer.add(per);
            return;
        }
        for(int i = index; i < nums.length; i++){
            swap(index, i, nums);
            generateAllPermutation(index+1, nums, allPer);
            swap(index, i, nums);
        }
    }

    private void swap(int index, int i, int[] nums) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        new PrintAllPermutationsOfAStringOrArray();
    }
}
