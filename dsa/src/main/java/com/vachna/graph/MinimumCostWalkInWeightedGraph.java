package dsa.src.main.java.com.vachna.graph;

import java.util.*;

public class MinimumCostWalkInWeightedGraph {

    /**
     * https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph/?envType=daily-question&envId=2025-03-20
     */

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        ArrayList<ArrayList<int[]>> adj = getAdjList(n, edges);
        //Group no will be traversing start from node no.
        Map<Integer, Integer> groupAndXorVal = new HashMap<>();
        Map<Integer, Integer> nodeToGroupMapping = new HashMap<>();
        bfsOfDisconnectedGraph(n, adj, groupAndXorVal, nodeToGroupMapping);
        int[] ans = new int[query.length];
        for (int i = 0; i< query.length; i++){
            int[] arr = query[i];
            int from = arr[0], to = arr[1];
            if(Objects.equals(nodeToGroupMapping.get(from), nodeToGroupMapping.get(to))){
                ans[i] = groupAndXorVal.get(nodeToGroupMapping.get(from));
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }

    public void bfsOfDisconnectedGraph(int V, ArrayList<ArrayList<int[]>> adj, Map<Integer, Integer> groupAndXorVal, Map<Integer, Integer> nodeToGroupMapping){
        boolean[] vis = new boolean[V]; // Automatically initialized to false

        for(int i = 0; i < V; i++){
            if(!vis[i]){
                int bitwiseOr = bfsFromNode(adj, i, vis, nodeToGroupMapping);
                groupAndXorVal.put(i, bitwiseOr);
            }
        }

    }

    private int bfsFromNode(ArrayList<ArrayList<int[]>> adj, int i, boolean[] vis, Map<Integer, Integer> nodeToGroupMapping) {
        Queue<Integer> queue = new LinkedList<>();

        int bitwiseOr = (1 << 20) - 1;  // 1048575 in decimal (all 20 lower bits are set)

        queue.add(i);
        vis[i] = true;
        nodeToGroupMapping.put(i, i);  // Initialize group mapping
        while (!queue.isEmpty()) {
            int ele = queue.poll();
            for (int[] x : adj.get(ele)) {
                int neighbor = x[0];
                if (!vis[neighbor]) {
                    queue.add(neighbor);
                    vis[neighbor] = true;
                    bitwiseOr &= x[1];
                    nodeToGroupMapping.put(neighbor, i);  // Always assign
                }
            }
        }
        return bitwiseOr;
    }

    ArrayList<ArrayList<int[]>> getAdjList(int n, int[][] edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());  // Initialize each adjacency list
        }

        for (int[] arr : edges) {
            int from = arr[0];
            int to = arr[1];
            int weight = arr[2];
            adj.get(from).add(new int[]{to, weight});
            adj.get(to).add(new int[]{from, weight}); // If the graph is undirected
        }

        return adj;
    }

}
