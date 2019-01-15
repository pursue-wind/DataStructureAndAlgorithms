package LeetCode;

import java.util.HashMap;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 208. 实现 Trie (前缀树)
 * @author: mirrorming
 * @create: 2019-01-15 12:23
 **/

public class LeetCode_208_ImplementTrie_PrefixTree {

    private class Node {
        public boolean isWord;
        public HashMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public LeetCode_208_ImplementTrie_PrefixTree() {
        this.root = new Node(false);
        size = 0;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node cur = root;    //定义root为当前节点
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
