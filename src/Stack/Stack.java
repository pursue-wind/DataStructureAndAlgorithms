package Stack;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 栈 栈的应用_undo操作_系统调用栈_括号匹配
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