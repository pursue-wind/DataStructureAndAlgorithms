package LeetCode;

import java.util.HashSet;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 349. 两个数组的交集_easy
 * @author: mirrorming
 * @create: 2018-12-27 16:32
 **/

public class LeetCode_349_IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> record = new HashSet<Integer>();
        HashSet<Integer> retSet = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++)
            record.add(nums1[i]);
        for (int i = 0; i < nums2.length; i++)
            if (record.contains(nums2[i]))
                retSet.add(nums2[i]);
        int[] retArr = new int[retSet.size()];
        int index = 0;
        for (int i : retSet)
            retArr[index++] = i;
        return retArr;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(new LeetCode_349_IntersectionOfTwoArrays().intersection(nums1, nums2));

    }
}