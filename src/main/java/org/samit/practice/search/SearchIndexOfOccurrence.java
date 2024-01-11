package org.samit.practice.search;

/**
 * Given a sorted array find the index of first and last occurrence of a given value
 * The array may have duplicates. If not present then return -1
 */
public class SearchIndexOfOccurrence {

    public static void main(String[] args) {
        int[] arr = {10, 10, 20, 30, 30, 30, 40, 50};
        SearchIndexOfOccurrence bs = new SearchIndexOfOccurrence();
        System.out.println("first index of 0 : " + bs.firstOccurrence(arr, 0));
        System.out.println("first index of 30 : " + bs.firstOccurrence(arr, 30));
        System.out.println("last index of 30 : " + bs.lastOccurrence(arr, 30));

        System.out.println("last index of 0 : " + bs.lastOccurrence(arr, 0));
        System.out.println("last index of 40 : " + bs.lastOccurrence(arr, 40));
        System.out.println("first index of 40 : " + bs.firstOccurrence(arr, 40));
        System.out.println("last index of 10 : " + bs.lastOccurrence(arr, 10));
    }

    private int firstOccurrence(int[] arr, int val) {
        var l = 0;
        var h = arr.length - 1;

        while (l <= h) {
            var mid = (l + h) / 2;
            if (arr[mid] == val) {
                {
                    while (arr[mid] == val) {
                        mid--;
                    }
                    return mid + 1;
                }
            } else if (arr[mid] < val) {
                l = mid + 1;
            } else h = mid - 1;
        }

        return -1;
    }

    private int lastOccurrence(int[] arr, int val) {
        var l = 0;
        var h = arr.length - 1;

        while (l <= h) {
            var mid = (l + h) / 2;
            if (arr[mid] == val) {
                {
                    while (arr[mid] == val) {
                        mid++;
                    }
                    return mid - 1;
                }
            } else if (arr[mid] < val) {
                l = mid + 1;
            } else h = mid - 1;
        }

        return -1;
    }
}
