package org.samit.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * TC : O(V+E)
 */
public class DetectCycle {

    public static void main(String[] args) {
        // Undirected graph
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


        DetectCycle dc = new DetectCycle();
        boolean isCycle = dc.dfsDisconnected(dfsAdj);
        System.out.println();
        System.out.println("is cycle : " + isCycle);

        // Directed graph
        ArrayList<ArrayList<Integer>> dfsAdjDirected = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            dfsAdjDirected.add(new ArrayList<>());
        }

        AdjacencyList.addEdgeDirected(dfsAdjDirected, 0, 1);
        AdjacencyList.addEdgeDirected(dfsAdjDirected, 2, 1);
        AdjacencyList.addEdgeDirected(dfsAdjDirected, 3, 4);
        AdjacencyList.addEdgeDirected(dfsAdjDirected, 2, 3);
        AdjacencyList.addEdgeDirected(dfsAdjDirected, 5, 3);
        AdjacencyList.addEdgeDirected(dfsAdjDirected, 4, 5);

        System.out.println("Directed graph");
        AdjacencyList.printAdj(dfsAdjDirected);

        System.out.println("is cycle for directed graph : " + dc.dfsForDirectedGraph(dfsAdjDirected));

        dc.startBfsForCyceDetection();
    }

    /**
     * For undirected graph
     *
     * @param adj
     * @param s
     * @param visited
     * @param parent
     * @return
     */
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, int parent) {
        visited[s] = true;
        System.out.print(s + " ");

        for (int v : adj.get(s)) {
            if (visited[v] == false) {
                boolean result = dfs(adj, v, visited, s);
                if (result == true) return true;
            } else if (v != parent)
                return true;
        }

        return false;
    }

    private boolean dfsDisconnected(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (visited[i] == false) {
                if (dfs(adj, i, visited, -1) == true)
                    return true;
            }
        }

        return false;
    }

    /**
     * For directed graph
     * @param adj
     * @param s
     * @param visited
     * @param recStack
     * @return
     */
    private boolean detectCycleInDirectedGraph(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, boolean[] recStack) {
        visited[s] = true;
        recStack[s] = true;

        for (int v : adj.get(s)) {
            if (visited[v] == false && detectCycleInDirectedGraph(adj, v, visited, recStack) == true)
                return true;
            else if (recStack[v] == true)
                return true;
        }

        recStack[s] = false;
        return false;

    }

    private boolean dfsForDirectedGraph(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        boolean[] recStack = new boolean[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            if (visited[i] == false) {
                if (detectCycleInDirectedGraph(adj, i, visited, recStack) == true)
                    return true;
            }
        }

        return false;
    }

    /**
     * Use topological sort ( kahn's bfs algo) to detect loop
     * @return
     */
    private boolean detectCycleBfs(ArrayList<ArrayList<Integer>> adj, int[] indegree){

        int V = adj.size(), count = 0;

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int v : adj.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0)
                    q.add(v);
            }
            count++;
        }

        return (count != V);
    }

    private void startBfsForCyceDetection(){

        // Directed Cyclic Graph
        ArrayList<ArrayList<Integer>> dfsAdjDirected = new ArrayList<>(5);
        int[] indegree = new int[5];
        for (int i = 0; i < 5; i++) {
            dfsAdjDirected.add(new ArrayList<>());
        }

        AdjacencyList.addEdgeDirected(dfsAdjDirected, 0, 1);
        indegree[1]++;
        AdjacencyList.addEdgeDirected(dfsAdjDirected, 1, 2);
        indegree[2]++;
        AdjacencyList.addEdgeDirected(dfsAdjDirected, 2, 3);
        indegree[3]++;
        AdjacencyList.addEdgeDirected(dfsAdjDirected, 3, 1);
        indegree[1]++;
        AdjacencyList.addEdgeDirected(dfsAdjDirected, 4, 1);
        indegree[1]++;

        AdjacencyList.printAdj(dfsAdjDirected);
        System.out.println("indegree : " + Arrays.toString(indegree));

        DetectCycle dc = new DetectCycle();
        System.out.println("is cycle for directed cyclic graph : " + dc.detectCycleBfs(dfsAdjDirected, indegree));

    }

}
