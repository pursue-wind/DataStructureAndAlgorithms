package BinarySearchTree;

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
        if (root == null) {
            root = new Node(e);
            size++;
        } else
            add(root, e);
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

}