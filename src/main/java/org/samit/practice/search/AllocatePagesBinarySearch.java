package org.samit.practice.search;

/**
 * Given an array of number of pages for each book and number of students to read
 * find the minimum of the maximum pages read by a student
 * A student can only read contiguous books
 */
public class AllocatePagesBinarySearch {

    public static void main(String[] args) {
        AllocatePagesBinarySearch apb = new AllocatePagesBinarySearch();
        System.out.println("result with binary search solution : " + apb.allocatePagesBinarySearch(new int[]{10, 20, 30, 40}, 2));
    }

    private static boolean isFeasible(int[] books, int p, int val) {
        int n = books.length;
        int sum = 0;
        int req = 1;
        for (int i = 0; i < n; i++) {
            if (sum + books[i] > val) {
                req++;
                sum = books[i];
            } else {
                sum += books[i];
            }
        }

        return req <= p;
    }

    /**
     * Find the sum of pages and the max pages in the array. Result has to be within the range (max,sum)
     * Do binary search based on feasibility and adjust the lower or upper limit accordingly
     *
     * @param books
     * @param p
     * @return
     */
    private int allocatePagesBinarySearch(int[] books, int p) {

        int sum = 0, max = 0;

        for (int i = 0; i < books.length; i++) {
            sum += books[i];
            max = Math.max(max, books[i]);
        }

        int l = max, h = sum, res = 0;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (isFeasible(books, p, mid)) {
                res = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }
}
