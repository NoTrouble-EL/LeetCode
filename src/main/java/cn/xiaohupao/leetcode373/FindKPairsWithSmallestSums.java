package cn.xiaohupao.leetcode373;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/5 22:36
 */
public class FindKPairsWithSmallestSums {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k){
        //使用大顶堆
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k, (a,b) ->
                (b.get(0)+b.get(1)) - (a.get(0)+a.get(1)));

        //遍历两个数组
        for (int i = 0; i < Math.min(nums1.length, k); i++){
            for (int j = 0; j < Math.min(nums2.length, k); j++){
                //队列中的元素小于k则直接加入
                if (queue.size() < k){
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums1[i]);
                    pair.add(nums2[j]);
                    queue.offer(pair);
                }else{
                    //否则取出最大的，和当前值相比，若最大值 > 当前值，那么弹出最大值，存入当前值
                    int top = queue.peek().get(0) + queue.peek().get(1);
                    if (top > nums1[i] + nums2[j]){
                        queue.poll();
                        List<Integer> pair = new ArrayList<>();
                        pair.add(nums1[i]);
                        pair.add(nums2[j]);
                        queue.offer(pair);
                    }
                }
            }
        }

        List<List<Integer>> res = new LinkedList<>();
        while (!queue.isEmpty()){
            res.add(0, queue.poll());
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,7,11}, nums2 = {2,4,6};
        System.out.println(kSmallestPairs(nums1,nums2, 3));
    }
}
