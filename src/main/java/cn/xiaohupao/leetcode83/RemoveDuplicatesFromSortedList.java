package cn.xiaohupao.leetcode83;



/**
 * @Author: xiaohupao
 * @Date: 2021/6/7 12:37
 */
public class RemoveDuplicatesFromSortedList {
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
     * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
     * Return the linked list sorted as well.
     * @param head head of a sorted linked list
     * @return linked list sorted as well
     *
     * time: O(n)
     * space: O(1)
     */
    public static ListNode deleteDuplicates(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode pre = head;
        while (pre.next != null){
            if (pre.val == pre.next.val){
                pre.next = pre.next.next;
            }else{
                pre = pre.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode res = deleteDuplicates(head);
    }
}
