package dsa.src.main.java.com.vachna.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsOfUndirectedGraph {

    /**
     * https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
     */
    public BfsOfUndirectedGraph() {

    }

    public ArrayList<Integer> bfsOfDisconnectedGraph(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V]; // Automatically initialized to false
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                ans.addAll(bfsFromNode(adj, i, vis));
            }
        }

        return ans;

    }

    private ArrayList<Integer> bfsFromNode(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(i);
        vis[i] = true;
        while (!queue.isEmpty()){
            Integer ele = queue.poll();
            ans.add(ele);
            for(Integer x : adj.get(ele)){
                if(!vis[x]){
                    queue.add(x);
                    vis[x] = true;
                }
            }
        }
        return ans;
    }

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V]; // Automatically initialized to false
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        vis[0] = true;
        while (!queue.isEmpty()){
            Integer i = queue.poll();
            ans.add(i);
            for(Integer x : adj.get(i)){
                if(!vis[x]){
                    queue.add(x);
                    vis[x] = true;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new BfsOfUndirectedGraph();
    }
}
