package cn.xiaohupao.leetcode58;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/31 17:31
 */
public class LengthOfLastWord {

    /**
     * Given a string s consists of some words separated by spaces, return the length of the last word in the string.
     * If the last word does not exist, return 0.
     * A word is a maximal substring consisting of non-space characters only.
     * @param s a String
     * @return length of the last word
     *
     * time: O(n)
     * space: O(1)
     */
    public static int lengthOfLastWord(String s){
        int count = 0;
        for (int i = s.length()-1; i >= 0; i--){
            if (count == 0 && s.charAt(i) == ' '){
                continue;
            }
            if (count != 0 && s.charAt(i) == ' '){
                break;
            }else if (s.charAt(i) != ' '){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }
}
