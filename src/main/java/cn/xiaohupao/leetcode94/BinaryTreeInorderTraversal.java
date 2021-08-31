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
        //创建一个List用于保存结果
        List<Integer> res = new ArrayList<>();

        //创建一个栈用于中序遍历
        Deque<TreeNode> stack = new ArrayDeque<>();

        //中序遍历的非递归实现
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

    /**
     * 中序遍历的递归实现
     * @param res
     * @param root
     */
    private static void inorder(List<Integer> res, TreeNode root){
        if (root == null){
            return;
        }
        //左
        inorder(res, root.left);
        //根
        res.add(root.val);
        //右
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
