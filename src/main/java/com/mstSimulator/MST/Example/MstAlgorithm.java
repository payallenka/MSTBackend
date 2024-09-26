package com.mstSimulator.MST.Example;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class MstAlgorithm {

    static class Pair implements Comparable<Pair> {
        int node;
        int weight;

        public Pair(int weight, int node) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair other) {
            return this.weight - other.weight;
        }
    }

    public int calculateMst(int V, List<int[]> edges) {
        List<List<int[]>> adj = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));  // Start from node 0 with weight 0
        int totalWeight = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int weight = current.weight;

            if (visited[node]) continue;
            visited[node] = true;
            totalWeight += weight;

            for (int[] neighbor : adj.get(node)) {
                if (!visited[neighbor[0]]) {
                    pq.add(new Pair(neighbor[1], neighbor[0]));
                }
            }
        }
        return totalWeight;
    }
}
