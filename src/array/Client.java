package array;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 测试类
 * @author: mirrorming
 * @create: 2018-12-25 09:28
 **/

public class Client {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 8; i++) {
            array.add(i, i);
        }
        System.out.println(array);
        System.out.println(array);
        array.addFirst(99);
        array.addFirst(99);
        array.addFirst(99);
        array.addFirst(99);
        array.removeFirst();
        System.out.println(array);
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        System.out.println(array);
    }
}