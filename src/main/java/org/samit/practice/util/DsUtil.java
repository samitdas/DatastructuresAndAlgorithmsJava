package org.samit.practice.util;

public class DsUtil {

    public static int findMin(int a, int b, int c) {
        int temp = a;
        if (a > b)
            temp = b;
        return Math.min(temp, c);
    }

    public static int findMax(int a, int b, int c) {
        int temp = a;
        if (a < b)
            temp = b;
        return Math.max(temp, c);
    }
}
