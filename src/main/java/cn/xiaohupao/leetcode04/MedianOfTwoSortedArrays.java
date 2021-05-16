package cn.xiaohupao.leetcode04;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/16 19:52
 */
public class MedianOfTwoSortedArrays {

    /**
     * Given two sorted arrays nums1 and nums2 of size m and n respectively,
     * return the median of the two sorted arrays.
     * The overall run time complexity should be O(log (m+n)).
     * @param nums1 sorted Array1
     * @param nums2 sorted Array2
     * @return median of the two sorted arrays
     *
     * time: O(log(min(m, n)))
     * space: O(1)
     */
    public static double findMedianOfTwoSortedArrays(int[] nums1, int[] nums2){
        if (nums1.length > nums2.length){
            return findMedianOfTwoSortedArrays(nums2, nums1);
        }

        int n = nums1.length, m = nums2.length, N = n+m;
        int i = 0, j = n;
        while (i <= j){
            int cut1 = ((j - i) >> 1) + i;
            int cut2 = (N >> 1) - cut1;

            int L1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int R1 = cut1 == n ? Integer.MAX_VALUE : nums1[cut1];
            int L2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];
            int R2 = cut2 == m ? Integer.MAX_VALUE : nums2[cut2];

            if (L1 > R2){
                j = cut1 - 1;
            }else if (L2 > R1){
                i = cut1 + 1;
            }else {
                if (N % 2 == 0){
                    L1 = L1 > L2 ? L1 : L2;
                    R1 = R1 < R2 ? R1 : R2;
                    return ((L1 + R1) / 2.0);
                }else{
                    R1 = R1 < R2 ? R1 : R2;
                    return R1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(findMedianOfTwoSortedArrays(nums1, nums2));
    }
}
