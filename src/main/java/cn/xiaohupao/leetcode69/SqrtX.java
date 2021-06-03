package cn.xiaohupao.leetcode69;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/3 13:51
 */
public class SqrtX {

    /**
     * Given a non-negative integer x, compute and return the square root of x.
     * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
     * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
     * @param x a non-negative integer
     * @return square root of x
     *
     * time: O(log(n))
     * space: O(1)
     */
    public static int mySqrt(int x){
        if (x == 0){
            return 0;
        }
        int c = x;
        double x0 = x;
        while (true){
            double xi = 0.5 * (x0 + c / x0);
            if (x0 - xi < 1e-7){
                break;
            }
            x0 = xi;
        }

        return (int) x0;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }
}
