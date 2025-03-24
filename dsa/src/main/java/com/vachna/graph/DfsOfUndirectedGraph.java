package dsa.src.main.java.com.vachna.graph;

import java.util.ArrayList;

public class DfsOfUndirectedGraph {

    /**
     * https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
     */

    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[adj.size()];
        dfs(0, adj, vis, ans);
        return ans;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ans) {
        vis[node] = true;
        ans.add(node);

        for(Integer neighbour : adj.get(node)){
            if(!vis[neighbour]){
                dfs(neighbour, adj, vis, ans);
            }
        }
    }
}
