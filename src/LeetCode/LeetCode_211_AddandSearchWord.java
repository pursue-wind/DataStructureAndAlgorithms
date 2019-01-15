package LeetCode;

import java.util.*;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 211. 添加与搜索单词 - 数据结构设计
 * @author: mirrorming
 * @create: 2019-01-15 13:06
 **/

public class LeetCode_211_AddandSearchWord {

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

    public LeetCode_211_AddandSearchWord() {
        this.root = new Node();
    }

    /**
     * @Description: 添加单词
     * @Param: [word]
     */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    /**
     * @Description: 搜索单词
     * @Param: [word]
     * @return: boolean
     */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    /**
     * @Description: 搜索_递归
     * @Param: [node, word, index]
     * @return: boolean
     */
    private boolean match(Node node, String word, int index) {
        //  程序出口, word遍历完成
        if (index == word.length())
            return node.isWord;
        char c = word.charAt(index);
        if (c != '.') {
            if (node.next.get(c) == null)
                return false;
            return match(node.next.get(c), word, index + 1);
        }
        //  如果是.则匹配下一个节点下面的所有节点
        else {
            for (char nextChar : node.next.keySet())
                //  如果有匹配成功的, 则true
                if (match(node.next.get(nextChar), word, index + 1))
                    return true;
            return false;
        }
    }
}