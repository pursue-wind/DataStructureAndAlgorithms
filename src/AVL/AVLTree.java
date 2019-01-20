package AVL;

import java.time.Year;
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

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Node{");
            sb.append("key=").append(key);
            sb.append(", value=").append(value);
            sb.append(", left=").append(left);
            sb.append(", right=").append(right);
            sb.append(", height=").append(height);
            sb.append('}');
            return sb.toString();
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
        else   //key.compareTo(node.key) > 0
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

    /////////////////////////////////////////////////////
    //     对节点y进行向右旋转操作，返回旋转后新的根节点x    //
    //        y                              x         //
    //       / \                           /   \       //
    //      x   T4     向右旋转 (y)        z     y      //
    //     / \       - - - - - - - ->    / \   / \     //
    //    z   T3                       T1  T2 T3 T4    //
    //   / \                                           //
    // T1   T2                                         //
    /////////////////////////////////////////////////////
    private Node rightRotate(Node y) {
        //  暂存y的左节点x和x的右节点t3
        Node x = y.left;
        Node t3 = x.right;
        //  让y成为x的右孩子, t3成为y的左孩子
        x.right = y;
        y.left = t3;
        //  更新Height值
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    //////////////////////////////////////////////////
    // 对节点y进行向左旋转操作，返回旋转后新的根节点x    //
    //    y                             x          //
    //  /  \                          /   \        //
    // T1   x      向左旋转 (y)       y     z       //
    //     / \   - - - - - - - ->   / \   / \      //
    //   T2   z                    T1 T2 T3 T4     //
    //       / \                                   //
    //      T3 T4                                  //
    /////////////////////////////////////////////////
    private Node leftRotate(Node y) {
        //  暂存y的左节点x和x的左孩子t2
        Node x = y.right;
        Node t2 = x.left;
        //  让y成为x的左孩子, t2成为y的右孩子
        x.left = y;
        y.right = t2;
        //  更新Height值
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
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
        else   //key.compareTo(node.key) = 0
            node.value = value;

        //  更新高度
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        //  计算平衡因子
        int banlanceFactor = getBalanceFactor(node);

        if (Math.abs(banlanceFactor) > 2)
            System.out.println("不平衡:" + banlanceFactor);

        //  平衡维护:分为四种情况
        //  LL
        if (banlanceFactor > 1 && getBalanceFactor(node.left) >= 0)
            return rightRotate(node);

        //  RR
        if (banlanceFactor < -1 && getBalanceFactor(node.right) <= 0)
            return leftRotate(node);

        /////////////////////////////////////////////////////
        //------------------------LR------------------------|
        //                                                  |
        // 对节点x先进行左旋转即转换成LL情况,再对y进行右旋转即可  |
        //        y                              y          |
        //       / \                           /   \        |
        //      x   T4     向左旋转 (x)        z    T4       |
        //     / \       - - - - - - - ->    / \            |
        //    T1  z                         x  T3           |
        //       / \                       / \              |
        //      T2 T3                     T1 T2             |
        //                                                  |
        //------------------------LR------------------------|
        /////////////////////////////////////////////////////
        if (banlanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        /////////////////////////////////////////////////////
        //------------------------RL------------------------|
        //                                                  |
        // 对节点x先进行右旋转即转换成RR情况,再对y进行左旋转即可  |
        //      y                             y             |
        //    /  \                          /  \            |
        //   T1   x      向右旋转 (x)       T1   z           |
        //       / \   - - - - - - - ->        / \          |
        //      z  T4                         T2  x         |
        //     / \                               / \        |
        //    T2 T3                             T3 T4       |
        //                                                  |
        //------------------------RL------------------------|
        /////////////////////////////////////////////////////

        if (banlanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
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
        inOrder(root, keys);
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
        inOrder(node.left, list);
        list.add(node.key);
        inOrder(node.right, list);
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