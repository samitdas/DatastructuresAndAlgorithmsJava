package org.samit.practice.graph;

import java.util.ArrayList;

public class AdjacencyList {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);

        printAdj(adj);

        ArrayList<ArrayList<Integer>> test = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                ArrayList<Integer> k = new ArrayList<>();
                for (int j = 1; j < 3; j++) {
                    k.add(j);
                }
                test.add(k);
            } else test.add(new ArrayList<>());
        }
        System.out.println(test.get(0));
    }

    /**
     * Add edge for undirected graph
     *
     * @param adj
     * @param u
     * @param v
     */
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void printAdj(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println(i + " : " + adj.get(i));
        }
    }
}
