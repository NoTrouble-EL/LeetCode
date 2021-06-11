package cn.xiaohupao.leetcode94;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/11 10:57
 */
public class BinaryTreeInorderTraversal {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Given the root of a binary tree, return the inorder traversal of its nodes' values.
     * @param root root of a binary tree
     * @return inorder traversal
     *
     * time: O(n)
     * space: O(n)
     */
    public static List<Integer> inorderTraversal1(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else {
                TreeNode node = stack.pop();
                res.add(node.val);
                root = node.right;
            }
        }

        return res;
    }

    public static List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        inorder(res, root);

        return res;
    }

    private static void inorder(List<Integer> res, TreeNode root){
        if (root == null){
            return;
        }
        inorder(res, root.left);
        res.add(root.val);
        inorder(res, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;

        System.out.println(inorderTraversal1(root));
        System.out.println(inorderTraversal2(root));
    }
}
