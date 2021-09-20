package cn.xiaohupao.leetcode1171;

import java.util.HashMap;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/20 15:28
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedList {

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

    public static ListNode removeZeroSumSublists(ListNode head){
        //利用前缀和

        //构建一个dummy节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int sum = 0;
        HashMap<Integer, ListNode> map = new HashMap<>();
        for (ListNode p = dummy; p != null; p = p.next){
            sum += p.val;
            map.put(sum, p);
        }

        //第二次遍历
        sum = 0;
        for (ListNode p = dummy; p != null; p = p.next){
            sum += p.val;
            p.next = map.get(sum).next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(-3);
        ListNode node4 = new ListNode(-2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode res = removeZeroSumSublists(head);
    }
}
