package org.samit.practice.trie;

public class TrieNode {

    private TrieNode[] child = new TrieNode[26];
    private boolean isEnd;

    public TrieNode[] getChild() {
        return child;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}
