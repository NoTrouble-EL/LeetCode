package cn.xiaohupao.leetcode1250;

/**
 * @Author: Wukun
 * @Date: 2021/8/16下午3:20
 */
public class CheckIfItIsAGoodArray {

    public static boolean isGoodArray(int[] nums){
        // Bézout's identity
        // 裴蜀定理： 若 a,b 是整数,且 gcd(a,b)=d，
        // 那么对于任意的整数 x,y,ax+by 都一定是 d 的倍数，
        // 特别地，一定存在整数 x,y，使 ax+by=d 成立
        int res = nums[0];
        for (int i = 1; i < nums.length && res != 1; i++){
            res = gcd(res, nums[i]);
        }

        return res == 1;
    }

    private static int gcd(int a, int b){
        if (b == 0){
            return a;
        }

        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        int[] nums = {12, 5, 7, 23};
        System.out.println(isGoodArray(nums));
    }
}
