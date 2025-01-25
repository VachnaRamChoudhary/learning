package com.vachna.recursion;

import com.vachna.utill.HelperUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SubsetSums {
    /**
     * Input: arr[] = [2, 3]
     * Output: [0, 2, 3, 5]
     * Explanation: When no elements are taken then Sum = 0.
     * When only 2 is taken then Sum = 2.
     * When only 3 is taken then Sum = 3.
     * When elements 2 and 3 are taken then Sum = 2+3 = 5.
     * https://www.geeksforgeeks.org/problems/subset-sums2234/1
     */

    public SubsetSums(){
        int[] arr = {5,6,7};
        ArrayList<Integer> subsetsSum = subsetSums(arr);
        HelperUtil.print(subsetsSum);
    }

    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> subsetSums = new ArrayList<>();
        generateSubsetSums(0, 0, subsetSums, arr);
        Collections.sort(subsetSums);
        return subsetSums;
    }

    private void generateSubsetSums(int i, int sum, ArrayList<Integer> subsetSums, int[] arr) {
        if(i==arr.length){
            subsetSums.add(sum);
            return;
        }
        generateSubsetSums(i+1, sum + arr[i], subsetSums, arr);
        generateSubsetSums(i+1, sum, subsetSums, arr);
    }

    public static void main(String[] args) {
        new SubsetSums();
    }
}
