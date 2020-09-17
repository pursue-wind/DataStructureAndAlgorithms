package LeetCode;

import java.util.*;


/**
 * https://leetcode-cn.com/problems/permutations/
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * =====================================================
 * 示例:
 * =====================================================
 * 输入: [1,2,3]
 * =====================================================
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class LeetCode_46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        boolean[] used = new boolean[len];
        help(res, nums, new LinkedList<>(), 0, used);
        return res;
    }

    private void help(List<List<Integer>> res, int[] nums, LinkedList<Integer> list, int index, boolean[] used) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                list.addLast(nums[i]);
                used[i] = true;
                help(res, nums, list, index + 1, used);
                list.removeLast();
                used[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = new LeetCode_46_Permutations().permute(nums);
        System.out.println(lists);
    }
}