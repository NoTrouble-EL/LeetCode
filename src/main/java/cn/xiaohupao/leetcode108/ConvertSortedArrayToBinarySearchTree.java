package cn.xiaohupao.leetcode108;

/**
 * @Author: xiaohupao
 * @Date: 2021/8/31 15:42
 */
public class ConvertSortedArrayToBinarySearchTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Given an integer array nums where the elements are sorted in ascending order,
     * convert it to a height-balanced binary search tree.
     *
     * A height-balanced binary tree is a binary tree in which
     * the depth of the two subtrees of every node never differs by more than one.
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums){
        return helper(nums, 0, nums.length-1);
    }

    private static TreeNode helper(int[] nums, int start, int end){
        //corner case
        if (start > end){
            return null;
        }

        //取中间值作为根节点
        int mid = ((end - start) >> 1) + start;
        TreeNode root = new TreeNode(nums[mid]);
        //递归构建左子树
        root.left = helper(nums, start, mid-1);
        //递归构建右子树
        root.right = helper(nums, mid+1, end);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode res = sortedArrayToBST(nums);
        System.out.println(res);
    }
}
