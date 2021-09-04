package cn.xiaohupao.leetcode1190;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/4 19:03
 */
public class ReverseSubstringsBetweenEachPairOfParentheses {

    /**
     * You are given a string s that consists of lower case English letters and brackets.
     * Reverse the strings in each pair of matching parentheses, starting from the innermost one.
     * Your result should not contain any brackets.
     * @param s
     * @return
     */
    public static String reverseParentheses(String s){
        //括号预处理
        //首先创建一个数组用于保存括号的位置，且需要将成对的括号位置相反记录
        //使用一个辅助栈记录括号所在的位置

        int[] pair = new int[s.length()];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else if (s.charAt(i) == ')'){
                int index = stack.pop();
                pair[i] = index;
                pair[index] = i;
            }
        }

        //使用StringBuilder来保存结果
        StringBuilder res = new StringBuilder();

        int i = 0;
        int to = 1;
        //遍历字符串
        while (i < s.length()){
            //遇见括号就改变索引位置并改变遍历方向
            if (s.charAt(i) == '(' || s.charAt(i) == ')'){
                i = pair[i];
                to = -1 * to;
            }else{
                res.append(s.charAt(i));
            }
            //步进
            i += to;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "(u(love)i)";
        System.out.println(reverseParentheses(s));
    }
}
