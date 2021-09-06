package cn.xiaohupao.leetcode17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/19 16:54
 */
public class LetterCombinationsOfAPhoneNumber {

    /**
     * Given a string containing digits from 2-9 inclusive,
     * return all possible letter combinations that the number could represent.
     * Return the answer in any order.
     * @param digits String - containing digits
     * @return List<String> - any order
     *
     * time: O(3^m x 4^n)，其中m是输入对应3个字母的数组个数，n是输入对应3个字母的数字个数
     * space: O(m + n)，m是输入对应3个字母的数组个数，n是输入对应3个字母的数字个数
     */
    public static List<String> letterCombinations(String digits){
        //use backtracking

        //创建一个res用于保存结果
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return res;
        }

        //创建一个map用于保存输入数字和对应值的k-v
        Map<Character, String> phoneMap = new HashMap<Character, String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backTracking(res, phoneMap, 0, digits, new StringBuilder());
        return res;
    }

    //backtracking
    private static void backTracking(List<String> res, Map<Character, String> phoneMap, int index, String digits, StringBuilder combination){
        //递归出口为当前值为输入字符的长度
        if (index == digits.length()){
            res.add(combination.toString());
        }else{
            //取出第一个值
            char c = digits.charAt(index);
            //找到对应的字符串
            String letters = phoneMap.get(c);
            int lettersLength = letters.length();
            //横向遍历字符串
            for (int i = 0; i < lettersLength; i++){
                //添加字符
                combination.append(letters.charAt(i));
                //递归
                backTracking(res, phoneMap, index+1, digits, combination);
                //回溯
                combination.deleteCharAt(index);
            }
        }
    }
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits).toString());
    }
}
