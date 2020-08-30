package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 链接：https://leetcode-cn.com/problems/combinations
 * <p>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class LeetCode_77_Combinations {
    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if (k <= 0 || k > n) {
                return res;
            }

            helper(n, k, 1, res, new LinkedList<>());
            return res;
        }

        private void helper(int n, int k, int index, List<List<Integer>> res, LinkedList<Integer> arr) {
            if (k == arr.size()) {
                res.add(new ArrayList<>(arr));
                return;
            }

            for (int i = index; i <= n - k + 1; i++) {
                arr.addLast(i);
                helper(n, k, i + 1, res, arr);
                arr.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new Solution().combine(4, 2);
        System.out.println(combine);
    }
}