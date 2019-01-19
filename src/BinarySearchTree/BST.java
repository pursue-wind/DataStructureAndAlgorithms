package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 二分搜索树
 * @author: mirrorming
 * @create: 2019-01-01 21:35
 **/

public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
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
     * @Description: 向二分搜索树中添加元素e
     * @Param: [e]
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * @Description: 向以node为根的二分搜索树中添加元素e, 递归算法
     * @Param: [node, e]
     * @return: 新节点后二分搜索树的根
     */
    public Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;
    }

    /**
     * @Description: 判断BST中是否包含元素e
     * @Param: [e]
     * @return: boolean
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * @Description: 判断BST中是否包含元素e, 递归
     * @Param: [e]
     * @return: boolean
     */
    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else    //e.compareTo(node.e) > 0
            return contains(node.right, e);
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
        System.out.println(node.e);
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
            System.out.println(cur.e);
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
        System.out.println(node.e);
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
        System.out.println(node.e);
    }

    /**
     * @Description: 层序遍历
     */

    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);
            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }
    }

    /**
     * @Description: 寻找二分搜索树的最小元素
     * @return: E
     */
    public E minimum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty~");
        return minimum(root).e;
    }

    /**
     * @Description: 返回以node为根的BST最小值的节点
     * @Param: [node]
     * @return: BinarySearchTree.BST<E>.Node
     */
    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    /**
     * @Description: 寻找二分搜索树的最大元素
     * @return: E
     */
    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty~");
        return maximum(root).e;
    }

    /**
     * @Description: 返回以node为根的BST最大值的节点
     * @Param: [node]
     * @return: BinarySearchTree.BST<E>.Node
     */
    private Node maximum(Node node) {
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    /**
     * @Description: 删除BST中的最小元素
     * @return: E
     */
    public E removeMin() {
        E ret = minimum();
        removeMin(root);
        return ret;
    }

    /**
     * @Description: 删除BST中的最小元素, 递归实现
     * @Param: [node]
     * @return: BinarySearchTree.BST<E>.Node
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return node.right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * @Description: 删除BST中的最大元素
     * @return: E
     */
    public E removeMax() {
        E ret = maximum();
        maximum(root);
        return ret;
    }

    /**
     * @Description: 删除BST中的最大元素, 递归实现
     * @Param: [node]
     * @return: BinarySearchTree.BST<E>.Node
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return node.left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * @Description: 删除BST中的元素
     * @Param: [e]
     */
    public void remove(E e) {
        remove(root, e);
    }

    /**
     * @Description: 删除以node为根的值为e的元素, 递归算法
     * @Param: [node, e]
     * @return: BinarySearchTree.BST<E>.Node
     */
    private Node remove(Node node, E e) {
        if (node == null)
            return null;
        else if (e.compareTo(node.e) < 0) {//   如果e小于节点
            return remove(node.left, e);
        }
        //  如果e大于节点
        else if (e.compareTo(node.e) > 0) {
            return remove(node.right, e);
        }
        // e.compareTo(node.e) = 0
        else {
            //  如果左子树为空时
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //  如果右子树为空时
            else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //  如果左右子树均不为空时
            //找到比删除节点大的最小节点_右节点的最小值(左节点的最大值亦可)
            Node successor = minimum(node.right);
            //用找到的节点顶替删除的节点
            successor.right = removeMin(node.right);//removeMin中有一次size--操作,需要size++
            successor.left = node.left;
            node.left = node.right = null;//此操作需要一次size--,与上面操作抵消
            return successor;
        }
    }

    /**
     * @Description: toString
     * @return: java.lang.String
     */
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
        res.append(generateDepthString(depth) + node.e + "\n");
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