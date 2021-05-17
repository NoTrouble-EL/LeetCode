package cn.xiaohupao.leetcode09;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/17 19:05
 */
public class PalindromeNumber {
    /**
     * Given an integer x, return true if x is palindrome integer.
     * An integer is a palindrome when it reads the same backward as forward.
     * For example, 121 is palindrome while 123 is not.
     * @param x int - Given an integer
     * @return boolean - true if x is palindrome integer
     *
     * time: O(log(n))
     * space: O(1)
     */
    public static boolean isPalindrome(int x){
        if (x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }

        int reverted = 0;
        while (x > reverted){
            reverted = reverted * 10 + x % 10;
            x /= 10;
        }

        return x == reverted || x == reverted / 10;
    }
    public static void main(String[] args) {
        int x = 1221;
        System.out.println(isPalindrome(x));
    }
}
