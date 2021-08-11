package cn.xiaohupao.leetcode371;

/**
 * @Author: Wukun
 * @Date: 2021/8/11下午3:17
 */
public class SumOfTwoIntegers {

    /**
     * Given two integers a and b,
     * return the sum of the two integers
     * without using the operators + and -
     * @param a integer
     * @param b integer
     * @return the sum of two integers
     */
    public static int getSum(int a, int b){
        //Exit the loop when the carry value is 0
        while (a != 0){
            //The result of the exclusive OR of two numbers is the value of the addition of the two numbers without carry
            int temp = a ^ b;
            //The result of adding two numbers and shifting one bit to the left is the value of the carry
            a = (a & b) << 1;
            b = temp;
        }

        return b;
    }

    public static void main(String[] args) {
        System.out.println(getSum(2, 3));
    }
}
