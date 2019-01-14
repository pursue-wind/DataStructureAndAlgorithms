package Trie;

import java.util.TreeMap;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 字典树, 前缀树
 * @author: mirrorming
 * @create: 2019-01-14 12:35
 **/

public class Trie {
    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * @Description: 获取Trie中单词的数量
     * @return: int
     */
    public int getSize() {
        return size;
    }

    /**
     * @Description: 向Trie中添加新单词word
     * @Param: [word]
     */
    public void add(String word) {
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
     * @Description: 查询Trie中是否包含Trie
     * @Param: [word]
     * @return: boolean
     */
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }
}