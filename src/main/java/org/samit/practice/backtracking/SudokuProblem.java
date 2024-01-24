package org.samit.practice.backtracking;

import java.util.Arrays;

public class SudokuProblem {

    private static int[][] grid = new int[4][4];
    private static int n = 4;

    public static void main(String[] args) {
        grid = new int[][]{{1, 0, 3, 4},
                {0, 0, 2, 1},
                {0, 1, 4, 2},
                {2, 4, 1, 0}};
        SudokuProblem sp = new SudokuProblem();
        boolean result = sp.solve();
        if (result) {
            sp.printGrid();
        } else System.out.println("Sudoku not solvable");
    }

    private void printGrid() {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }

    private boolean solve() {
        int i, j = 0;

        for (i = 0; i < n; i++) {
            boolean isEmpty = false;
            for (j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    isEmpty = true;
                    break;
                }

            }
            if (isEmpty)
                break;
        }

        if (i == n && j == n) return true;

        for (int x = 1; x <= n; x++) {
            if (isSafe(i, j, x)) {
                grid[i][j] = x;
                if (solve() == true) return true;
                grid[i][j] = 0;
            }
        }

        return false;
    }

    private boolean isSafe(int i, int j, int val) {

        for (int k = 0; k < n; k++) {
            if (grid[k][j] == val || grid[i][k] == val)
                return false;
        }

        int s = (int) Math.sqrt(n);
        int rs = i - i % s;
        int cs = j - j % s;

        for (int m = 0; m < s; m++) {
            for (int n = 0; n < s; n++) {
                if (grid[m + rs][n + cs] == val)
                    return false;
            }
        }

        return true;

    }
}
