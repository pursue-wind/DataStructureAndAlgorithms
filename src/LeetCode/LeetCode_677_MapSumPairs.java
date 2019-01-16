package LeetCode;
/**
 * @program: DataStructureAndAlgorithms
 * @description: 677. 键值映射
 * @author: mirrorming
 * @create: 2018-01-16 19:47
 **/

import java.util.HashMap;

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
public class LeetCode_677_MapSumPairs {
    private class Node {
        public int value;
        public HashMap<Character, Node> next;

        public Node(int value) {
            this.value = value;
            this.next = new HashMap<>();
        }

        public Node() {
            this(0);
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public LeetCode_677_MapSumPairs() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return 0;
            cur = cur.next.get(c);
        }

        return sum(cur);
    }

    private int sum(Node node) {
        int res = node.value;
        for (char c : node.next.keySet())
            res += sum(node.next.get(c));
        return res;
    }
}