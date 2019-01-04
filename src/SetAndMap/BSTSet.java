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
        bst.remove(e);
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }
}