package Queue;

import Array.Array;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 队列
 * @author: mirrorming
 * @create: 2018-12-25 16:35
 **/

public class ArrayQueue<E> implements Queue<E> {

    Array<E> array;

    /**
     * @Description: 无参构造函数
     * @Param: []
     * @return:
     */
    public ArrayQueue() {
        array = new Array<E>();
    }

    /**
     * @Description: 有参构造函数
     * @Param: [capacity]
     * @return:
     */
    public ArrayQueue(int capacity) {
        array = new Array<E>(capacity);
    }

    /**
     * @Description: 入队
     * @Param: [e]
     * @return: void
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * @Description: 出队
     * @Param: []
     * @return: E
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * @Description: 获取队首元素
     * @Param: []
     * @return: E
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    /**
     * @Description: 判断是否为空
     * @Param: []
     * @return: boolean
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * @Description: 获取容量
     * @Param: []
     * @return: int
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("ArrayQueue: Front[");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if (i != array.getSize() - 1)
                sb.append(",");
        }
        sb.append(']');
        return sb.toString();
    }
}