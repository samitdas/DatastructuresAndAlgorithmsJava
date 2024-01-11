package org.samit.practice.search;

/**
 * Given a number find square root. Answer can be floor ( for eg for 15 answer is 3)
 */
public class SquareRoot {
    public static void main(String[] args) {
        SquareRoot sr = new SquareRoot();
        System.out.println("square root of 25 : " + sr.naivesSoln(25));
        System.out.println("square root of 25 : " + sr.sqrtBinarySearch(25));
    }

    /**
     * TC : Theta (sqrt(n))
     *
     * @param n
     * @return
     */
    private int naivesSoln(int n) {
        int res = 1;
        while (res * res <= n) {
            res++;
        }

        return res - 1;
    }

    /**
     * Binary search based solution
     *
     * @param n
     * @return
     */
    private int sqrtBinarySearch(int n) {
        int l = 1, h = n, ans = -1;

        while (l <= h) {
            var mid = (l + h) / 2;
            var val = mid * mid;
            if (val == n)
                return mid;
            else if (val > n) {
                h = mid - 1;
            } else {
                l = mid + 1;
                ans = mid;
            }
        }

        return ans;
    }
}
