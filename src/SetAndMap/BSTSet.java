package SetAndMap;

import BinarySearchTree.BST;
import SetAndMap.Set;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 基于BST实现集合
 * @author: mirrorming
 * @create: 2019-01-02 18:26
 **/

public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST bst;

    public BSTSet() {
        bst = new BST();
    }


    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {

    }

    @Override
    public boolean isEmpty(E e) {
        return false;
    }

    @Override
    public boolean contains() {
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }
}