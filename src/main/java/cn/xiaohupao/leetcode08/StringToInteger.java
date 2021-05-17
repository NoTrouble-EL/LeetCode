package cn.xiaohupao.leetcode08;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/17 14:39
 */
public class StringToInteger {
    /**
     *Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
     * The algorithm for myAtoi(string s) is as follows:
     * 1.Read in and ignore any leading whitespace.
     * 2.Check if the next character (if not already at the end of the string) is '-' or '+'.
     * Read this character in if it is either.
     * This determines if the final result is negative or positive respectively.
     * Assume the result is positive if neither is present.
     * 3.Read in next the characters until the next non-digit charcter or the end of the input is reached.
     * The rest of the string is ignored.
     * 4.Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32).
     * If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
     * 5.If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1], then clamp the integer so that it remains in the range.
     * Specifically, integers less than -2^31 should be clamped to -2^31, and integers greater than 2^31 - 1 should be clamped to 2^31 - 1.
     * 6.Return the integer as the final result.
     *
     * @param s String
     * @return int final result
     *
     * time: O(n)
     * space: O(1)
     */
    public static int myAtoi(String s){
        s = s.trim();
        if (s == null || s.length() == 0){
            return 0;
        }

        char first = s.charAt(0);
        int sign = 1;
        int start = 0;
        long res = 0;

        if (first == '+'){
            start++;
        }else if (first == '-'){
            sign = -1;
            start++;
        }

        for (int i = start; i < s.length(); i++){
            if (!Character.isDigit(s.charAt(i))){
                return (int) res * sign;
            }
            res = res * 10 + s.charAt(i) - '0';
        }

        if (sign == 1 && res > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if (sign == -1 && res > Integer.MAX_VALUE){
            return Integer.MIN_VALUE;
        }else{
            return (int) res * sign;
        }
    }

    public static void main(String[] args) {
        String s = "-91283472332";
        System.out.println(myAtoi(s));
    }
}
