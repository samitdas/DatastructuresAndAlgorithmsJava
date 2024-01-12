package org.samit.practice.search;

/**
 * Given a sorted array of integers and a sum, find if there are any pair in the array equal to sum
 * given [2,5,12,18,20] and sum 23 the ans is (5,18)
 */
public class TwoPointerApproach {

    public static void main(String[] args) {
        int[] arr = {2, 5, 12, 18, 20};
        TwoPointerApproach tpa = new TwoPointerApproach();
        System.out.println("does pair exist for sum 23 : " + tpa.findPairs(arr,23));
    }

    /**
     * TC : O(n)
     * @param arr
     * @param sum
     * @return
     */
    private boolean findPairs(int[] arr, int sum) {
        int l = 0, h = arr.length - 1;

        while (l < h) {
            int val = arr[l] + arr[h];
            if (val == sum)
                return true;
            else if (val > sum)
                h--;
            else l++;
        }

        return false;
    }
}
