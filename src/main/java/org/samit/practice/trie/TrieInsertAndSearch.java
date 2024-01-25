package org.samit.practice.trie;

import java.util.stream.Stream;

public class TrieInsertAndSearch {

    public static void main(String[] args) {
        TrieInsertAndSearch tis = new TrieInsertAndSearch();
        TrieNode root = new TrieNode();
        Stream.of("abc","abcd", "rgf", "jkk", "yru", "vfr", "tye", "kjsf").forEach(e -> tis.insert(root, e));
        System.out.println("search abc result : " + tis.search(root, "abc"));
        System.out.println("search stc result : " + tis.search(root, "stc"));
        System.out.println("search abcd result : " + tis.search(root, "abcd"));
        tis.delete(root,"abcd",0);
        System.out.println("search abcd result : " + tis.search(root, "abcd"));
    }

    private void insert(TrieNode root, String str) {

        TrieNode curr = root;

        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (curr.getChild()[idx] == null) {
                curr.getChild()[idx] = new TrieNode();
            }
            curr = curr.getChild()[idx];
        }
        curr.setEnd(true);

    }

    private boolean search(TrieNode root, String str) {

        TrieNode curr = root;

        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (curr.getChild()[idx] == null) {
                return false;
            }
            curr = curr.getChild()[idx];
        }
        return curr.isEnd();

    }

    private TrieNode delete(TrieNode root, String str, int i) {
        if (root == null) return null;

        if (i == str.length()) {
            root.setEnd(false);

            if (isEmpty(root)) {
                root = null;
            }
            return root;
        }

        int idx = str.charAt(i) - 'a';

        root.getChild()[idx] = delete(root.getChild()[idx], str, i + 1);
        if (isEmpty(root) && !root.isEnd()) {
            root = null;
        }

        return root;

    }

    private boolean isEmpty(TrieNode node) {
        for (int i = 0; i < 26; i++) {
            if (node.getChild()[i] != null)
                return false;
        }

        return true;
    }
}
