package cn.xiaohupao.leetcode82;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/7 12:14
 */
public class RemoveDuplicatesFromSortedListII {
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
     * Given the head of a sorted linked list,
     * delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
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

        ListNode dummy = new ListNode(-1, head);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null && cur.next != null){
            while (cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            if (pre.next != cur){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }

        return dummy.next;
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
