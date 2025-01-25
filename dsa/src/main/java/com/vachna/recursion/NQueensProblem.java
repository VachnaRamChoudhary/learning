package com.vachna.recursion;

import com.vachna.utill.HelperUtil;

import java.util.ArrayList;
import java.util.List;

public class NQueensProblem {

    /**
     * The n-queens puzzle is the problem of placing n queens on an n x n
     * chessboard such thatno two queens attack each other.
     *
     * Given an integer n, return all distinct solutions to the n-queens puzzle.
     * You may return the answer in any order.
     * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
     * https://leetcode.com/problems/n-queens/description/
     * << https://takeuforward.org/data-structure/n-queen-problem-return-all-distinct-solutions-to-the-n-queens-puzzle/  >>
     */

    public NQueensProblem(){
        HelperUtil.print(solveNQueens(4));
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> possibleAns = new ArrayList<>();
        Character[][] board = new Character[n][n];
        generatePossiblePlacements(0, n, board, possibleAns);
        return possibleAns;
    }

    private void generatePossiblePlacements(int col, int n, Character[][] board, List<List<String>> possibleAns) {
        if(col == n){
            List<String> ans = construct(board);
            possibleAns.add(ans);
            return;
        }

        for(int i = 0; i< n ;i++){
            if(isValidPlacement(col, i, board)){
                board[i][col] = 'Q';
                generatePossiblePlacements(col+1, n, board, possibleAns);
                board[i][col] = null;
            }
        }
    }

    private boolean isValidPlacement(int col, int row, Character[][] board) {
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] != null && board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] != null && board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] != null && board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;

    }

    private List<String> construct(Character[][] board) {
        List<String> ans = new ArrayList<>();
        for(int i =0 ;i < board.length; i++){
            StringBuilder s = new StringBuilder();
            for( int j =0; j< board.length; j++){
                s.append((board[i][j] != null && board[i][j] == 'Q') ? 'Q' : '.');
            }
            ans.add(String.valueOf(s));
        }
        return ans;
    }

    public static void main(String[] args) {
        new NQueensProblem();
    }
}
