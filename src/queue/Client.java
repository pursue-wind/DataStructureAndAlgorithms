package queue;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 测试
 * @author: mirrorming
 * @create: 2018-12-25 16:43
 **/

public class Client {
    public static void main(String[] args) {
        ArrayQueue<Integer> aq = new ArrayQueue();
        aq.enqueue(33);
        aq.enqueue(35);
        aq.enqueue(37);
        aq.enqueue(39);
        System.out.println(aq);
        aq.dequeue();
        System.out.println(aq);
        System.out.println(aq.isEmpty());
        System.out.println(aq.getFront());
        System.out.println(aq.getSize());
    }
}