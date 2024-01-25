package org.samit.practice.trie;

public class CountDistinctRowsInBinaryMatrix {

    private static int[][] matrix = {{1, 0, 0},
            {1, 1, 1},
            {1, 0, 0},
            {1, 1, 1}};

    public static void main(String[] args) {
        CountDistinctRowsInBinaryMatrix cos = new CountDistinctRowsInBinaryMatrix();
        System.out.println("distinct rows of given matrix : " + cos.countDistinct());
    }

    private boolean insert(TrieBinaryNode root, int[] row) {
        boolean flag = false;
        TrieBinaryNode curr = root;
        for (int i = 0; i < row.length; i++) {
            int idx = row[i];
            if (curr.getNode()[idx] == null) {
                curr.getNode()[idx] = new TrieBinaryNode();
                flag = true;
            }
            curr = curr.getNode()[idx];
        }
        return flag;
    }

    private int countDistinct() {
        TrieBinaryNode root = new TrieBinaryNode();
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (insert(root, matrix[i]))
                res++;
        }

        return res;
    }

    private static class TrieBinaryNode {
        TrieBinaryNode[] node = new TrieBinaryNode[2];

        public TrieBinaryNode[] getNode() {
            return node;
        }
    }
}
