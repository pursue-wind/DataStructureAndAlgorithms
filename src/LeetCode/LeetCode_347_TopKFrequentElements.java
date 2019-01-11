package LeetCode;

import java.util.*;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 347. 前K个高频元素
 * @author: mirrorming
 * @create: 2019-01-07 19:03
 **/

public class LeetCode_347_TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)
        );
        for (int key : map.keySet()) {
            if (pq.size() < k)
                pq.add(key);
            else if (pq.size() >= k && map.get(key) > map.get(pq.peek())) {
                pq.poll();
                pq.add(key);
            }
        }
        List<Integer> list = new ArrayList<>(k);
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int k = 2;
        System.out.println(new LeetCode_347_TopKFrequentElements().topKFrequent(nums, k));
    }
}