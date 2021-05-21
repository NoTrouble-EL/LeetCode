package cn.xiaohupao.leetcode28;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/21 18:16
 */
public class ImplementStrStr {

    /**
     * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     * @param haystack str
     * @param needle str
     * @return index of the first occurrence of needle in haystack
     *
     * time: O(n^2)
     * space: O(1)
     */
    public static int strStr(String haystack, String needle){
        if (needle.length() == 0){
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++){
            if (haystack.substring(i, i+needle.length()).equals(needle)){
                return i;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));
    }
}
