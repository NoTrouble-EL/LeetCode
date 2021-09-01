package cn.xiaohupao.leetcode124;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/1 20:37
 */
public class BinaryTreeMaximumPathSum {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root){
        helper(root);

        return max;
    }

    private static int helper(TreeNode root){
        //corner case
        if (root == null){
            return 0;
        }

        //递归计算左右子树的最大贡献，小于0则舍去
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));


        //跟新最大值
        int passRoot = root.val + left + right;
        max = Math.max(max, passRoot);

        //返回当前节点的最大共享
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;

        System.out.println(maxPathSum(root));
    }
}
