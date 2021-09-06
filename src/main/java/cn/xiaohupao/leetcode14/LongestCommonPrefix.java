package cn.xiaohupao.leetcode14;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/18 13:49
 */
public class LongestCommonPrefix {

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     * If there is no common prefix, return an empty string "".
     * @param strs Array - an array of strings
     * @return String - common prefix string
     *
     * time: O(n)
     * space: O(1)
     */
    public static String longestCommonPrefix(String[] strs){
        //corner case
        if (strs == null || strs.length == 0){
            return "";
        }

        //取第一个字符串为匹配
        String res = strs[0];
        for (int i = 1; i < strs.length; i++){
            //循环遍历后面的字符串
            while (strs[i].indexOf(res) != 0){
                //若后面的字符串不包含模板，则让模板的长度-1
                res = res.substring(0, res.length() - 1);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
