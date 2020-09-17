package LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

/**
 * @author Mireal
 * @version V1.0
 * @date 2020/9/12 15:35
 */
public class Test {
    //[012]
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 2, 1, 2};

        insertSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                int t = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = t;
            }
        }
    }
}
