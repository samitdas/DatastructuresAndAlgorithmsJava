package org.samit.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class AdjacencyList {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(4);
        for(int i = 0 ; i < 4; i++){
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);

        printAdj(adj);
    }

    /**
     * Add edge for undirected graph
     * @param adj
     * @param u
     * @param v
     */
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v ){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void printAdj(ArrayList<ArrayList<Integer>> adj){
        for(int i=0; i< adj.size(); i++){
            System.out.println( i + " : " + adj.get(i));
        }
    }
}
