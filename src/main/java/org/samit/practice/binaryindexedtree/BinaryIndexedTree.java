package org.samit.practice.binaryindexedtree;

import java.util.Arrays;

/**
 * Binary Indexed Tree is essentially an array of size n+1 but conceptually is tree based like heap and segment tree
 * Uses the fact that every number can be represented as sum of power of 2
 * Stores sum of ranges in the array where each range is a power of 2
 * Used mainly for prefix ops (getSum, OR, XOR) and update ops
 * TC : O(Log n) , Aux Space : O(n)
 */
public class BinaryIndexedTree {

    static int[] arr = {10, 20, 30, 40, 50};
    static int[] bITree;

    public static void main(String[] args) {
        BinaryIndexedTree bit = new BinaryIndexedTree();
        bit.constructBiTree();
        bit.update(2, 35);

        System.out.println("arr : " + Arrays.toString(arr));
        System.out.println("binary indexed tree : " + Arrays.toString(bITree));
        System.out.println("sum of range 0,4 : " + bit.getSum(4));
    }

    private void update(int i, int x) {
        int diff = x - arr[i];
        arr[i] = x;
        i = i + 1;

        while (i < bITree.length) {
            bITree[i] += diff;
            i = i + i & (-i);
        }

    }

    private void constructBiTree() {
        int n = arr.length;
        bITree = new int[n + 1];

        for (int i = 0; i < n; i++) {
            updateForConstruct(i, arr[i]);
        }
    }

    private void updateForConstruct(int i, int x) {
        i = i + 1;
        while (i < bITree.length) {
            bITree[i] += x;
            i = i + i & (-i);
        }

    }

    private int getSum(int i) {
        i = i + 1;
        int res = 0;
        while (i > 0) {
            res += bITree[i];
            i = i - (i & (-i));
        }
        return res;
    }
}
