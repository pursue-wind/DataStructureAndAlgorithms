package Queue;

import Heap.MaxHeap;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 优先队列
 * @author: mirrorming
 * @create: 2019-01-07 18:10
 **/

public class PriortyQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }
}