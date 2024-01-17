package org.samit.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a DAG, find the shortest distance of all vertices from a given source
 */
public class ShortestPathOfDag {

    public static void main(String[] args) {
// Directed acyclic graph
        ArrayList<ArrayList<Integer>> dfsAdjDirected = new ArrayList<>(4);
        int[] indegree = new int[4];
        for (int i = 0; i < 4; i++) {
            dfsAdjDirected.add(new ArrayList<>());
        }

        AdjacencyList.addEdgeDirected(dfsAdjDirected, 0, 1);
        indegree[1]++;
        AdjacencyList.addEdgeDirected(dfsAdjDirected, 1, 3);
        indegree[3]++;
        AdjacencyList.addEdgeDirected(dfsAdjDirected, 1, 2);
        indegree[2]++;
        AdjacencyList.addEdgeDirected(dfsAdjDirected, 2, 3);
        indegree[3]++;

        AdjacencyList.printAdj(dfsAdjDirected);
        System.out.println("indegree : " + Arrays.toString(indegree));

        ShortestPathOfDag sdg = new ShortestPathOfDag();
        sdg.shortestPath(dfsAdjDirected, 1, indegree);


    }

    private void shortestPath(ArrayList<ArrayList<Integer>> adj, int s, int[] indegree) {

        int[] dist = new int[adj.size()];
        int[][] weight = new int[4][4];
        weight[0][1] = 1;
        weight[1][3] = 2;
        weight[1][2] = 3;
        weight[2][3] = 4;

        for (int i = 0; i < adj.size(); i++) {
            if (i == s) dist[i] = 0;
            else dist[i] = Integer.MAX_VALUE;
        }

        // call topological sort
        TopologicalSorting ts = new TopologicalSorting();
        List<Integer> ls = new ArrayList<>();
        ts.topologicalSort(adj, indegree, ls);

        for (int u : ls) {
            for (int v : adj.get(u)) {
                if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + weight[u][v]) {
                    dist[v] = dist[u] + weight[u][v];
                }
            }
        }

        System.out.println("distances from source " + s + "is : " + Arrays.toString(dist));


    }
}
