package SetAndMap;

import java.security.Key;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 基于二分搜索树实现映射
 * @author: mirrorming
 * @create: 2019-01-03 18:33
 **/

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    /**
     * @Description: 获取键为key的node
     * @Param: [node, key]
     * @return: Node
     */
    private Node getNode(Node node, K key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) == 0)
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else //node.key.compareTo(key) > 0
            return getNode(node.right, key);
    }

    /**
     * @Description: 向二分搜索树中添加元素(key, value)
     * @Param: [key, value]
     */
    @Override
    public void add(K key, V value) {
        if (root == null) {
            root = new Node(key, value);
            size++;
        } else
            add(root, key, value);
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException("set fail, " + key + "doesn't exist~");
        else
            node.value = newValue;
    }

    /**
     * @Description: 向以node为根的二分搜索树中添加元素(key, value), 递归算法
     * @Param: [node, key, value]
     * @return: Node
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if (key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else //key.compareTo(node.key) = 0
            node.value = value;
        return node;
    }

    /**
     * @Description: 判断BSTMap中是否包含元素(key, value)
     * @Param: [e]
     * @return: boolean
     */
    public boolean contains(K Key) {
        return getNode(root, Key) != null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }


    public K minimum() {
        if (size == 0)
            throw new IllegalArgumentException("BSTMap is empty~");
        return minimum(root).key;
    }


    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }


    public K removeMin() {
        K ret = minimum();
        removeMin(root);
        return ret;
    }


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

    private Node remove(Node node, K key) {
        if (node == null)
            return null;
        else if (key.compareTo(node.key) < 0) {//   如果e小于节点
            return remove(node.left, key);
        }
        //  如果e大于节点
        else if (key.compareTo(node.key) > 0) {
            return remove(node.right, key);
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
        res.append(generateDepthString(depth) + node.key + ":" + node.value + "\n");
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