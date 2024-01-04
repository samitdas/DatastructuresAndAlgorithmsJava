package org.samit.practice.dp;

import java.util.Arrays;

/**
 * Given an array of integers, find the length of the longest increasing subsequence
 * given [3,4,2,8,10,5,1] answer would be 4 ( [3,4,8,10] )
 */
public class LongestIncreasingSubsequence {

    private static int[] input = {3, 4, 2, 8, 10, 5, 1};

    //private static int[] input = {10,5,18,7,2,9};  ans : 3
    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println("lis value using dp solution : " + lis.lisDpSolution());
        System.out.println("lis value using binary search : " + lis.lisBinarySearchSolution());
    }

    /**
     * This is a DP based solution of Time Complexity Theta(n^2) and Aux space Theta(n)
     * Logic is to find the max lis ending with the current element while traversing the array
     * for an element at ith index, traverse left to right until index i-1 and find the max lis and update the lis array
     * Finally find the max element in the lis array and return
     *
     * @return
     */
    private int lisDpSolution() {
        int[] lis = new int[input.length];
        lis[0] = 1; // lis of the first element is always

        for (int i = 1; i < input.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (input[j] < input[i])
                    lis[i] = Math.max(lis[i], 1 + lis[j]); // Take max value of lis only when a smaller value is found
            }
        }

        // printing the lis array

        Arrays.stream(lis).forEach(e -> System.out.print(e + " "));
        System.out.println();
        int res = lis[0];
        for (int i = 1; i < input.length; i++) {
            res = Math.max(res, lis[i]);
        }
        return res;
    }

    /**
     * This uses binary search to find the lis and time complexity is O(nLgn)
     * Better than the above dp solution
     * tail array at index i contains minimum possible element for lis of length i+1
     *
     * @return
     */
    private int lisBinarySearchSolution() {
        int[] tail = new int[input.length];
        int tailIdx = 0;
        tail[tailIdx++] = input[0];

        for (int i = 1; i < input.length; i++) {
            if (input[i] > tail[tailIdx - 1]) {
                tail[tailIdx++] = input[i];
            } else {
                int idx = findCeiling(tail, input[i], 0, i);
                tail[idx] = input[i];
            }
        }

        return tailIdx;
    }

    private static int findCeiling(int[] tail, int val, int l, int h) {

        while (h > l) {
            int mid = l + (h - l) / 2;
            if (tail[mid] >= val) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }
}
