package LeetCode;

/**
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *           5
 *          / \
 *         4   8
 *        /   / \
 *       11  13  4
 *      /  \      \
 *     7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 **/
public class LeetCode_112_Path_Sum {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) return false;
            return (root.left == null && root.right == null) ? sum == root.val : hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }

    public static void main(String[] args) {
        System.out.println(1 << 30);
    }
}
//Python3
//class Solution:
//    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
//        if not root: return False
//        return sum == root.val if (not root.left and not root.right) else self.hasPathSum(root.left, sum - root.val) or self.hasPathSum(root.right, sum - root.val)