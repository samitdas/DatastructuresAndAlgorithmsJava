package org.samit.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS and DFS. For simplicity node with lesser value is chosen and printed first but there are many valid solutions
 * TC is O(v + e ) for both traversals ( v - number of vertices, e - number of edges [2e in case of undirected graph])
 */
public class GraphTraversal {

    public static void main(String[] args) {
        // BFS
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            adj.add(new ArrayList<>());
        }

        AdjacencyList.addEdge(adj, 0, 1);
        AdjacencyList.addEdge(adj, 0, 2);
        AdjacencyList.addEdge(adj, 1, 3);
        AdjacencyList.addEdge(adj, 2, 3);
        AdjacencyList.addEdge(adj, 4, 5);
        AdjacencyList.addEdge(adj, 4, 6);
        AdjacencyList.addEdge(adj, 5, 6);

        AdjacencyList.printAdj(adj);

        GraphTraversal gt = new GraphTraversal();
        int islands = gt.bfsDisconnected(adj);

        System.out.println("number of islands in the graph : " + islands);

        // DFS
        int islands2 = gt.dfsDisconnected(adj);
        System.out.println("islands count using dfs : " + islands2);

        // DFS test again
        ArrayList<ArrayList<Integer>> dfsAdj = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            dfsAdj.add(new ArrayList<>());
        }

        AdjacencyList.addEdge(dfsAdj, 0, 1);
        AdjacencyList.addEdge(dfsAdj, 0, 2);
        AdjacencyList.addEdge(dfsAdj, 1, 3);
        AdjacencyList.addEdge(dfsAdj, 2, 3);
        AdjacencyList.addEdge(dfsAdj, 1, 4);
        AdjacencyList.addEdge(dfsAdj, 4, 5);

        int islands3 = gt.dfsDisconnected(dfsAdj);
        System.out.println("islands count using dfs (second run) : " + islands3);
    }

    /**
     * Given an adjacency list of an undirected graph do breadth first search
     * Print the source vertex, then its immediate neighbours and their neighbours and so on
     *
     * @param adj
     */
    private void bfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int v : adj.get(u)) {
                if (visited[v] == false) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }

    }

    private int bfsDisconnected(ArrayList<ArrayList<Integer>> adj) {
        int islands = 0;
        int v = adj.size();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (visited[i] == false) {
                bfs(adj, i, visited);
                islands++;
            }
        }

        System.out.println();
        return islands;
    }

    /**
     * Depth first search ( recursive in nature )
     */
    private void dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        visited[s] = true;

        System.out.print(s + " ");

        for(int v : adj.get(s)){
            if(visited[v] == false){
                dfs(adj, v, visited);
            }
        }

    }

    private int dfsDisconnected(ArrayList<ArrayList<Integer>> adj) {
        int islands = 0;
        int v = adj.size();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (visited[i] == false) {
                dfs(adj, i, visited);
                islands++;
            }
        }

        System.out.println();
        return islands;
    }
}
