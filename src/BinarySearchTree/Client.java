package BinarySearchTree;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 测试
 * @author: mirrorming
 * @create: 2019-01-02 19:48
 **/

public class Client {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] arr = {5, 3, 6, 8, 4, 2};
        for (int num : arr)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
//        bst.preOrder();
//        System.out.println();
//        bst.inOrder();
//        System.out.println();
//        bst.postOrder();
//        System.out.println();
        bst.remove(3);
        bst.levelOrder();
        System.out.println();

        Integer integer = bst.removeMax();
        System.out.println(integer);

        bst.preOrderNR();
        System.out.println();

        System.out.println(bst);
    }
}