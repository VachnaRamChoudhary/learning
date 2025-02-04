package com.vachna.dynamic.programic;

public class UniquePaths {

    /**
     * There is a robot on an m x n grid. The robot is initially located at the top-left corner
     * (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
     *
     * Given the two integers m and n, return the number of possible unique paths
     * that the robot can take to reach the bottom-right corner.
     *
     * The test cases are generated so that the answer will be less than or equal to 2 * 109.
     *
     * https://leetcode.com/problems/unique-paths/description/
     */

    public UniquePaths() {
        System.out.println(uniquePaths(1,1));
        System.out.println(pathsDp(3,7));
    }

    public int uniquePaths(int m, int n) {
        return paths(0, 0, m, n);
    }

    public int paths(int i, int j, int m, int n){
        if(i==m-1 && j == n-1) return 1;
        if(i >= m || j >= n) return 0;

        return paths(i+1, j, m, n) + paths(i, j+1, m, n);

    }

    public int pathsDp(int m , int n){
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j =0 ; j<n; j++){
                if(i==0 || j==0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        new UniquePaths();
    }
}
