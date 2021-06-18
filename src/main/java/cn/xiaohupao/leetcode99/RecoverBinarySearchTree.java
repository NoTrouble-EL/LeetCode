package cn.xiaohupao.leetcode99;


import cn.xiaohupao.leetcode98.ValidateBinarySearchTree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/18 19:34
 */
public class RecoverBinarySearchTree {
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
     * You are given the root of a binary search tree (BST),
     * where exactly two nodes of the tree were swapped by mistake.
     * Recover the tree without changing its structure.
     * @param root root of a binary search tree
     *
     * time: O(N)
     * space: O(H) H is the height of a binary search tree
     */
    public static void recoverTree(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null, x = null, y = null;
        while(root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val){
                y = root;
                if (x == null){
                    x = pre;
                }else {
                    break;
                }
            }
            pre = root;
            root = root.right;
        }

        swap(x, y);
    }

    private static void swap(TreeNode x, TreeNode y){
        if (x == null || y == null){
            return;
        }
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        root.left = node1;
        node1.right = node2;
        recoverTree(root);
    }
}
