package cn.xiaohupao.leetcode1047;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/4 20:07
 */
public class RemoveAllAdjacentDuplicatesInString {

    public static String removeDuplicates(String s){
        //corner case
        if (s == null || s.length() < 2){
            return s;
        }

        //使用辅助栈
        Deque<Character> stack = new ArrayDeque<>();

        //遍历字符串数组
        for (char ch : s.toCharArray()){
            if (!stack.isEmpty() && stack.peek() == ch){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }

        //创建一个StringBuilder用于保存结果
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }
}
