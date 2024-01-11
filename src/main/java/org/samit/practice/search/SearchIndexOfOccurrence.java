package org.samit.practice.search;

/**
 * Given a sorted array find the index of first and last occurrence of a given value
 * The array may have duplicates. If not present then return -1
 * TC : O(Log n) and Aux Space O(1)
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
        System.out.println("first index of 10 : " + bs.firstOccurrence(arr, 10));
        System.out.println("last index of 50 : " + bs.firstOccurrence(arr, 50));
    }

    protected int firstOccurrence(int[] arr, int val) {
        var l = 0;
        var h = arr.length - 1;

        while (l <= h) {
            var mid = (l + h) / 2;

            if (arr[mid] < val) {
                l = mid + 1;
            } else if (arr[mid] > val) {
                h = mid - 1;
            } else {
                if (arr[mid] == val && (mid-1 < 0 || arr[mid - 1] != val)) {
                    return mid;
                } else {
                    h = mid - 1;
                }
            }
        }

        return -1;
    }

    protected int lastOccurrence(int[] arr, int val) {
        var l = 0;
        var h = arr.length - 1;

        while (l <= h) {
            var mid = (l + h) / 2;
            if (arr[mid] < val) {
                l = mid + 1;
            } else if (arr[mid] > val) {
                h = mid - 1;
            } else {
                if (arr[mid] == val && (mid+1 > arr.length-1 || arr[mid + 1] != val))
                    return mid;
                else l = mid + 1;
            }
        }

        return -1;
    }
}
