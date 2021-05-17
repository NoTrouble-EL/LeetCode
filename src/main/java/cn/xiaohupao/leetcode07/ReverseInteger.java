package cn.xiaohupao.leetcode07;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/17 13:39
 */
public class ReverseInteger {
    /**
     * Given a signed 32-bit integer x, return x with its digits reversed.
     * If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
     * @param x int
     * @return int - digits reversed
     *
     * time: O(log(|n|))
     * space: O(1)
     */
    public static int reverse(int x){
        long res = 0;
        while (x != 0){
            res = res * 10 + x % 10;
            x /= 10;
            if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE){
                return 0;
            }
        }
        return (int) res;
    }

    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x));
    }
}
