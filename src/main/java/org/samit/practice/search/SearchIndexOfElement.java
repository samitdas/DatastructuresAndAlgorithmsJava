package org.samit.practice.search;

import java.util.stream.IntStream;

/**
 * Given an infinite sized sorted array of integers find the position of a given value
 */
public class SearchIndexOfElement {

    public static void main(String[] args) {
        SearchIndexOfElement sie = new SearchIndexOfElement();
        int[] ints = IntStream.range(0, 100000).map(x -> x * 2).toArray(); // high range to simulate infinite
        System.out.println("index of 10 (naive search): " + sie.naiveSolution(ints, 10));
        System.out.println("index of 11 (naive search): " + sie.naiveSolution(ints, 11));

        System.out.println("index of 10 (binary search): " + sie.binarySearch(ints, 10));
        System.out.println("index of 11 (binary search): " + sie.binarySearch(ints, 11));
    }

    /**
     * TC : O(position)
     *
     * @param arr
     * @param n
     * @return
     */
    private int naiveSolution(int[] arr, int n) {
        int res = 0;

        while (true) {
            if (arr[res] == n) return res;
            if (arr[res] > n) return -1;
            res++;
        }
    }

    /**
     * TC : O(Log n)
     * @param arr
     * @param n
     * @return
     */
    private int binarySearch(int[] arr, int n) {

        if (arr[0] == n) return 0;

        int x = 1;
        while (arr[x] < n)
            x = x * 2;

        if (arr[x] == n) return x;
        else
            return new BinarySearch().recursive(arr, x / 2 + 1, x , n);
    }
}
