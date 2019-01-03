package Array;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 测试类
 * @author: mirrorming
 * @create: 2018-12-25 09:28
 **/

public class Client {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        array.addLast(91);
        array.addLast(92);
        array.addLast(93);
        array.addLast(94);
        array.addLast(95);
        System.out.println(array);
        int a1 = array.removeLast();
        int a2 = array.removeLast();
        int a3 = array.removeLast();
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        System.out.println(array);
    }
}