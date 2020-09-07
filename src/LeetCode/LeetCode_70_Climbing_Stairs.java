package LeetCode;

/**
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * ======================================================
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * ======================================================
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * ======================================================
 * 注意：给定 n 是一个正整数。
 * ======================================================
 * 示例 1：
 * ======================================================
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * ======================================================
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class LeetCode_70_Climbing_Stairs {
    static class Solution {

        public int climbStairs(int n) {
            if (n < 2) return 1;
            int res = -1;
            int zero = 1, first = 1;
            for (int i = 2; i <= n; i++) {
                res = zero + first;
                zero = first;
                first = res;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int res = new Solution().climbStairs(33);
        System.out.println(res);
    }
}
//python3
//class Solution:
//    def climbStairs(self, n: int) -> int:
//        if n < 2: return n
//        res, zero, first = 0, 1, 1
//        for i in range(2, n + 1):
//            res = zero + first
//            zero, first = first, res
//        return res