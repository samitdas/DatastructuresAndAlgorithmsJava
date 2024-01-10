package org.samit.practice.search;

/**
 * Makes use of the fact that array is sorted
 * Find mid point and compare the value and adjust low and high index accordingly
 * Skips one half entirely hence Time Complexity is O(Log n)
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        BinarySearch bs = new BinarySearch();
        System.out.println("iterative : index of 0 : " + bs.iterative(arr, 0));
        System.out.println("iterative : index of 40 : " + bs.iterative(arr, 40));

        System.out.println("recursive : index of 0 : " + bs.recursive(arr, 0, arr.length - 1, 0));
        System.out.println("recursive : index of 40 : " + bs.recursive(arr, 0, arr.length - 1, 40));
    }

    private int iterative(int[] arr, int val) {
        // local var jdk11
        var l = 0;
        var h = arr.length - 1;

        while (l <= h) {
            var mid = (l + h) / 2;
            if (arr[mid] == val) {
                return mid;
            } else if (arr[mid] < val) {
                l = mid + 1;
            } else h = mid - 1;
        }

        return -1;
    }

    private int recursive(int[] arr, int l, int h, int val) {
        if (l > h) return -1;

        var mid = (l + h) / 2;

        if (arr[mid] == val) return mid;
        else if (arr[mid] < val) return recursive(arr, mid + 1, h, val);
        else return recursive(arr, l, mid - 1, val);
    }
}
