package cn.xiaohupao.leetcode392;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/5 20:31
 */
public class IsSubsequence {

    public static boolean isSubsequence(String s, String t){
        //双指针 two point
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()){
            if (s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }

        return i == s.length();
    }

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
