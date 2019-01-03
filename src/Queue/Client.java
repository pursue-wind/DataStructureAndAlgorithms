package Queue;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 测试
 * @author: mirrorming
 * @create: 2018-12-25 16:43
 **/

public class Client {
    public static void main(String[] args) {
        LinkedListQueue<Integer> aq = new LinkedListQueue();
        for (int i = 1; i <= 9; i++) {
            aq.enqueue(i);
            System.out.println(aq);
        }
        aq.dequeue();
        System.out.println(aq);
        System.out.println(aq.isEmpty());
        System.out.println(aq.getFront());
        System.out.println(aq.getSize());

    }
}