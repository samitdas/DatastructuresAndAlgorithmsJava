package org.samit.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBuilder {

    public static TreeNode buildTree(int... vals) {
        TreeNode root = new TreeNode(vals[0]);
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int ctr = 1;
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if (ctr < vals.length) {
                TreeNode left = new TreeNode(vals[ctr++]);
                node.setLeft(left);
                queue.add(left);
            }
            if (ctr < vals.length) {
                TreeNode right = new TreeNode(vals[ctr++]);
                node.setRight(right);
                queue.add(right);
            }

            if (ctr == vals.length)
                break;
        }

        return root;
    }
}
