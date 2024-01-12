package org.samit.practice.search;

/**
 * given 2 sorted arrays of size n1 and n2 such that n1 <= n2 (assumption for simplicity)
 * find the median of the combined sorted array
 * in case of even elements median is average of middle 2 elements, else just the middle element in case of odd elements
 * Time Complexity : O(Log n1)
 * Median in an array is the element which divides the array in 2 equal halves where left side has all smaller elements
 * and right side has all greater elements
 */
public class Median {

    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30, 40};
        int[] arr2 = {2, 4, 6, 8, 10, 19};
        Median median = new Median();
        System.out.println("Median : " + median.findMedian(arr1, arr2));
    }

    /**
     * do binary search on array1 and adjust the pointers accordingly
     *
     * @param arr1
     * @param arr2
     * @return
     */
    private double findMedian(int[] arr1, int[] arr2) {
        int begin = 0, end = arr1.length; // assumption that arr1 is length <= length of arr2
        int n1 = arr1.length, n2 = arr2.length;
        while (begin <= end) {
            int i1 = (begin + end) / 2;
            int i2 = (n1 + n2) / 2 - i1;

            int max1 = (i1 == 0) ? Integer.MIN_VALUE : arr1[i1 - 1]; // max value in left side of arr1
            int min1 = (i1 == n1) ? Integer.MAX_VALUE : arr1[i1]; // min value in right side of arr1
            int max2 = (i2 == 0) ? Integer.MIN_VALUE : arr2[i2 - 1]; // max value in left side of arr2
            int min2 = (i1 == n2) ? Integer.MAX_VALUE : arr2[i2]; // max value in right side of arr2

            if (max1 <= min2 && max2 <= min1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(max1, max2) + Math.min(min1, min2)) / 2;
                } else return Math.max(max1, max2);
            } else if (max1 > min2)
                end = i1 - 1;
            else begin = i1 + 1;

        }

        return -1;
    }
}
