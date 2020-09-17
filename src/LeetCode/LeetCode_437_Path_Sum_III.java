package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/path-sum-iii
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * =============================================
 * 找出路径和等于给定数值的路径总数。
 * =============================================
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * =============================================
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * =============================================
 * 示例：
 * =============================================
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * =============================================
 *              10
 *             /  \
 *            5   -3
 *           / \    \
 *          3   2   11
 *         / \   \
 *        3  -2   1
 * =============================================
 * 返回 3。和等于 8 的路径有:
 * =============================================
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 **/
public class LeetCode_437_Path_Sum_III {

    /**
     * Definition for a binary tree node.
     */
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private class Solution {
        public int pathSum(TreeNode root, int sum) {
            if(root == null) return 0;

            int res = helper(root, sum);

            return res + pathSum(root.left, sum) + pathSum(root.right, sum);
        }

        private int helper(TreeNode root, int sum) {
            if( root == null) return 0;
            int res = 0;
            if( root.val == sum ) res += 1;

            return res + helper(root.left, sum - root.val) + helper(root.right, sum - root.val);
        }
    }

    private class Solution2 {
        public int pathSum(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            return findPathSum(root, 0, sum, map);
        }

        private int findPathSum(TreeNode curr, int sum, int target, Map<Integer, Integer> map) {
            if (curr == null) {
                return 0;
            }
            // 通过添加当前值来更新前缀和
            sum += curr.val;
            // 获取当前节点结束的有效路径数
            // 在前缀和数组中，sum(a,b) = sum(0, b) - sum(0, a-1) 和 sum(0, a-1) = sum(0, b) - sum(a,b) 是相同的 where currSum = sum(0, b) and target is sum(a,b). a 和 b 是数组中的索引.
            int numPathToCurr = map.getOrDefault(sum - target, 0);
            // 使用当前总和更新 map，因此可以将map传递给下一个递归
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            // 将8中讨论的3个部分加在一起
            int res = numPathToCurr + findPathSum(curr.left, sum, target, map) + findPathSum(curr.right, sum, target, map);
            // 还原map，因为递归从底部到顶部
            map.put(sum, map.get(sum) - 1);
            return res;
        }
    }
}
