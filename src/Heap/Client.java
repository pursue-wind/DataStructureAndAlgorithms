package Heap;

import java.util.Random;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 测试
 * @author: mirrorming
 * @create: 2019-01-05 17:52
 **/

public class Client {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        int max = 10000;
        Random random = new Random();
        for (int i = 0; i < max; i++)
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        int[] arr = new int[max];
        for (int i = 0; i < max; i++)
            arr[i] = maxHeap.extractMax();
        for (int i = 1; i < max - 1; i++) {
            if (arr[i] > arr[i - 1])
                throw new IllegalArgumentException("error");
            System.out.println(arr[i]);
        }

        System.out.println("completed");
    }
}