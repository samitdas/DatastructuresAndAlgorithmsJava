package org.samit.practice.segmenttree;

import java.util.Arrays;

/**
 * Segment tree is used when there is a mix of getSum ( over a range ) and update operations
 * Requires preprocessing of the array to create a Segment Tree ( an array like heap )
 * Size of the array is upper bounded by 4n  (n is number of elements in original array)
 * Stores sum of ranges at each index. Leaves are always single element of the original array
 * TC : O(Lg n) Aux : O(n)
 */
public class SegmentTreeConstruct {

    static int[] arr = {10, 20, 30, 40};
    static int[] segTree = new int[16];

    public static void main(String[] args) {
        SegmentTreeConstruct stc = new SegmentTreeConstruct();
        stc.construct(0, 3, 0);

        System.out.println("segment tree : " + Arrays.toString(segTree));
        System.out.println("sum of range 1,3 is : " + stc.getSum(1, 3, 0, 3, 0));

        stc.update(0, 3, 1, 0, 5);
        System.out.println("sum of range 1,3 is : " + stc.getSum(1, 3, 0, 3, 0));
    }

    private int construct(int ss, int se, int si) {
        if (ss == se) {
            segTree[si] = arr[ss];
            return segTree[si];
        }

        int mid = (ss + se) / 2;
        segTree[si] = construct(ss, mid, 2 * si + 1) + construct(mid + 1, se, 2 * si + 2);
        return segTree[si];
    }

    private int getSum(int qs, int qe, int ss, int se, int si) {

        if (qs > se || qe < ss) return 0;
        if (qs <= ss && qe >= se) return segTree[si];
        int mid = (ss + se) / 2;
        return getSum(qs, qe, ss, mid, 2 * si + 1) + getSum(qs, qe, mid + 1, se, 2 * si + 2);
    }


    private void update(int ss, int se, int i, int si, int diff) {
        if (i < ss || i > se) return;
        segTree[si] = segTree[si] + diff;

        if (se > ss) {
            int mid = (ss + se) / 2;
            update(ss, mid, i, 2 * si + 1, diff);
            update(mid + 1, se, i, 2 * si + 2, diff);
        }
    }
}
