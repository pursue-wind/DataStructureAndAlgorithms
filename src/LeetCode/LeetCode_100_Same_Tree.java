package LeetCode;

/**
 * 链接：https://leetcode-cn.com/problems/same-tree
 *
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * =======================================================================================
 * Example 1:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 * [1,2,3],   [1,2,3]
 *
 * Output: true
 * =======================================================================================
 * Example 2:
 *
 * Input:     1         1
 *           /           \
 *          2             2
 * [1,2],     [1,null,2]
 *
 * Output: false
 * =======================================================================================
 * Example 3:
 *
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 * [1,2,1],   [1,1,2]
 *
 * Output: false
 **/

public class LeetCode_100_Same_Tree {

    public class TreeNode {
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

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return (p == null && q == null) || !(p == null || q == null) && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
//Python3
//class Solution:
//    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
//        if not p and not q: return True
//        if not p or not q: return False
//        if p.val != q.val: return False
//        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)