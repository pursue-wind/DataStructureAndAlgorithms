package Stack;

import LinkedList.LinkedList;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 使用链表实现栈
 * @author: mirrorming
 * @create: 2018-12-29 17:51
 **/

public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("LinkedListStack: TOP");
        sb.append(list);
        return sb.toString();
    }
}