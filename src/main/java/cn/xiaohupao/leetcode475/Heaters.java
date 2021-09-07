package cn.xiaohupao.leetcode475;

import java.util.Arrays;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/7 22:45
 */
public class Heaters {

    public static int findRadius(int[] houses, int[] heaters){

        //对两个数组进行排序
        Arrays.sort(houses);
        Arrays.sort(heaters);

        //获得供暖器的个数
        int n = heaters.length;

        int res = 0;

        //遍历每个房子
        for (int house: houses){
            //用二分法找到当前房子右边的供暖器
            int lo = 0, hi = n;
            while (lo < hi){
                int mid = ((hi - lo) >> 1) + lo;
                if (heaters[mid] < house){
                    lo = mid + 1;
                }else{
                    hi = mid;
                }
            }

            int rightDis = hi == n ? Integer.MAX_VALUE : Math.abs(house - heaters[hi]);
            int LeftDis = hi == 0 ? Integer.MAX_VALUE : Math.abs(house - heaters[hi-1]);

            res = Math.max(res, Math.min(rightDis, LeftDis));
        }

        return res;
    }

    public static void main(String[] args) {
        int[] houses = {1,5};
        int[] heaters = {2};
        System.out.println(findRadius(houses, heaters));
    }
}
