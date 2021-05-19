package cn.xiaohupao.leetcode20;

import java.util.Stack;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/19 21:29
 */
public class ValidParentheses {

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * @param s String
     * @return true is valid
     */
    public static boolean isValid(String s){
        if (s == null || s.length() == 0){
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (Character ch : s.toCharArray()){
            if (ch == '('){
                stack.push(')');
            }else if (ch == '['){
                stack.push(']');
            }else if (ch == '{'){
                stack.push('}');
            }else{
                if (stack.isEmpty() || !stack.pop().equals(ch)){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));
    }
}
