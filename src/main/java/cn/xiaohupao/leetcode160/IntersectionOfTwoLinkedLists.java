package cn.xiaohupao.leetcode160;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/20 10:43
 */
public class IntersectionOfTwoLinkedLists {

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

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        //corner case
        if (headA == null || headB == null){
            return null;
        }

        ListNode l1 = headA, l2 = headB;

        while (l1 != l2){
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }

        return l1;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(8);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode headB = new ListNode(5);
        headA.next = node1;
        node1.next = node4;
        node4.next = node5;
        node5.next = node6;
        headB.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode res = getIntersectionNode(headA, headB);
    }
}
