package dsa.src.main.java.com.vachna.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CheckIfGridCanBeCutIntoSections {

    /**
     * You are given an integer n representing the dimensions of an n x n grid, with the
     * origin at the bottom-left corner of the grid. You are also given a 2D array of coordinates rectangles,
     * where rectangles[i] is in the form [startx, starty, endx, endy], representing a rectangle on the grid.
     * Each rectangle is defined as follows:
     *
     * (startx, starty): The bottom-left corner of the rectangle.
     * (endx, endy): The top-right corner of the rectangle.
     * Note that the rectangles do not overlap. Your task is to determine if it is possible to make
     *
     * either two horizontal or two vertical cuts on the grid such that:
     *
     * Each of the three resulting sections formed by the cuts contains at least one rectangle.
     * Every rectangle belongs to exactly one section.
     * Return true if such cuts can be made; otherwise, return false.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 5, rectangles = [[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]]
     *
     * Output: true
     *
     * Explanation:
     *
     *
     *
     * The grid is shown in the diagram. We can make horizontal cuts at y = 2 and y = 4. Hence, output is true.
     *
     * Example 2:
     *
     * Input: n = 4, rectangles = [[0,0,1,1],[2,0,3,4],[0,2,2,3],[3,0,4,3]]
     *
     * Output: true
     *
     * Explanation:
     *
     *
     *
     * We can make vertical cuts at x = 2 and x = 3. Hence, output is true.
     *
     * Example 3:
     *
     * Input: n = 4, rectangles = [[0,2,2,4],[1,0,3,2],[2,2,3,4],[3,0,4,2],[3,2,4,4]]
     *
     * Output: false
     *
     * Explanation:
     *
     * We cannot make two horizontal or two vertical cuts that satisfy the conditions. Hence,
     * output is false.
     *
     * https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/description/?envType=daily-question&envId=2025-03-25
     *
     */


    public CheckIfGridCanBeCutIntoSections() {
//        int[][] rectangles = {{1,0,5,2},{0,2,2,4},{3,2,5,3},{0,4,4,5}};
        int[][] rectangles = {{0,2,2,4},{1,0,3,2},{2,2,3,4},{3,0,4,2},{3,2,4,4}};
        System.out.println("Ans :" + checkValidCuts(4, rectangles));
    }



    public boolean checkValidCuts(int n, int[][] rectangles) {
        ArrayList<Pair> xEdges = new ArrayList<>();
        ArrayList<Pair> yEdges = new ArrayList<>();
        for (int[] edges: rectangles){
            xEdges.add(new Pair(edges[0], edges[2]));
            yEdges.add(new Pair(edges[1], edges[3]));
        }
        xEdges.sort(Comparator.comparingInt(x -> x.first));
        yEdges.sort(Comparator.comparingInt(x -> x.first));

        int xMaxEnd = 0, yMaxEnd = 0, xCount = 0, yCount = 0;
        for (int i=0; i< rectangles.length; i++){
            Pair xEdge = xEdges.get(i);
            Pair yEdge = yEdges.get(i);
            if(isValidLine(xMaxEnd, xEdge.first, n)){
                xCount++;
            }
            if(isValidLine(yMaxEnd, yEdge.first, n)){
                yCount++;
            }

            if(xCount >= 2 || yCount >= 2) return true;

            xMaxEnd = Math.max(xMaxEnd, xEdge.second);
            yMaxEnd = Math.max(yMaxEnd, yEdge.second);
        }

        return (xCount >= 2 || yCount >= 2);

    }

    public boolean isValidLine(int maxEnd, int nextStart, int n){
        return maxEnd > 0 && maxEnd < n && maxEnd <= nextStart;
    }

    public static class Pair{
        int first;
        int second;

        public Pair(int first, int second ) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        new CheckIfGridCanBeCutIntoSections();
    }
}
