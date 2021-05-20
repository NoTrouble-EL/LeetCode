package cn.xiaohupao.leetcode22;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/20 13:40
 */
public class GenerateParentheses {

    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * @param n int -  n pairs of parentheses
     * @return List<String> - all combinations of well-formed parentheses
     *
     * time: O(n!)
     * space: O(n)
     *
     * 卡特兰数
     */
    public static List<String> generateParenthesis(int n){
        List<String> res = new ArrayList<>();
        if (n == 0){
            return res;
        }

        helper(res, new StringBuilder(), n, n);
        return res;
    }

    private static void helper(List<String> res, StringBuilder sb, int left, int right){
        if (left > right){
            return;
        }

        if (left == 0 && right == 0){
            res.add(sb.toString());
        }

        if (left > 0){
            helper(res, sb.append('('), left-1, right);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right > 0){
            helper(res, sb.append(')'), left, right-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
