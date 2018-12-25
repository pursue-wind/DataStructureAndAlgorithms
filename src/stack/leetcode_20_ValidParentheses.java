package stack;

import java.util.Stack;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 20. 有效的括号
 * @author: mirrorming
 * @create: 2018-12-25 15:31
 **/

public class leetcode_20_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
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
}