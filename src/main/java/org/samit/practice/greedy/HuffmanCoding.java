package org.samit.practice.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Variable length lossless compression algorithm
 * Greedy approach is the use of frequency, wherein the highest frequency char will have longest code
 */
public class HuffmanCoding {

    public static void main(String[] args) {
        HuffmanCoding hc = new HuffmanCoding();
        hc.huffmanCode(new char[]{'a', 'd', 'e', 'f'}, new int[]{30, 40, 80, 60});
    }

    /**
     * Use a min heap to store the frequencies and then build a binary tree with the character frequencies as leaf nodes
     * and sum of there frequencies as internal nodes
     * Do a pre-order tree traversal and assign 0 for left and 1 for right
     * @param arr
     * @param frequency
     */
    private void huffmanCode(char[] arr, int[] frequency) {

        Queue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n.freq));

        for (int i = 0; i < arr.length; i++) {
            heap.add(new Node(arr[i], frequency[i], null, null));
        }

        heap.stream().forEach(e -> System.out.println(e.ch));

        while (heap.size() > 1) {
            Node l = heap.poll();
            Node r = heap.poll();
            heap.add(new Node('$', l.freq + r.freq, l, r));
        }

        printRec(heap.peek(), "");

    }

    private void printRec(Node root, String s) {

        if(root.ch != '$'){
            System.out.println(root.ch + " : " + s);
            return;
        }

        printRec(root.left, s+ "0");
        printRec(root.right, s+ "1");

    }

    /**
     * Node of the Huffman Binary Tree
     */
    private static class Node {
        char ch;
        int freq;
        Node left;
        Node right;

        public Node(char c, int f, Node l, Node r) {
            this.ch = c;
            this.freq = f;
            this.left = l;
            this.right = r;
        }
    }
}
