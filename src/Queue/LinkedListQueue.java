package Queue;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 基于带尾指针的链表实现队列
 * @author: mirrorming
 * @create: 2018-12-28 18:23
 **/

public class LinkedListQueue<E> implements Queue<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * @Description: 入队
     * @Param: [e]
     */
    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        }
        //如果尾节点不为空
        else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    /**
     * @Description: 出队
     * @return: E
     */
    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("dequeue fail , Queue is empty~");
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("getFront fail , Queue is empty~");
        return head.e;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("LinkedListQueue: TOP ");
        for (Node cur = head; cur != null; cur = cur.next)
            sb.append(cur + "->");
        sb.append("NULL tail");
        return sb.toString();
    }
}