package cn.xiaohupao.leetcode144;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/1 20:59
 */
public class BinaryTreePreorderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        //corner case
        if (root == null){
            return res;
        }
        dfs(root, res);

        return res;
    }

    private static void dfs(TreeNode root, List<Integer> res){
        //corner case
        if (root == null){
            return;
        }
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;

        System.out.println(preorderTraversal(root));
    }
}
