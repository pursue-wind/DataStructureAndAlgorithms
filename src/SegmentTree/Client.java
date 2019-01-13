package SegmentTree;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 测试
 * @author: mirrorming
 * @create: 2019-01-12 09:55
 **/

public class Client {
    public static void main(String[] args) {
        Integer[] arr = {1, 3, 6, 8, 9, 4, 6, 5};
        SegmentTree<Integer> segmentTree = new SegmentTree<Integer>(arr, new Merger<Integer>() {
            @Override
            public Integer merger(Integer a, Integer b) {
                return a + b;
            }
        });
        System.out.println(segmentTree);

        SegmentTree<Integer> segmentTree2 = new SegmentTree<Integer>(arr, (a, b) -> a + b);
        System.out.println(segmentTree2);

        System.out.println(segmentTree.query(3, 5));
        System.out.println(segmentTree.query(2, 7));
        System.out.println(segmentTree.query(1, 5));
        System.out.println(segmentTree.query(0, 2));
    }
}