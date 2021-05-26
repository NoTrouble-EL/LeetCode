package cn.xiaohupao.leetcode44;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/26 14:50
 */
public class WildcardMatching {

    /**
     * Given an input string (s) and a pattern (p),
     * implement wildcard pattern matching with support for '?' and '*' where:
     * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence).
     * @param s String
     * @param p pattern
     * @return true is matching
     *
     * time: O(n)
     * space: O(1)
     */
    public static boolean isMatch(String s, String p){
        int sp = 0, pp = 0, match = 0, star = -1;
        while (sp < s.length()){
            if (pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')){
                sp++;
                pp++;
            }else if (pp < p.length() && p.charAt(pp) == '*'){
                star = pp;
                match = sp;
                pp++;
            }else if (star != -1){
                pp = star+1;
                match++;
                sp = match;
            }else{
                return false;
            }
        }

        while (pp < p.length() && p.charAt(pp) == '*'){
            pp++;
        }

        return pp == p.length();
    }

    public static void main(String[] args) {
        String s = "adceb", p = "*a*b";
        System.out.println(isMatch(s, p));
    }
}
