package org.samit.practice.search;

/**
 * Given an unsorted array of integers find any peak element
 * peak element is one which is greater than its immediate neighbours
 * given [5, 20, 40, 30, 20, 50, 60] ans can be 40 or 60
 */
public class PeakElement {

    public static void main(String[] args) {
        int[] arr1 = {5, 20, 40, 30, 20, 50, 60};
        int[] arr2 = {7,7,7,7,7};
        int[] arr3 = {5, 4, 3, 2, 1};
        int[] arr4 = {1, 2, 3, 4, 5};
        int[] arr5 = {1, 5, 7, 15, 12, 4, 5, 18, 90};
        PeakElement pe = new PeakElement();
        System.out.println("peak element of arr1 : " + pe.peakElement(arr1));
        System.out.println("peak element of arr2 : " + pe.peakElement(arr2));
        System.out.println("peak element of arr3 : " + pe.peakElement(arr3));
        System.out.println("peak element of arr4 : " + pe.peakElement(arr4));
        System.out.println("peak element of arr5 : " + pe.peakElement(arr5));
    }

    private int peakElement(int[] arr) {

        int l = 0, h = arr.length - 1;

        while (l <= h) {

            var mid = (l + h) / 2;

            if (((mid == 0) && (arr[mid] >= arr[mid + 1])) ||
                    ((mid == arr.length - 1) && (arr[mid] >= arr[mid - 1])))
                return arr[mid];
            else if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1])
                return arr[mid];
            else if (arr[mid] < arr[mid - 1])
                h = mid - 1;
            else l = mid + 1;

        }

        return -1;
    }
}
