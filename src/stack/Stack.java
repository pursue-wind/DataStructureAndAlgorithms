package stack;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 栈
 * @author: mirrorming
 * @create: 2018-12-25 14:35
 **/

public interface Stack<E> {
    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}