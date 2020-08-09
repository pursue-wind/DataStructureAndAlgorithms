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
 * =====================================================
 *
 * @author Mireal
 */
public class LeetCode_46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;
        boolean[] used = new boolean[len];
        Deque<Integer> path = new LinkedList<>();
        dfs(nums, res, used, path);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, boolean[] used, Deque<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            path.add(nums[i]);
            used[i] = true;
            dfs(nums, res, used, path);
            used[i] = false;
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> lists = new LeetCode_46_Permutations().permute(nums);
        System.out.println(lists);
    }
}