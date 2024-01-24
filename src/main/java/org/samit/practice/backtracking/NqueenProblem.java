package org.samit.practice.backtracking;

import java.util.Arrays;

/**
 * Given an N*N chessboard, place N queens such that no queens attack each other
 */
public class NqueenProblem {

    private static int[][] board = new int[4][4];
    private static int n = 4;

    public static void main(String[] args) {
        NqueenProblem nqp = new NqueenProblem();
        boolean res = nqp.solve();

        if (res) {
            nqp.printBoard();
        } else System.out.println("not solvable");
    }

    private static void printBoard() {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    private boolean solve() {
        if (solveRec(0))
            return true;
        else return false;
    }

    private boolean solveRec(int col) {

        if (col == n) return true;

        for (int i = 0; i < n; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;
                if (solveRec(col + 1))
                    return true;
                board[i][col] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(int row, int col) {

        // check in current row in previous columns
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1)
                return false;
        }

        // check upper diagonal of i,j
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // check lower diagonal of i,j
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }
        return true;
    }
}
