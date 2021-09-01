package cn.xiaohupao.leetcode113;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/1 20:17
 */
public class PathSumII {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum){
        //创建一个List用于保存结果
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        helper(root, targetSum, res, new ArrayList<>());

        return res;
    }

    //backtracking
    private static void helper(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.val);
        targetSum = targetSum - root.val;
        //若到叶子节点，且目标值为0则将list添加到res中
        if (root.left == null && root.right == null && targetSum == 0){
            res.add(new ArrayList<>(list));
        }

        helper(root.left, targetSum, res, list);
        helper(root.right, targetSum, res, list);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;

        System.out.println(pathSum(root, 22));
    }
}
