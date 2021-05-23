package cn.xiaohupao.leetcode32;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/23 13:56
 */
public class LongestValidParentheses {

    /**
     * Given a string containing just the characters '(' and ')',
     * find the length of the longest valid (well-formed) parentheses substring.
     * @param s String
     * @return int - the length of the longest valid parentheses substring
     *
     * time: O(n)
     * space: O(n)
     */
    public static int longestValidParentheses(String s){
        Deque<Integer> stack = new ArrayDeque<>();

        int res = 0, start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                if (stack.isEmpty()){
                    start = i;
                }else{
                    stack.pop();
                    if (stack.isEmpty()){
                        res = Math.max(res, i - start);
                    }else{
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }
}
