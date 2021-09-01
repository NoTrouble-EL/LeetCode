package cn.xiaohupao.leetcode114;


/**
 * @Author: xiaohupao
 * @Date: 2021/9/1 20:27
 */
public class FlattenBinaryTreeToLinkedList {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode pre = null;

    public static void flatten(TreeNode root){
        //采用右左根的遍历方式
        if (root == null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        //处理根，改成为单向链表
        root.right = pre;
        root.left = null;
        pre = root;
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

        flatten(root);
        System.out.println(root);
    }
}
