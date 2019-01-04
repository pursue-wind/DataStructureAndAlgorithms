package SetAndMap;

import LinkedList.LinkedList;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 基于链表实现的Set
 * @author: mirrorming
 * @create: 2019-01-03 11:37
 **/

public class LinkedListSet<E> implements Set<E> {
    private LinkedList linkedList;

    public LinkedListSet() {
        linkedList = new LinkedList();
    }

    @Override
    public void add(E e) {
        if (!linkedList.contains(e))
            linkedList.addFirst(e);
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }
}