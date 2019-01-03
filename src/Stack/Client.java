package Stack;

import java.util.Random;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 测试
 * @author: mirrorming
 * @create: 2018-12-25 14:52
 **/

public class Client {

    public static double testStack(Stack<Integer> stack, int count) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < count; i++)
            stack.pop();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 1000000;
        Stack<Integer> stack1 = new ArrayStack();
        double time1 = testStack(stack1, opCount);
        Stack<Integer> stack2 = new LinkedListStack();
        double time2 = testStack(stack2, opCount);
        System.out.println(String.format("ArrayStack: %s \nLinkedListStack: %s", time1, time2));
    }
}