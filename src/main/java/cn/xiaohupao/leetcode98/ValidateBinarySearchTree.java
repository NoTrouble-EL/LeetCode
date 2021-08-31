package cn.xiaohupao.leetcode98;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/17 21:26
 */
public class ValidateBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
     * A valid BST is defined as follows:
     * The left subtree of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        double res = -Double.MAX_VALUE;

        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            if (node.val <= res){
                return false;
            }
            res = node.val;

            root = node.right;
        }

        return true;
    }

    public static boolean isValidBST2(TreeNode root){
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean helper(TreeNode root, long min, long max){
        //corner case
        if (root == null){
            return true;
        }

        //根节点在最小值和最大值之中，递归左子树在最小值和根节点之间，递归右子树在根节点和最大值之间
        return root.val > min && root.val < max && helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        System.out.println(isValidBST2(root));
        System.out.println(isValidBST(root));
    }
}
