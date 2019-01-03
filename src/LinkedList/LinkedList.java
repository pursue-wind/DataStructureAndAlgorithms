package LinkedList;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 链表
 * @author: mirrorming
 * @create: 2018-12-25 17:05
 **/

public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        public Node() {
            this.e = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * @Description: 返回链表中的元素的个数
     * @return: int
     */
    public int getSize() {
        return this.size;
    }

    /**
     * @Description: 判断链表是否为空
     * @return: boolean
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * @Description: 在索引位置添加节点
     * @Param: [index, e]
     * @return: void
     */
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add fail , illegal index~");
        else {
            Node prev = dummyHead;
            for (int i = 0; i < index - 1; i++)
                prev = prev.next;
            Node newNode = new Node(e); //创建一个新节点
            newNode.next = prev.next;   //将新节点的下一个设置为prev的下一个节点
            prev.next = newNode;        // 将prev节点的下一个设置为新节点
            //上面三句可以替换为__prev.next = new Node(e , prev.next);
            size++;
        }
    }

    /**
     * @Description: 在链表头部添加节点
     * @Param: [e]
     * @return: void
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * @Description: 在链表末尾添加节点
     * @Param: [e]
     * @return: void
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * @Description: 获取索引位置的节点
     * @Param: [index]
     * @return: E
     */
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("get fail , illegal index~");
        Node cur = dummyHead.next;  //从dummHead的下一个节点开始遍历
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur.e;
    }

    /**
     * @Description: 获取第一个元素
     * @return: E
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * @Description: 获取最后一个元素
     * @return: E
     */
    public E getLast() {
        return get(size);
    }

    /**
     * @Description: 将索引位置的元素设为E
     * @Param: [index, e]
     * @return: void
     */
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("set fail , illegal index~");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }

    /**
     * @Description: 判断是否包含元素e
     * @Param: [e]
     * @return: boolean
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    /**
     * @Description: 删除链表中index位置的元素
     * @Param: [index]
     * @return: E
     */
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("remove fail , illegal index~");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    /**
     * @Description: 删除第一个元素
     * @return: E
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * @Description: 删除最后一个元素
     * @return: E
     */
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");
        return res.toString();
    }
}

