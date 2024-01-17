package org.samit.practice.graph;

import java.util.*;

/**
 * Given a DAG (directed acyclic graph) , find the topological sorting
 * This is used in job scheduling i.e. run jobs in the dependency order
 * TC : O(V+E)
 */
public class TopologicalSorting {

    public static void main(String[] args) {

        // Directed acyclic graph
        ArrayList<ArrayList<Integer>> dfsAdjDirected = new ArrayList<>(5);
        int[] indegree = new int[5];
        for (int i = 0; i < 5; i++) {
            dfsAdjDirected.add(new ArrayList<>());
        }

        AdjacencyList.addEdgeDirected(dfsAdjDirected, 0, 2);
        indegree[2]++;
        AdjacencyList.addEdgeDirected(dfsAdjDirected, 0, 3);
        indegree[3]++;
        AdjacencyList.addEdgeDirected(dfsAdjDirected, 1, 3);
        indegree[3]++;
        AdjacencyList.addEdgeDirected(dfsAdjDirected, 1, 4);
        indegree[4]++;
        AdjacencyList.addEdgeDirected(dfsAdjDirected, 2, 3);
        indegree[3]++;

        AdjacencyList.printAdj(dfsAdjDirected);
        System.out.println("indegree : " + Arrays.toString(indegree));

        // call topological sort
        TopologicalSorting ts = new TopologicalSorting();
        ts.topologicalSort(dfsAdjDirected, indegree , null);

        // call dfs based solution
        System.out.println();
        ts.startDfs(dfsAdjDirected);
    }

    /**
     * kahn's bfs based algo
     *
     * @param adj
     * @param indegree
     */
    public void topologicalSort(ArrayList<ArrayList<Integer>> adj, int[] indegree, List<Integer> tsList) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            if(tsList != null)
                tsList.add(u);
            for (int v : adj.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0)
                    q.add(v);
            }
        }
    }

    /**
     * DFS based topological sort
     * @param adj
     * @param stack
     * @param visited
     * @param s
     */
    private void dfsBasedTopologicalSort(ArrayList<ArrayList<Integer>> adj, Deque<Integer> stack, boolean[] visited, int s) {

        visited[s] = true;

        for (int v : adj.get(s)) {
            if (visited[v] == false) {
                dfsBasedTopologicalSort(adj, stack, visited, v);
            }
        }

        stack.push(s);

    }

    private void startDfs(ArrayList<ArrayList<Integer>> adj) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            if (visited[i] == false)
                dfsBasedTopologicalSort(adj, stack, visited, i);
        }

        while (!stack.isEmpty()) {
            int val = stack.pop();
            System.out.print(val + " ");
        }

    }
}
