package org.samit.practice.dp;

public class AllocatePages {

    public static void main(String[] args) {
        AllocatePages ap = new AllocatePages();
        System.out.println("result with recursive solution : " + ap.pagesRecursive(new int[]{10, 30, 5, 20}, 4, 2));
        System.out.println("result with dp solution : " + ap.pagesDp(new int[]{10, 30, 5, 20}, 2));
    }

    private int pagesRecursive(int[] b, int l, int n) {
        if (n == 1) return sum(b, 0, l);
        if (l == 1) return b[0];

        int res = Integer.MAX_VALUE;

        for (int i = l - 1; i >= 0; i--) { // can traverse from left to right as well
            res = Math.min(res, Math.max(pagesRecursive(b, i, n - 1), sum(b, i, l)));
        }

        return res;
    }

    private static int sum(int[] arr, int k, int l) {
        int sum = 0;
        for (int i = k; i < l; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * dp[i][j] holds the result for i students and j books
     *
     * @param b
     * @param p
     * @return
     */
    private int pagesDp(int[] b, int p) {
        int n = b.length; // number of books
        int[][] dp = new int[p + 1][n + 1];// extra for dummy columns

        // fill base case 1 (i.e. when number of students is 1 he reads all available books
        for (int j = 1; j < n + 1; j++) {
            dp[1][j] = sum(b, 0, j);
        }

        // when there is only 1 book to read
        for (int i = 1; i < p + 1; i++) {
            dp[i][1] = b[0];
        }

        for (int i = 2; i < p + 1; i++) {
            for (int j = 2; j < n + 1; j++) {
                int res = Integer.MAX_VALUE;
                for (int x = 1; x < j; x++) {
                    res = Math.min(res, Math.max(dp[i - 1][x], sum(b, x, j)));
                }

                dp[i][j] = res;
            }
        }

        return dp[p][n];
    }
}
