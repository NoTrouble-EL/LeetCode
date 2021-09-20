package cn.xiaohupao.leetcode817;

import java.util.HashSet;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/20 14:38
 */
public class LinkedListComponents {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this(val);
            this.next = next;
        }
    }

    public static int numComponents(ListNode head, int[] nums){
        //线性扫描
        //创建一个set用于保存nums中的元素
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }

        //遍历链表
        int res = 0;
        while (head != null){
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))){
                res++;
            }
            head = head.next;
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int i = 1; i < 5; i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        int[] nums = {0,3,1,4};
        System.out.println(numComponents(head, nums));
    }
}
