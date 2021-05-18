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
        if (strs == null || strs.length == 0){
            return "";
        }

        String res = strs[0];
        for (int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(res) != 0){
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
