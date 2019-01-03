package Array;

import java.util.Arrays;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 线性表
 * @author: mirrorming
 * @create: 2018-12-25 09:10
 **/
public class Array<E> {
    private E[] data;
    private int size;   //数组的元素的个数

    /**
     * @Description: 无参构造函数 默认初始化容量为10
     * @Param: []
     * @return:
     */
    public Array() {
        this(10);
    }

    /**
     * @Description: 有参构造函数
     * @Param:
     * @return:
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * @Description: 获取数组中元素的个数
     * @Param: []
     * @return: int
     */
    public int getSize() {
        return size;
    }

    /**
     * @Description: 获取数组容量
     * @Param: []
     * @return: int
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * @Description: 判断是否为空
     * @Param: []
     * @return: boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @Description: 向指定位置添加元素_时间复杂度: O(n)
     * @Param: [index, e]
     * @return: void
     */
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add fail,require index < 0 || index > size~");
        if (size == data.length)
            resize(2 * data.length);
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];
        data[index] = e;
        size++;
    }

    /**
     * @Description: 最前面添加元素
     * @Param: [e]
     * @return: void
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * @Description: 末尾添加元素
     * @Param: [e]
     * @return: void
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * @Description: 获取指定位置的元素_时间复杂度: O(1)
     * @Param: [index]
     * @return: E
     */
    public E get(int index) {//时间复杂度: O1
        if (index < 0 || index > size)
            throw new IllegalArgumentException("get fail,index is illegal~");
        return data[index];
    }

    /**
     * @Description: 获取第一个元素
     * @Param: [index]
     * @return: E
     */
    public E getFirst() {
        return data[0];
    }

    /**
     * @Description: 获取最后一个元素
     * @Param: [index]
     * @return: E
     */
    public E getLast() {
        return data[size - 1];
    }

    /**
     * @Description: 将指定位置的元素设置为e
     * @Param: [index, e]
     */
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("set fail,index is illegal~");
        data[index] = e;
    }

    /**
     * @Description: 判断是否包含某个元素_时间复杂度: O(n)
     * @Param: [e]
     * @return: boolean
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     * @Description: 查找数组中元素e的索引 不存在则返回-1_时间复杂度: O(n)
     * @Param: [e]
     * @return: E
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * @Description: 删除指定位置的元素
     * @Param: [index]
     * @return: E
     */
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("remove fail, index is illeagl~");
        E ret = data[index];
        for (int i = index; i < size; i++)
            data[i] = data[i + 1];
        size--;
        data[size] = null;  //loitering Object闲逛的对象
        if (size < data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }

    /**
     * @Description: 删除第一个的元素_时间复杂度: O(n)
     * @Param: [index]
     * @return: E
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * @Description: 删除最后一个的元素
     * @Param: [index]
     * @return: E
     */
    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    /**
     * @Description: 扩容_时间复杂度: O(n)
     * @Param: [newCapacity]
     * @return: void
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Array{");
        sb.append("data=").append(data == null ? "null" : Arrays.asList(data).toString());
        sb.append(", size=").append(size);
        sb.append(", capacity=").append(data.length);
        sb.append('}');
        return sb.toString();
    }
}