package SegmentTree;

import java.util.Arrays;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 线段树
 * @author: mirrorming
 * @create: 2019-01-11 16:52
 **/

public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++)
            data[i] = arr[i];

        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * @Description: 创建线段树
     * @Param: [treeIndex, left, right]
     */
    private void buildSegmentTree(int treeIndex, int left, int right) {

        if (left == right) {    //如果到了叶子节点
            tree[treeIndex] = data[left];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);   //获得左子树的索引
        int rightTreeIndex = rightChild(treeIndex); //获得右子树的索引
        int mid = left + (right - left) / 2;        //中点

        buildSegmentTree(leftTreeIndex, left, mid); //递归创建左右子树
        buildSegmentTree(rightTreeIndex, mid + 1, right);

        tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeIndex]); //融合左右子树的值到父节点
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("index is illegal~");
        return data[index];
    }

    /**
     * @Description: 返回完全二叉树的数组表示中, 一个索引所表示的元素的左孩子节点的索引
     * @Param: [index]
     * @return: int
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * @Description: 返回完全二叉树的数组表示中, 一个索引所表示的元素的右孩子节点的索引
     * @Param: [index]
     * @return: int
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * @Description: 返回 [queryL, queryR] 的值
     * @Param: [queryL, queryR] 左右区间的索引
     * @return: E
     */
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("index is illegal~");
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * @Description: 查询操作递归函数
     * @Param: [treeIndex查询的节点, l, r, queryL, queryR]
     * @return: E
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        //  左右边界恰好等于查询边界
        if (l == queryL && r == queryR)
            return tree[treeIndex];

        //  计算左右孩子索引和中点
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;

        //  如果查询的左边界大于中点,直接去右孩子中查找
        if (queryL >= mid + 1)
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);

        else if (queryR <= mid) //  如果查询的右边界小于中点,直接去左孩子中查找
            return query(leftTreeIndex, l, mid, queryL, queryR);

        //  如果查询区间在左右孩子中都有
        E leftTreeResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightTreeResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);

        //  融合左右查询的结果并返回
        return merger.merger(leftTreeResult, rightTreeResult);
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer("SegmentTree: [ ");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("NULL");
            if (i != tree.length - 1)
                res.append(" , ");
        }
        res.append("]");
        return res.toString();
    }
}