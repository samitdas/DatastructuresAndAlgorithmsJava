package org.samit.practice.dp;

/**
 * Minimum number of operations required to convert given string s1 to another string s2
 */
public class EditDistanceProblem {
    public static void main(String[] args) {
        String s1 = "JULY";
        String s2 = "JUNE";

        EditDistanceProblem edp = new EditDistanceProblem();
        System.out.println("Minimum operations using recursive solution : " + edp.editDistanceRecursive(s1, s2, s1.length(), s2.length()));
        System.out.println("Minimum operations using dp solution : " + edp.editDistanceDpSolution(s1, s2));
    }

    private static int findMin(int a, int b, int c) {
        int temp = a;
        if (a > b)
            temp = b;
        return Math.min(temp, c);
    }

    private int editDistanceRecursive(String s1, String s2, int m, int n) {

        if (m == 0) return n; // i.e. add all characters left in S2 for match
        if (n == 0) return m; // i.e. delete all characters left in S1 for match

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return editDistanceRecursive(s1, s2, m - 1, n - 1);
        else
            //     1 operation added because ( add op, delete op , update op)
            return 1 + findMin(editDistanceRecursive(s1, s2, m, n - 1), editDistanceRecursive(s1, s2, m - 1, n), editDistanceRecursive(s1, s2, m - 1, n - 1));
    }

    /**
     * tab[i][j] denotes edit distance value for s1 of length i <=m and s2 of length j<= n
     * @param s1
     * @param s2
     * @return
     */
    private int editDistanceDpSolution(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] tab = new int[m + 1][n + 1];

        //init the base cases
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    tab[0][j] = j;
                if (j == 0)
                    tab[i][0] = i;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
               if(s1.charAt(i-1) == s2.charAt(j-1)){
                   tab[i][j] = tab[i-1][j-1];
               }else{
                   tab[i][j] = 1 + findMin(tab[i][j-1],tab[i-1][j],tab[i-1][j-1]);
               }
            }
        }

        return tab[m][n];


    }

}
