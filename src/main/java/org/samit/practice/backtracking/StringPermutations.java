package org.samit.practice.backtracking;

import java.util.Arrays;

public class StringPermutations {

    public static void main(String[] args) {
        char[] arr = {'A', 'B', 'C'};
        StringPermutations sp = new StringPermutations();
        sp.permute(arr, 0, arr.length);
    }

    private void permute(char[] str, int l, int r) {

        if (l == r) {
            System.out.println(Arrays.toString(str));
            return;
        }

        for (int i = l; i < r; i++) {

            swap(str, i, l);
            if (isSafe(str, l, r)) {
                permute(str, l + 1, r);
            }
            swap(str, i, l);

        }
    }

    private boolean isSafe(char[] str, int l, int r) {

        if (l != 0 && str[l - 1] == 'A' && str[l] == 'B')
            return false;
//        if (l + 1 == r && str[l - 1] == 'B' && str[l] == 'A')
//            return false;

        return true;
    }

    private static void swap(char[] arr, int i, int j) {
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }
}
