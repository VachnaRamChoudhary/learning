package com.vachna.dynamic.programic;

public class LongestCommonSubsequence {



    /**
     * Given two strings text1 and text2, return the length of their longest common subsequence.
     * If there is no common subsequence, return 0.
     *
     * A subsequence of a string is a new string generated from the original string with some characters
     * (can be none) deleted without changing the relative order of the remaining characters.
     *
     * For example, "ace" is a subsequence of "abcde".
     * A common subsequence of two strings is a subsequence that is common to both strings.
     */

    public LongestCommonSubsequence() {
        String a = "ubmrapg";
        String b = "ezupkr";
        System.out.println(longestCommonSubsequence(a, b));
        System.out.println(lcsDp(a, b));
        System.out.println(lcsDpV2(a, b));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(0, 0, text1, text2);
    }

    private int lcs(int i, int j, String text1, String text2) {
        if(i == text1.length() || j == text2.length()) return 0;


        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + lcs(i+1, j+1, text1, text2);
        }else {
            return Math.max(lcs(i+1, j, text1, text2), lcs(i, j+1, text1, text2));
        }
    }

    public int lcsDp(String a, String b){
        if(a.isEmpty() || b.isEmpty()) return 0;
        int[][] dp = new int[a.length()][b.length()];
        for(int i = 0; i < a.length(); i++){
            for(int j = 0; j < b.length(); j++){
                if(a.charAt(i) == b.charAt(j)){
                    if(i == 0 && j == 0){
                        dp[i][j] = 1;
                    } else if (i == 0) {
                        dp[i][j] = 1;
                    } else if (j == 0) {
                        dp[i][j] = dp[i-1][j];
                    }else {
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }
                } else {
                    if(i == 0 && j == 0){
                        dp[i][j] = 0;
                    } else if (i == 0) {
                        dp[i][j] = dp[i][j-1];
                    } else if (j == 0) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }

            }
        }
        return dp[a.length()-1][b.length()-1];
    }

    public int lcsDpV2(String a, String b){
        if(a.isEmpty() || b.isEmpty()) return 0;
        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int i = 0; i <= a.length(); i++){
            for(int j = 0; j <= b.length(); j++){
                if(i==0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    public static void main(String[] args) {
        new LongestCommonSubsequence();
    }
}
