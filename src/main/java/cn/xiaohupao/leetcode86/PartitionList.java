package cn.xiaohupao.leetcode86;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/8 16:20
 */
public class PartitionList {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    /**
     *
     Given the head of a linked list and a value x,
     partition it such that all nodes less than x come before nodes greater than or equal to x.
     * @param head head of a linked list
     * @param x a value x
     * @return new linked list
     *
     * time: O(n)
     * space: O(1)
     */
    public static ListNode partition(ListNode head, int x){
        ListNode first = new ListNode(-1), second = new ListNode(-1);
        ListNode firstTemp = first, secondTemp = second;

        while (head != null){
            if (head.val < x){
                firstTemp.next = head;
                firstTemp = firstTemp.next;
            }else{
                secondTemp.next = head;
                secondTemp = secondTemp.next;
            }
            head = head.next;
        }
        secondTemp.next = null;
        firstTemp.next = second.next;

        return first.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode res = partition(head, 3);
        System.out.println(res);
    }
}
