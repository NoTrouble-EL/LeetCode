package cn.xiaohupao.leetcode100;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/18 20:08
 */
public class SameTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
     * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
     * @param p root
     * @param q root
     * @return true is p and q considered the same
     *
     * time: O(min(n,m))
     * space: O(min(n,m))
     */
        public static boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null){
                return true;
            }else if (p == null || q == null){
                return false;
            }else if (p.val != q.val){
                return false;
            }else {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }

        public static void main(String[] args) {
            TreeNode root1 = new TreeNode(2);
            TreeNode node1 = new TreeNode(1);
            TreeNode node2 = new TreeNode(3);
            root1.left = node1;
            root1.right = node2;

            TreeNode root2 = new TreeNode(2);
            TreeNode node3 = new TreeNode(1);
            TreeNode node4 = new TreeNode(3);
            root2.left = node3;
            root2.right = node4;

            System.out.println(isSameTree(root1, root2));
        }

}
