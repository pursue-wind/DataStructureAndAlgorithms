package RedBlackTree;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 红黑树
 * @author: mirrorming
 * @create: 2019-01-24 11:12
 **/


public class RBTree<K extends Comparable<K>, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = RED;
        }
    }

    private Node root;
    private int size;

    public RBTree() {
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
     * @Description: 判断红黑树中是否包含key
     * @Param: [e]
     * @return: boolean
     */
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    /**
     * @Description: 判断节点颜色
     * @Param: [node]
     * @return: boolean
     */
    private boolean isRed(Node node) {
        if (node == null)
            return BLACK;
        return node.color;
    }

    //////////////////////////////////////////////////
    // 对节点y进行向左旋转操作，返回旋转后新的根节点x    //
    //    y                             x          //
    //  /  \                          /  \         //
    // T1   x      向左旋转 (y)       y   T3        //
    //     / \   - - - - - - - ->   / \            //
    //   T2  T3                    T1 T2           //
    /////////////////////////////////////////////////
    private Node leftRotate(Node y) {
        //  暂存y的左节点x
        Node x = y.right;
        //  让y成为x的左孩子, t2成为y的右孩子
        y.right = x.left;
        x.left = y;

        x.color = y.color;
        y.color = RED;
        return x;
    }

    /**
     * @Description: 颜色翻转
     * @Param: [node]
     */
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    ////////////////////////////////////////////////////
    //     对节点y进行右旋转操作，返回旋转后新的根节点x    //
    //        y                              x        //
    //       / \                            / \       //
    //      x  T3      向右旋转 (y)         T1  y      //
    //     / \       - - - - - - - ->         / \     //
    //    T1 T2                              T2 T3    //
    ////////////////////////////////////////////////////
    private Node rightRotate(Node y) {
        //  暂存y的左节点x
        Node x = y.left;
        //  t2成为y的左孩子
        y.left = x.right;
        x.right = y;

        x.color = y.color;
        x.color = RED;
        return x;
    }

    /**
     * @Description: 向红黑树中添加元素
     * @Param: [key, value]
     */
    public void add(K key, V value) {
        root = add(root, key, value);
        root.color = BLACK;//最终根节点为黑色
    }

    /**
     * @Description: 向以node为根的红黑树中插入元素(key, value)，递归算法
     * @Param: [node, key, value]
     * @return: 返回插入新节点后红黑树的根
     */
    public Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);//默认插入红色节点
        }
        if (key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if (key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else   //key.compareTo(node.key) = 0
            node.value = value;

        if (isRed(node.right) && !isRed(node.left))
            node = leftRotate(node);

        if (isRed(node.left) && isRed(node.left.left))
            node = rightRotate(node);

        if (isRed(node.left) && isRed(node.right))
            flipColors(node);

        return node;
    }


    /**
     * @Description: 返回以node为根节点的红黑树中，key所在的节点
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
     * @Description: 返回红黑树中key值对应的value
     * @Param: [key]
     * @return: V
     */
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    /**
     * @Description: 更新红黑树中的value
     * @Param: [key, newValue]
     */
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + "doesn't exist~");
        node.value = newValue;
    }

    //-----------------------------------------toString-----------------------------------------//
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