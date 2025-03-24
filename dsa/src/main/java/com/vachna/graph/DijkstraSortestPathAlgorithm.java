package dsa.src.main.java.com.vachna.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraSortestPathAlgorithm {

    /**
     * Given a weighted, undirected and connected graph where you have given adjacency list adj.
     * You have to find the shortest distance of all the vertices from the source vertex src,
     * and return a list of integers denoting the shortest distance between each node and source
     * vertex src.
     *
     * Note: The Graph doesn't contain any negative weight edge.
     *
     * https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
     */

    public DijkstraSortestPathAlgorithm() {
        int[][][] input = {
                {{1, 1}, {2, 6}},
                {{2, 3}, {0, 1}},
                {{1, 3}, {0, 6}}
        };

        ArrayList<ArrayList<iPair>> adjList = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            ArrayList<iPair> tempList = new ArrayList<>();
            for (int[] pair : input[i]) {
                tempList.add(new iPair(pair[0], pair[1]));
            }
            adjList.add(tempList);
        }

        System.out.println("Ans: " + dijkstra(adjList, 2));
    }

    // Function to find the shortest path from a source node to all other nodes
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        ArrayList<Integer> dist = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            dist.add(Integer.MAX_VALUE);
        }
        PriorityQueue<iPair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.second)); // first -> node , second -> distance

        dist.set(src, 0);
        pq.add(new iPair(src, 0));

        while (!pq.isEmpty()){
            iPair pair = pq.poll();
            int node = pair.first;
            int d = pair.second;
            for(iPair neighbour : adj.get(node)){
                int neighbourNode = neighbour.first, neighbourDist = neighbour.second;
                int newDist = neighbourDist + d;
                if( newDist < dist.get(neighbourNode)){
                    pq.add(new iPair(neighbourNode, newDist));
                    dist.set(neighbourNode, newDist);
                }
            }
        }
        return dist;
    }


    public static class iPair {
        public int first, second;

        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


    public static void main(String[] args) {
        new DijkstraSortestPathAlgorithm();
    }
}
