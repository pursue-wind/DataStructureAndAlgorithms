package leetcode;

import stack.ArrayStack;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 20. 有效的括号
 * @author: mirrorming
 * @create: 2018-12-25 15:31
 **/

public class LeetCode_20_ValidParentheses {
    public boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                char top = stack.pop();
                if (c == '}' && top != '{')
                    return false;
                else if (c == ']' && top != '[')
                    return false;
                else if (c == ')' && top != '(')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_20_ValidParentheses().isValid("{}[]()"));
        System.out.println(new LeetCode_20_ValidParentheses().isValid("{[]()}"));
        System.out.println(new LeetCode_20_ValidParentheses().isValid("{[]([)}"));
    }
}