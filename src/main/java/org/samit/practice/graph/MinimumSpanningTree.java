package org.samit.practice.graph;

import java.util.Arrays;

/**
 * Given a weighted and connected undirected graph find the minimum spanning tree
 * An MSP is a graph where all vertices are connected possibly through intermediate vertices with shortest weights
 * Prim's Algorithm
 * No cycles and for V vertices there will V-1 edges and weight should be minimum
 */
public class MinimumSpanningTree {

    public static void main(String[] args) {
        int[][] graph = {{0, 5, 8, 0},
                {5, 0, 10, 15},
                {8, 10, 0, 20},
                {0, 15, 20, 0}
        };

        MinimumSpanningTree msp = new MinimumSpanningTree();
        msp.findMsp(graph);
    }

    /**
     * Prim's algorithm : Maintain 2 sets (MSP and Non-Msp)
     * Start with any vertex and put it in MSP and find the minimum weight (Greedy approach) connecting this vertex to the rest of the vertices in Non-MSP
     * Include the vertices with min edge in the MSP and follow the above step
     * Finally the MSP will have all vertices with minimum weight edges
     */
    private void findMsp(int[][] graph) {

        int v = graph.length;
        int[] key = new int[v];
        int res = 0;

        boolean[] msp = new boolean[v];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0; // starting with vertex 0 hence its distance is 0

        for (int count = 0; count < v; count++) {
            int u = -1;

            // choose the next vertex for processing by finding the min least distance among the vertices which are not included in msp
            for (int i = 0; i < v; i++) {
                if (!msp[i] && (u == -1 || key[i] < key[u]))
                    u = i;
            }

            msp[u] = true; // included in msp
            res += key[u];

            // for each adjacent vertex of candidate vertex update the key array with min distance
            for (int i = 0; i < v; i++) {
                if (!msp[i] && graph[u][i] != 0 && key[i] > graph[u][i])
                    key[i] = graph[u][i];
            }

        }

        System.out.println("result of msp is : " + res);

    }
}
