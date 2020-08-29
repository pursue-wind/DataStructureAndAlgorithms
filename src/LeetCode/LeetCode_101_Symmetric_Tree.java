package LeetCode;

/**
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 给定一个二叉树，检查它是否是镜像对称的。

 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 **/

public class LeetCode_101_Symmetric_Tree {
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
        public boolean isSymmetric(TreeNode root) {
            return helper(root, root);
        }

        private boolean helper(TreeNode r1, TreeNode r2) {
            return (r1 == null && r2 == null) || !(r1 == null || r2 == null) && (r1.val == r2.val) && helper(r1.left, r2.right) && helper(r1.right, r2.left);
        }
    }
}
//Python3
//class Solution:
//    def isSymmetric(self, root: TreeNode) -> bool:
//        def helper(r1: TreeNode, r2: TreeNode) -> bool:
//            if not r1 and not r2: return True
//            if not r1 or not r2: return False
//            return (r1.val == r2.val) and helper(r1.left, r2.right) and helper(r1.right, r2.left)
//        return helper(root, root)