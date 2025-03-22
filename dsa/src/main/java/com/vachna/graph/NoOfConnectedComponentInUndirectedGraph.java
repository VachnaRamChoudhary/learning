package dsa.src.main.java.com.vachna.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Slf4j
public class NoOfConnectedComponentInUndirectedGraph {

    /**
     * You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.
     *
     * Return the number of complete connected components of the graph.
     *
     * A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.
     *
     * A connected component is said to be complete if there exists an edge between every pair of its vertices.
     *
     * https://leetcode.com/problems/count-the-number-of-complete-components/description/?envType=daily-question&envId=2025-03-22
     */

    public NoOfConnectedComponentInUndirectedGraph() {
//        int[][] edges = {{0,1},{0,2},{1,2},{3,4}};
        int[][] edges = {{0,1},{0,2},{1,2},{3,4},{3,5}};

        log.info("noOfConnectedComponents: {}", countCompleteComponents(6, edges));

    }

    public int countCompleteComponents(int n, int[][] edges) {
        List<ArrayList<Integer>> adjList = getAdjacencyList(n, edges);

        boolean[] vis = new boolean[n];
        int noOfConnectedComponents = 0;

        for (int i = 0; i < n; i++) {
            if(!vis[i]){
                List<Integer> visitedNodes = bfsTraversalFromNode(i, adjList, vis);
                boolean isConnectedComponent = isConnectedComponents(visitedNodes, adjList);
                if (isConnectedComponent) {
                    noOfConnectedComponents += 1;
                }
            }
        }
        return noOfConnectedComponents;
    }

    private boolean isConnectedComponents(List<Integer> nodes, List<ArrayList<Integer>> adjList) {
        int requiredEdges = nodes.size() - 1;
        if(requiredEdges <= 0){
            return true;
        }
        for (int x : nodes){
            if(requiredEdges != adjList.get(x).size()){
                return false;
            }
        }
        return true;
    }


    private List<Integer> bfsTraversalFromNode(int i, List<ArrayList<Integer>> adjList, boolean[] vis) {
        Queue<Integer> queue = new LinkedList<>();
        vis[i] = true;
        queue.add(i);
        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()){
            int x = queue.poll();
            List<Integer> neighbours = adjList.get(x);
            ans.add(x);
            log.info("q-> {}", queue);

            for(Integer y : neighbours){
                if(!vis[y]){
                    vis[y] = true;
                    queue.add(y);
                }
            }

        }
        return ans;
    }


    private List<ArrayList<Integer>> getAdjacencyList(int n, int[][] edges){
        List<ArrayList<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>()); // Properly initialize each inner list
        }

        for(int[] x : edges){
            adjList.get(x[0]).add(x[1]);
            adjList.get(x[1]).add(x[0]);
        }
        return adjList;
    }

    public static void main(String[] args) {
        new NoOfConnectedComponentInUndirectedGraph();
    }
}
