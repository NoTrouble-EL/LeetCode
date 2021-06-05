package cn.xiaohupao.leetcode76;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/5 16:04
 */
public class MinimunWindowSubstring {

    /**
     * Given two strings s and t of lengths m and n respectively,
     * return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
     * If there is no such substring, return the empty string "".
     * The testcases will be generated such that the answer is unique.
     * A substring is a contiguous sequence of characters within the string.
     * @param s string s
     * @param t string t
     * @return minimun window substring of s such that every character in t is included in the window
     *
     * time: O(n)
     * space: O(k)
     */
    public static String minWindow(String s, String t){
        if (s == null || t == null || s.length() == 0 || t.length() == 0){
            return "";
        }

        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++){
            need[t.charAt(i)]++;
        }

        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        while (r < s.length()){
            char c = s.charAt(r);
            if (need[c] > 0){
                count--;
            }
            need[c]--;

            if (count == 0){
                while (l < r && need[s.charAt(l)] < 0){
                    need[s.charAt(l)]++;
                    l++;
                }

                if (r - l + 1 < size){
                    size = r-l+1;
                    start = l;
                }

                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }

        return size == Integer.MAX_VALUE ? "" : s.substring(start, start+size);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
