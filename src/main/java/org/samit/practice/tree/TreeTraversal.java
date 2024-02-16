package org.samit.practice.tree;

/**
 * Given a binary tree do the following
 * Inorder traversal ( left root right)
 * PreOrder ( root left right )
 * PostOrder ( left right root )
 *
 * Above are all depth first
 * Traversal can be done breadth first as well where queue would be used to print a level and proceed
 *
 * This is on a Binary Tree ( at max 2 child nodes for a given internal node or root)
 */
public class TreeTraversal {


    public static void main(String[] args) {

        TreeNode root = TreeBuilder.buildTree(10,20,30,40,50);
        TreeTraversal traversal = new TreeTraversal();

        System.out.println("inorder traversal : ");
        traversal.inOrderTraversal(root);

        System.out.println("preOrder traversal : ");
        traversal.preOrderTraversal(root);

        System.out.println("postOrder traversal : ");
        traversal.postOrderTraversal(root);

        System.out.println("height : " + traversal.height(root));

    }

    /**
     * inOrder : left root right
     * @param node
     */
    private void inOrderTraversal(TreeNode node){
        if(node != null){
            inOrderTraversal(node.getLeft());
            System.out.println(node.getVal());
            inOrderTraversal(node.getRight());
        }
    }

    /**
     * preOrder : root left right
     * @param node
     */
    private void preOrderTraversal(TreeNode node){
        if(node != null){
            System.out.println(node.getVal());
            preOrderTraversal(node.getLeft());
            preOrderTraversal(node.getRight());
        }
    }

    /**
     * postOrder : left right root
     * @param node
     */
    private void postOrderTraversal(TreeNode node){
        if(node != null){
            postOrderTraversal(node.getLeft());
            postOrderTraversal(node.getRight());
            System.out.println(node.getVal());
        }
    }

    private int height(TreeNode node){
        if(node == null)
            return 0;
        else return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
    }


}
