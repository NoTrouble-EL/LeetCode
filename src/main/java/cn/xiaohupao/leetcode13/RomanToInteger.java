package cn.xiaohupao.leetcode13;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/18 12:20
 */
public class RomanToInteger {

    /**
     * Roman numerals are represented by seven different symbols:I, V, X, L, C, D and M.
     * @param s String - Roman numerals
     * @return int - Integer
     *
     * time: O(n)
     * space: O(1)
     */
    public static int romanToInt(String s){
        if (s == null || s.length() == 0){
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int res = 0;
        int pre = map.get(s.charAt(0));
        for (int j = 1; j < s.length(); j++){
            int temp = map.get(s.charAt(j));
            if (temp > pre){
                res -= pre;
            }else{
                res += pre;
            }
            pre = temp;
        }
        res += pre;
        return res;
    }
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
}
