package cn.xiaohupao.leetcode49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/27 16:19
 */
public class GroupAnagrams {

    /**
     * Given an array of strings strs, group the anagrams together.
     * You can return the answer in any order.
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     * @param strs an array of strings strs
     * @return answer in any order
     *
     * time: O(m*n*logn)
     * space: O(n)
     */
    public static List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0){
            return res;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if (map.containsKey(s)){
                List<String> list = res.get(map.get(s));
                list.add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, res.size());
                res.add(list);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}
