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

    public ArrayStack() {
        this.array = new Array<E>();
    }

    /**
     * @Description: 入栈
     * @Param: [e]
     * @return: void
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * @Description: 出栈
     * @Param: []
     * @return: E
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * @Description: 栈顶元素
     * @Param: []
     * @return: E
     */
    @Override
    public E peek() {
        return array.getLast();
    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("ArrayStack:[");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(i);
            if (i != array.getSize() - 1)
                sb.append(",");
        }
        sb.append("] tops");
        return sb.toString();
    }
}