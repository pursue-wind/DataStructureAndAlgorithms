package stack;

import array.Array;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 栈
 * @author: mirrorming
 * @create: 2018-12-25 14:37
 **/

public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capacity) {
        this.array = new Array<E>(capacity);
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return null;
    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
}