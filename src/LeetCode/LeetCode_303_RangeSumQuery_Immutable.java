package LeetCode;

import java.util.TreeSet;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 303. 区域和检索 - 数组不可变
 * @author: mirrorming
 * @create: 2019-01-13 11:05
 **/

public class LeetCode_303_RangeSumQuery_Immutable {

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */

    private int[] sum;//sum[i]存储nums中前i个数的和,sum[0]=0, sum[1]=nums[0], sum[2]=nums[0]+nums[1];

    public LeetCode_303_RangeSumQuery_Immutable(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}