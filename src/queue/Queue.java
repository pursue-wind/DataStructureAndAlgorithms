package queue;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 队列
 * @author: mirrorming
 * @create: 2018-12-25 16:33
 **/

public interface Queue<E> {
    void enqueue(E e);

    E dequeue();

    E getFront();

    boolean isEmpty();

    int getSize();
}