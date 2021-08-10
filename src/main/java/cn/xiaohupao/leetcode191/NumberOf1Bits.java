package cn.xiaohupao.leetcode191;

/**
 * @Author: Wukun
 * @Date: 2021/8/10下午5:40
 */
public class NumberOf1Bits {

    public static int hammingWeight(int n){
        //Create a variable to save the result
        int res = 0;

        while (n != 0){
            n &= (n-1);
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011
        ));
    }
}
