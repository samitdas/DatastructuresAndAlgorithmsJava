package org.samit.practice.graph;

import java.util.Arrays;

/**
 * Given a weighted undirected graph, find the shortest distance from a source vertex to every other vertex
 */
public class DijkstrasAlgorithm {

    public static void main(String[] args) {
        int[][] graph = {{0, 50, 100, 0},
                {50, 0, 30, 200},
                {100, 30, 0, 20},
                {0, 200, 20, 0}
        };

        DijkstrasAlgorithm djk = new DijkstrasAlgorithm();
        djk.findMsp(graph, 0);
    }

    /**
     * Dijkstra's algorithm : Maintain 2 sets (finalized and non-finalized)
     * Start with src vertex and finalize it and perform relax operation for all its adjacent vertices
     * Take the next non finalized vertex with least distance and relax its adjacent vertices
     */
    private void findMsp(int[][] graph, int src) {

        int v = graph.length;
        int[] dist = new int[v];

        boolean[] fin = new boolean[v];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0; // starting with src vertex hence its distance is 0

        for (int count = 0; count < v - 1; count++) {
            int u = -1;

            // choose the next vertex for processing by finding the min least distance among the vertices which are not finalized
            for (int i = 0; i < v; i++) {
                if (!fin[i] && (u == -1 || dist[i] < dist[u]))
                    u = i;
            }

            fin[u] = true; // included in msp

            // for each adjacent vertex of candidate vertex update the dist array with min distance
            for (int i = 0; i < v; i++) {
                if (!fin[i] && graph[u][i] != 0 && dist[i] > graph[u][i])
                    dist[i] = dist[u] + graph[u][i];
            }

        }

        System.out.println("result of dijkstra algo is : " + Arrays.toString(dist));

    }
}
