package LinkedList;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 测试
 * @author: mirrorming
 * @create: 2018-12-28 19:58
 **/

public class Client {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

//        linkedList.add(2, 222);
//        int size = linkedList.getSize();
//        System.out.println(size);
//        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
    }
}