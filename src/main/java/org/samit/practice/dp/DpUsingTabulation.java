package org.samit.practice.dp;

/**
 * Tabulation based solution for nth fibonacci number
 * F(0) = 0, F(1) = 1, F(2) = 1, F(3) = 2 ....
 * This is a bottom up approach where lower values are filled first
 * Dimension of array depends on the number of varying params
 * Time complexity - Theta(n), Aus space - Theta(n)
 */
public class DpUsingTabulation {

    public static void main(String[] args) {
        DpUsingTabulation dpt = new DpUsingTabulation();
        int n = Integer.parseInt(args[0]);
        System.out.println("Answer : " + dpt.fibTabulation(n));
    }

    private int fibTabulation(int n) {
        int[] tab = new int[n + 1];
        tab[1] = 1; // base cases tab[0] is 0 and tab[1] is 1

        for (int i = 2; i < n + 1; i++) {
            tab[i] = tab[i - 1] + tab[i - 2];
        }

        return tab[n];
    }

}
