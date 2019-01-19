package AVL;

import java.util.*;

/**
 * @program: DataStructureAndAlgorithms
 * @description: AVL树
 * @author: mirrorming
 * @create: 2019-01-19 10:59
 **/

public class AVLTree<K extends Comparable<K>, V> {
    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @Description: 返回AVLTree节点的高度
     * @Param: [node]
     * @return: int
     */
    private int getHeight(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    /**
     * @Description: 返回节点的平衡因子
     * @Param: [node]
     * @return: int
     */
    private int getBalanceFactor(Node node) {
        if (node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
     * @Description: 返回以node为根节点的AVLTree中，key所在的节点
     * @Param: [node, key]
     * @return: Node
     */
    private Node getNode(Node node, K key) {
        if (node == null)
            return null;
        if (key.equals(node.key))
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else    //key.compareTo(node.key) > 0
            return getNode(node.right, key);
    }

    /**
     * @Description: 判断AVLTree中是否包含key
     * @Param: [e]
     * @return: boolean
     */
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    /**
     * @Description: 向AVLTree中添加元素
     * @Param: [key, value]
     */
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * @Description: 向以node为根的AVLTree中插入元素(key, value)，递归算法
     * @Param: [node, key, value]
     * @return: Node 返回插入新节点后AVLTree的根
     */
    public Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if (key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else    //key.compareTo(node.key) = 0
            node.value = value;

        //  更新高度
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        //  计算平衡因子
        int banlanceFactor = getBalanceFactor(node);
        if (Math.abs(banlanceFactor) > 1)
            System.out.println("不平衡:" + banlanceFactor);

        return node;
    }

    /**
     * @Description: 返回AVLTree中key值对应的value
     * @Param: [key]
     * @return: V
     */
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    /**
     * @Description: 更新AVLTree中的value
     * @Param: [key, newValue]
     */
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + "doesn't exist~");
        node.value = newValue;
    }

    /**
     * @Description: 判断该二叉树是否是一棵二分搜索树
     * @return: boolean
     */
    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root);
        for (int i = 1; i < keys.size(); i++)
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0)
                return false;
        return true;
    }

    /**
     * @Description: 辅助函数
     * @Param: [node, list]
     */
    private void inOrder(Node node, List list) {
        if (node == null)
            return;
        inOrder(node.left);
        list.add(node.key);
        inOrder(node.right);
    }

    /**
     * @Description: 判断该二叉树是否是一棵平衡二叉树
     * @return: boolean
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }

    /**
     * @Description: 判断以Node为根的二叉树是否是一棵平衡二叉树，递归算法
     * @Param: [node]
     * @return: boolean
     */
    private boolean isBalanced(Node node) {

        if (node == null)
            return true;

        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1)
            return false;
        return isBalanced(node.left) && isBalanced(node.right);
    }

    /**
     * @Description: 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * @Description: 前序遍历非递归实现
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.value);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    /**
     * @Description: 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    /**
     * @Description: 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    /**
     * @Description: 层序遍历
     */

    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.value);
            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuffer res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.key + " : " + node.value + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    /**
     * @Description: 生成深度
     * @Param: [depth]
     * @return: java.lang.String
     */
    private String generateDepthString(int depth) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }
}