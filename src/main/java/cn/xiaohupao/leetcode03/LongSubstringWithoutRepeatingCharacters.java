package cn.xiaohupao.leetcode03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/16 10:48
 */
public class LongSubstringWithoutRepeatingCharacters {
    /**
     * Given a string s, find the length of the longest substring without repeating characters.
     * @param s String
     * @return int-longest substring without repeating characters
     *
     * time: O(n)
     * space: O(n)
     */
    public static int lengthOfLongestSubstring1(String s){
        if (s == null || s.length() == 0){
            return 0;
        }

        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j + 1);
        }

        return res;
    }

    public static int lengthOfLongestSubstring2(String s){
        if (s == null || s.length() == 0){
            return 0;
        }

        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0, j = 0; i < s.length(); i++){
            if (set.contains(s.charAt(i))){
                set.remove(s.charAt(j++));
            }else{
                set.add(s.charAt(i));
                res = Math.max(res, set.size());
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring1(s));
        System.out.println(lengthOfLongestSubstring2(s));
    }
}
