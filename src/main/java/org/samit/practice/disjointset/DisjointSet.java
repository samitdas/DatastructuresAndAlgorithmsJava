package org.samit.practice.disjointset;

import java.util.Arrays;

/**
 * This data structure is used mainly for representing social network
 * This has time complexity of m*alpha(n) for m operations on n elements where alpha(n) <= 4
 * Union joins 2 elements and find gets the representative of a disjoint set
 * All elements in a disjoint have a common representative
 * This is denoted by tree structure in a Forrest
 */
public class DisjointSet {

    static int[] parent = new int[5];
    static int[] rank = new int[5];

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            parent[i] = i;
        DisjointSet djs = new DisjointSet();
        djs.unionByRank(3,4);
        djs.unionByRank(2, 3);
        djs.unionByRank(1, 2);
        djs.unionByRank(0, 1);
        System.out.println("djs : " + Arrays.toString(parent));
        System.out.println("finding 1 : " + djs.find(1));
        System.out.println("finding 2 : " + djs.find(2));
        System.out.println("finding 4 : " + djs.find(4));
        System.out.println("rank array : " + Arrays.toString(rank));
    }

    private int find(int x) {
        if (parent[x] == x)
            return x; // reached the root node where parent is itself
        else return find(parent[x]);
    }

    private void union(int x, int y) {

        int xRep = find(x);
        int yRep = find(y);

        if (xRep == yRep) return;
        parent[yRep] = xRep;

    }

    /**
     * For optimization so that tree height does not grow linearly while doing union
     * Find the 2 reps and make the rep with higher rank as parent of lower rank rep
     *
     * @param x
     * @param y
     */
    private void unionByRank(int x, int y) {

        int xRep = find(x);
        int yRep = find(y);

        if (xRep == yRep) return;

        if (rank[xRep] > rank[yRep]) parent[yRep] = xRep;
        else if (rank[yRep] > rank[xRep]) parent[xRep] = yRep;
        else {
            parent[yRep] = xRep;
            rank[xRep]++;
        }
    }


    /**
     * Compresses the path after traversal and might reduce height of the tree therefore making find operation logarithmic time
     * @param x
     * @return
     */
    private int findByPathCompression(int x){

        if(parent[x] == x)
            return x;

        parent[x] = findByPathCompression(parent[x]);
        return parent[x];
    }
}
