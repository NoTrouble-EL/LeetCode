package cn.xiaohupao.leetcode142;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/19 21:13
 */
public class LinkedListCycleII {
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

    public static ListNode detectCycle(ListNode head){
        //corner case
        if (head == null || head.next == null){
            return null;
        }

        //快慢指针
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            //找到环
            if (slow == fast){
                ListNode temp = head;
                while (temp != slow){
                    temp = temp.next;
                    slow = slow.next;
                }

                return temp;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        ListNode res = detectCycle(head);
    }
}
