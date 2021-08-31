package cn.xiaohupao.leetcode95;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/11 12:31
 */
public class UniqueBinarySearchTreesII {
    private static class TreeNode {
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
     * Given an integer n, return all the structurally unique BST's (binary search trees),
     * which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
     * @param n an integer n
     * @return all the structurally
     *
     * time: O()
     * space: O()
     */
    public static List<TreeNode> generateTrees(int n){
        if (n == 0){
            return new ArrayList<>();
        }

        return helper(1, n);
    }

    private static List<TreeNode> helper(int start, int end){
        //创建一个List用于保存结果
        List<TreeNode> res = new ArrayList<>();
        //递归的出口
        if (start > end){
            res.add(null);
            return res;
        }

        //遍历每个可能为根节点的值
        for (int i = start; i <= end; i++){
            //递归左子树的可能集合
            List<TreeNode> lchild = helper(start, i-1);
            //递归右子树的可能集合
            List<TreeNode> rchild = helper(i+1, end);
            //构建左右子树并加入list中
            for (TreeNode left : lchild){
                for (TreeNode right : rchild){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        List<TreeNode> treeNodes = generateTrees(3);
        System.out.println(treeNodes);
    }
}
