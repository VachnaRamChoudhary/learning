package dsa.src.main.java.com.vachna.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

@Slf4j
public class NumberOfWaysToArriveAtDestination {

    /**
     * You are in a city that consists of n intersections numbered from 0 to n - 1 with
     * bi-directional roads between some intersections. The inputs are generated
     * such that you can reach any intersection from any other intersection and that
     * there is at most one road between any two intersections.
     *
     * You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei]
     * means that there is a road between intersections ui and vi that takes timei minutes to travel.
     * You want to know in how many ways you can travel from intersection 0 to intersection n - 1
     * in the shortest amount of time.
     *
     * Return the number of ways you can arrive at your destination in the shortest amount of time.
     * Since the answer may be large, return it modulo 109 + 7.
     *
     * Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
     * Output: 4
     * Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
     * The four ways to get there in 7 minutes are:
     * - 0 ➝ 6
     * - 0 ➝ 4 ➝ 6
     * - 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
     * - 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
     * Example 2:
     *
     * Input: n = 2, roads = [[1,0,10]]
     * Output: 1
     * Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.
     *
     * https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/?envType=daily-question&envId=2025-03-23
     *
     */

    public NumberOfWaysToArriveAtDestination() {
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        log.info("No of paths: {}", countPaths(7, roads));
    }

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<iPair>> adj = getAdjList(n, roads);
        return modifiedDijkstra(0, n, adj);
    }

    public int modifiedDijkstra(int src, int n, ArrayList<ArrayList<iPair>> adj){
        ArrayList<iPair> distAndCount = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            distAndCount.add(new iPair(Integer.MAX_VALUE, 0));
        }

        PriorityQueue<iPair> pq = new PriorityQueue<>(Comparator.comparingInt(x->x.second));

        distAndCount.get(src).first = 0;
        distAndCount.get(src).second = 1; // Source node has 1 way to reach itself
        pq.add(new iPair(src, 0));

        while (!pq.isEmpty()){
            iPair pair = pq.poll();
            int node = pair.first;
            int d = pair.second;

            if (d > distAndCount.get(node).first) continue; // Skip outdated entries

            for (iPair neighbour : adj.get(node)){
                int neighbourNode = neighbour.first, neighbourDist = neighbour.second;
                int newDist = neighbourDist + d;

                if (newDist < distAndCount.get(neighbourNode).first) {
                    distAndCount.get(neighbourNode).first = newDist;
                    distAndCount.get(neighbourNode).second = distAndCount.get(node).second;
                    pq.add(new iPair(neighbourNode, newDist));
                } else if (newDist == distAndCount.get(neighbourNode).first) {
                    distAndCount.get(neighbourNode).second =
                            (distAndCount.get(neighbourNode).second + distAndCount.get(node).second) % 1_000_000_007;
                }
            }
        }

        return distAndCount.get(n-1).second;
    }

    ArrayList<ArrayList<iPair>> getAdjList(int n, int[][] edges) {
        ArrayList<ArrayList<iPair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());  // Initialize each adjacency list
        }

        for (int[] arr : edges) {
            int from = arr[0];
            int to = arr[1];
            int weight = arr[2];
            adj.get(from).add(new iPair(to, weight));
            adj.get(to).add(new iPair(from, weight)); // If the graph is undirected
        }

        return adj;
    }

    public static class iPair {
        public int first, second;

        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        new NumberOfWaysToArriveAtDestination();
    }



    public int countPathsCorrect(int n, int[][] roads) {

        // Creating an adjacency list for the given graph.
        ArrayList < ArrayList < iPair >> adj = new ArrayList < > ();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList < > ());
        }
        int m = roads.length;
        for (int i = 0; i < m; i++) {
            adj.get(roads[i][0]).add(new iPair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new iPair(roads[i][0], roads[i][2]));
        }

        // Defining a priority queue (min heap).
        PriorityQueue < iPair > pq = new PriorityQueue < iPair > ((x, y) -> x.first - y.first);

        // Initializing the dist array and the ways array
        // along with their first indices.
        int[] dist = new int[n];
        int[] ways = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new iPair(0, 0));

        // Define modulo value
        int mod = (int)(1e9 + 7);

        // Iterate through the graph with the help of priority queue
        // just as we do in Dijkstra's Algorithm.
        while (pq.size() != 0) {
            int dis = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            for (iPair it : adj.get(node)) {
                int adjNode = it.first;
                int edW = it.second;

                // This ‘if’ condition signifies that this is the first
                // time we’re coming with this short distance, so we push
                // in PQ and keep the no. of ways the same.
                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new iPair(dis + edW, adjNode));
                    ways[adjNode] = ways[node];
                }

                // If we again encounter a node with the same short distance
                // as before, we simply increment the no. of ways.
                else if (dis + edW == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        // Finally, we return the no. of ways to reach
        // (n-1)th node modulo 10^9+7.
        return ways[n - 1] % mod;
    }
}
