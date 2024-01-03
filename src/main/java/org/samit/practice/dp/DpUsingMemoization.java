package org.samit.practice.dp;

/**
 * Finding nth fibonacci number using memoization
 * has 2 methods - recursive solution and other with memoization
 */
public class DpUsingMemoization {

    private static int[] mem;

    public static void main(String[] args) {
        DpUsingMemoization dpUsingMemoization = new DpUsingMemoization();
        int n = Integer.parseInt(args[0]);
        System.out.println("using recursive solution : " + dpUsingMemoization.fibonacciRecursive(n));
        mem = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            mem[i] = -1;
        }
        System.out.println("using dp : " + dpUsingMemoization.fibMemoization(n));
    }

    private int fibonacciRecursive(int n) {
        if (n == 0 || n == 1)
            return n;
        else return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    private int fibMemoization(int n) {
        if (mem[n] == -1) {
            int res;
            if (n == 0 || n == 1)
                res = n;
            else
                res = fibMemoization(n - 1) + fibMemoization(n - 2);
            mem[n] = res;

        }
        return mem[n];
    }

}
