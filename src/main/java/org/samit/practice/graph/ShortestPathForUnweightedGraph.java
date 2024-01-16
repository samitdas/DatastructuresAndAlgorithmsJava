package org.samit.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an unweighted graph , find the shortest path from source vertex to destination vertex
 * Uses BFS traversal to find the shortest paths
 * TC : O(V+E)
 */
public class ShortestPathForUnweightedGraph {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }

        AdjacencyList.addEdge(adj, 0, 1);
        AdjacencyList.addEdge(adj, 0, 2);
        AdjacencyList.addEdge(adj, 1, 2);
        AdjacencyList.addEdge(adj, 1, 3);

        AdjacencyList.printAdj(adj);


        ShortestPathForUnweightedGraph swg = new ShortestPathForUnweightedGraph();
        swg.findShortestPath(adj, 0);

    }

    private void findShortestPath(ArrayList<ArrayList<Integer>> adj, int s){

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        int[] dist = new int[adj.size()];

        for(int i=0; i < adj.size() ; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        visited[s] = true;
        dist[s] = 0;
        q.add(s);

        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u + " ");
            for(int v : adj.get(u)){
                if(visited[v] == false){
                    visited[v] = true;
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }

        System.out.println();
        System.out.println("shortest path from 0 vertex : " + Arrays.toString(dist));

    }

}
