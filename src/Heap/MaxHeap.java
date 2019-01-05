package Heap;

import Array.Array;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 使用Array来实现最大堆(此处为二叉堆)
 * @author: mirrorming
 * @create: 2019-01-05 16:43
 **/

///////////////////////////////////////////////////////////////////////
//      0                                                            //
//    /   \        parent(i) = (i-1)/2                               //
//   1    2        leftChild(i) = 2*i+1                              //
//  / \  / \       rightChild(i) = 2*i+2                             //
// 3  4 5  6                                                         //
///////////////////////////////////////////////////////////////////////
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap() {
        data = new Array<E>();
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * @Description: 返回完全二叉树的数组表示中一个元素的索引对应的父节点的索引
     * @Param: [index]
     * @return: int
     */
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent~");
        return (index - 1) / 2;
    }

    /**
     * @Description: 返回完全二叉树的数组表示中, 一个元素的索引对应的左孩子的索引
     * @Param: [index]
     * @return: int
     */
    public int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * @Description: 返回完全二叉树的数组表示中, 一个元素的索引对应的右孩子的索引
     * @Param: [index]
     * @return: int
     */
    public int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * @Description: 向堆中添加元素
     * @Param: [e]
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * @Description: 添加元素时的上浮操作
     * @Param: [i]
     */
    private void siftUp(int index) {
        while (index > 0 && data.get(index).compareTo(data.get(parent(index))) > 0) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    /**
     * @Description: 交换索引i和j的元素
     * @Param: [i, j]
     */
    private void swap(int i, int j) {
        if (i < 0 || i > data.getSize() || j < 0 || j > data.getSize())
            throw new IllegalArgumentException("Index is illegal~");
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("findMax fail, Heap is empty~");
        return data.get(0);
    }

    /**
     * @Description: 取出堆中的最大值
     * @return: E
     */
    public E extractMax() {
        E ret = findMax();
        swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    /**
     * @Description: 取出堆中的最大值, 下沉操作
     * @Param: [index]
     */
    private void siftDown(int index) {
        //当该节点的左孩子节点比size大时,下浮停止
        while (leftChild(index) < data.getSize()) {
            int j = leftChild(index);
            //j+1则为右孩子索引,如果右孩子存在并且大于左孩子,j就变为右孩子的索引
            if (j + 1 < data.getSize() && data.get(j).compareTo(data.get(j + 1)) < 0)
                j++;
            //如果当前的值大于或等于子节点的值,停止下沉
            if (data.get(index).compareTo(data.get(j)) >= 0)
                break;//退出循环
            swap(index, j);
            index = j;
        }
    }


}