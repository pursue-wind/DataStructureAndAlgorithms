package LeetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 3.无重复字符的最长子串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。（medium）
 * =================================================================================
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * =================================================================================
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * =================================================================================
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

public class LeetCode_3_Longest_Substring_Without_Repeating_CharactersSolution {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        // result, window position
        int res = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            //记录开始位置
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_3_Longest_Substring_Without_Repeating_CharactersSolution().lengthOfLongestSubstring("qwewe"));
        System.out.println(new LeetCode_3_Longest_Substring_Without_Repeating_CharactersSolution_2().lengthOfLongestSubstring("wpdwzxcvxcvqe"));
        System.out.println(new LeetCode_3_Longest_Substring_Without_Repeating_CharactersSolution_3().lengthOfLongestSubstring("wpdwzxcvxcvqe"));
    }
}


class LeetCode_3_Longest_Substring_Without_Repeating_CharactersSolution_2 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int l = 0, r = 0;
        int max = 0;
        Set<Character> set = new HashSet<Character>();
        while (r < s.length()) {
            char cur = s.charAt(r);
            while (set.contains(cur)) {
                max = Math.max(r - l, max);
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r++));
        }
        return Math.max(r - l, max);
    }
}


class LeetCode_3_Longest_Substring_Without_Repeating_CharactersSolution_3 {
    public int lengthOfLongestSubstring(String s) {
        int[] last = IntStream.range(0, 128).map(i -> -1).toArray();
        // result, window position
        int res = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            //记录开始位置
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }

}