package org.samit.practice.dp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Longest Common Subsequence - Given 2 strings find the longest common subsequence
 * What is a subsequence - give a string "abc" , there can be 8 subsequence ( 2^l (l - length of string) )
 * subsequences always maintain order but may not be contiguous - "", "a", "b", "c", "ab", "ac", "bc", "abc"
 */
public class Lcs {

    private static int[][] memo; // 2-dimensional array for memoization as there are 2 varying params ( m , n )
    private static int[][] tab; // 2-dimensional array for tabulation as there are 2 varying params ( m , n )

    public static void main(String[] args) {
        Lcs lcs = new Lcs();
        String first = "abcdgh";
        String second = "dbcag";
        int res = lcs.recursiveSolution(first, second, first.length(), second.length());
        System.out.println("LCS value is : " + res); // answer should be 3 ("bcg")

        //memoization based solution
        //init memo array with -1
        memo = new int[first.length() + 1][second.length() + 1];
        for (int i = 0; i < first.length() + 1; i++) {
            for (int j = 0; j < second.length() + 1; j++) {
                memo[i][j] = -1;
            }
        }

        int memoRes = lcs.lcsMemoization(first, second, first.length(), second.length());
        System.out.println("LCS value using memoization is : " + memoRes); // answer should be 3 ("bcg")

        // tabulation based solution
        int tabRes = lcs.lcsTabulation(first, second); // answer should be 3 ("bcg")
        System.out.println("LCS value using tabulation is : " + tabRes);
        lcs.printLcs(first, second);

    }

    /**
     * Assumption - not given string is null
     * Time complexity - exponential
     *
     * @param s1
     * @param s2
     * @param m
     * @param n
     * @return
     */
    private int recursiveSolution(String s1, String s2, int m, int n) {

        if (s1.equalsIgnoreCase(s2))
            return s1.length();

        if (m == 0 || n == 0)
            return 0;

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return 1 + recursiveSolution(s1, s2, m - 1, n - 1);
        else
            return Math.max(recursiveSolution(s1, s2, m - 1, n), recursiveSolution(s1, s2, m, n - 1));

    }

    /**
     * Time complexity : Theta(m*n)
     *
     * @param s1
     * @param s2
     * @param m
     * @param n
     * @return
     */
    private int lcsMemoization(String s1, String s2, int m, int n) {
        if (memo[m][n] != -1)
            return memo[m][n];

        if (m == 0 || n == 0)
            memo[m][n] = 0;
        else {
            if (s1.charAt(m - 1) == s2.charAt(n - 1))
                memo[m][n] = 1 + lcsMemoization(s1, s2, m - 1, n - 1);
            else
                memo[m][n] = Math.max(lcsMemoization(s1, s2, m - 1, n), lcsMemoization(s1, s2, m, n - 1));
        }

        return memo[m][n];
    }

    /**
     * Tabulation based solution using matrix of m+1 * n+1
     * A random cell ( tab[i][j] ) contains lcs result of s1 with length i<=m and s2 of length j<=n
     *
     * @param s1
     * @param s2
     * @return
     */
    private int lcsTabulation(String s1, String s2) {
        // tabulation based solution
        tab = new int[s1.length() + 1][s2.length() + 1];

        // start form index 1,1 as 0 is filled in the first row and first column for base cases ( either m=0 or n=0 )
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    tab[i][j] = 1 + tab[i - 1][j - 1]; // take the diagonal
                else
                    tab[i][j] = Math.max(tab[i][j - 1], tab[i - 1][j]); // take max of immediate left and immediate top
            }
        }

        return tab[s1.length()][s2.length()];
    }

    private void printLcs(String s1, String s2) {
        // matrix sizes
        int m = s1.length();
        int n = s2.length();

        Deque<Character> deque = new ArrayDeque<>();

        // start from the index tab[m][n]

        while (m != 0 && n != 0) {
            if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                deque.push(s1.charAt(m - 1));
                m--;
                n--; // go upward diagonally
            } else {
                if (tab[m][n - 1] > tab[m - 1][n])
                    n--;
                else m--;
            }
        }

        while (!deque.isEmpty()) {
            System.out.print(deque.pop());
        }

    }
}
