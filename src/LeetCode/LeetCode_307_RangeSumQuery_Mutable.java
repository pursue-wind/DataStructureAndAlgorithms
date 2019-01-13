package LeetCode;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 307. 区域和检索 - 数组可修改_middle
 * @author: mirrorming
 * @create: 2019-01-13 11:25
 **/
class LeetCode_307_RangeSumQuery_Mutable {

    private int[] sum;
    private int[] data;

    public LeetCode_307_RangeSumQuery_Mutable(int[] nums) {
        data = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            data[i] = nums[i];
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++)
            sum[i + 1] = sum[i] + nums[i];
    }

    public void update(int i, int val) {
        data[i] = val;
        for (int j = i + 1; j < sum.length; j++)
            sum[j] = sum[j - 1] + data[j - 1];
    }


    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}