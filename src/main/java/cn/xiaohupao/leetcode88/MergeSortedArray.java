package cn.xiaohupao.leetcode88;

import java.util.Arrays;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/9 15:11
 */
public class MergeSortedArray {

    /**
     * You are given two integer arrays nums1 and nums2,
     * sorted in non-decreasing order, and two integers m and n,
     * representing the number of elements in nums1 and nums2 respectively.
     * @param nums1 arrays num1
     * @param m number of nums1
     * @param nums2 arrays num2
     * @param n number of nums2
     *
     * time: O(m+n)
     * space: O(1)
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int i = m-1, j = n - 1, k = m+n-1;
        while (j >= 0){
            if (i >= 0 && nums1[i] >= nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
