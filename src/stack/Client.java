package stack;

import array.Array;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 测试
 * @author: mirrorming
 * @create: 2018-12-25 14:52
 **/

public class Client {
    public static void main(String[] args) {
        ArrayStack<Integer> as = new ArrayStack<Integer>();
        for (int i = 1; i < 6; i++) {
            as.push(i);
        }
        System.out.println(as);
        as.pop();
        System.out.println(as);
    }
}