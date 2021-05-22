package cn.xiaohupao.leetcode30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/22 14:38
 */
public class SubstringWithConcatenationOfAllWords {

    /**
     * You are given a string s and an array of strings words of the same length.
     * Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once,
     * in any order, and without any intervening characters.
     * @param s String
     * @param words an array of strings words of the same length
     * @return all starting indices of substring(s) in s
     *
     * time: O(n^2)
     * space: O(n)
     */
    public static List<Integer> findSubstring(String s, String[] words){
        if (s == null || words == null){
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        int n = words.length, m = words[0].length();

        HashMap<String, Integer> map = new HashMap<>();
        for (String str : words){
            map.put(str, map.getOrDefault(str, 0)+1);
        }

        for (int i = 0; i <= s.length() - (m*n); i++){
            HashMap<String, Integer> copy = new HashMap<>(map);
            int k = n, j = i;
            while (k > 0){
                String str = s.substring(j, j+m);
                if (!copy.containsKey(str) || copy.get(str) < 1){
                    break;
                }
                copy.put(str, copy.get(str)-1);
                k--;
                j += m;
            }
            if (k == 0){
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};
        System.out.println(findSubstring(s, words));
    }
}
