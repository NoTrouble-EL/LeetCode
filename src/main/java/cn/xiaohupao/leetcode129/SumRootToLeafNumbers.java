package cn.xiaohupao.leetcode129;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/1 20:52
 */
public class SumRootToLeafNumbers {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int sumNumbers(TreeNode root){
        //corner case
        if (root == null){
            return 0;
        }

        return helper(root, 0);
    }

    private static int helper(TreeNode root, int sum){
        // corner case
        if (root == null){
            return 0;
        }

        //记录当前的值
        int res = sum * 10 + root.val;

        //遍历到叶子节点则返回
        if (root.left == null && root.right == null){
            return res;
        }

        return helper(root.left, res) + helper(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        System.out.println(sumNumbers(root));
    }
}
