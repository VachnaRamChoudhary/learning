package dsa.src.main.java.com.vachna.array;

import java.util.ArrayList;
import java.util.Comparator;

public class MinimumOperationsToMakeAUniValueGrid {
    /**
     * You are given a 2D integer grid of size m x n and an integer x. In one operation, you can add x to or subtract x from any element in the grid.
     *
     * A uni-value grid is a grid where all the elements of it are equal.
     *
     * Return the minimum number of operations to make the grid uni-value. If it is not possible, return -1.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: grid = [[2,4],[6,8]], x = 2
     * Output: 4
     * Explanation: We can make every element equal to 4 by doing the following:
     * - Add x to 2 once.
     * - Subtract x from 6 once.
     * - Subtract x from 8 twice.
     * A total of 4 operations were used.
     * Example 2:
     *
     *
     * Input: grid = [[1,5],[2,3]], x = 1
     * Output: 5
     * Explanation: We can make every element equal to 3.
     * Example 3:
     *
     *
     * Input: grid = [[1,2],[3,4]], x = 2
     * Output: -1
     * Explanation: It is impossible to make every element equal.
     *
     * https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/?envType=daily-question&envId=2025-03-26
     */
    public MinimumOperationsToMakeAUniValueGrid() {

        int[][] array =  {{2,4}, {6,8}};
        System.out.println("Min op: "+ minOperations(array, 2));
    }

    public int minOperations(int[][] grid, int x) {
        int mod = grid[0][0]%x;
        ArrayList<Integer> flat = new ArrayList<>();
        for(int[] a : grid){
            for (int b : a){
                if(b%x != mod){
                    return -1;
                }
                flat.add(b);
            }
        }
        flat.sort(Comparator.naturalOrder());
        int medianIndex = flat.size()/2;

        int count = 0;
        for (int t : flat){
            count += Math.abs(t - flat.get(medianIndex))/x;
        }

        return count;
    }

    public static void main(String[] args) {
        new MinimumOperationsToMakeAUniValueGrid();
    }
}
