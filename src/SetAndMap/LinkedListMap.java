package SetAndMap;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 基于链表实现的Map
 * @author: mirrorming
 * @create: 2019-01-03 17:04
 **/

public class LinkedListMap<K, V> implements Map<K, V> {


    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ":" + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node(null, null, null);
        size = 0;
    }

    /**
     * @Description: 返回键为key的节点
     * @Param: [key]
     * @return: Node
     */
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key))
                return cur;
            cur = cur.next;
        }
        return null;
    }

    /**
     * @Description: 判断Map的键中是否包含key
     * @Param: [key]
     * @return: boolean
     */
    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    /**
     * @Description: 从Map中获取key对应的value
     * @Param: [key]
     * @return: V
     */
    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    /**
     * @Description: 添加
     * @Param: [key, value]
     */
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        //不存在这个key
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }
        //已经存在这个key
        else
            node.value = value;
    }

    /**
     * @Description: 修改
     * @Param: [key, newValue]
     */
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null)
            throw new IllegalArgumentException("set fail, " + key + "doesn't exist~");
        else    //node!=null
            node.value = newValue;
    }

    /**
     * @Description: 删除
     * @Param: [key]
     * @return: V
     */
    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key))
                break;
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    /**
     * @Description: 返回Map中的元素的个数
     * @return: int
     */
    @Override
    public int getSize() {
        return this.size;
    }

    /**
     * @Description: 判断Map是否为空
     * @return: boolean
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }


}