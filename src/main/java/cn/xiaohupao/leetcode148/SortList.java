package cn.xiaohupao.leetcode148;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/19 22:16
 */
public class SortList {

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

    public static ListNode sortList(ListNode head){
        //corner case
        if (head == null || head.next == null){
            return head;
        }

        //使用快慢指针将链表分成两端
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //递归排序右半
        ListNode right = sortList(slow.next);
        //防止成环
        slow.next = null;
        //递归排序左边
        ListNode left = sortList(head);

        //merge
        return merge(left, right);
    }

    private static ListNode merge(ListNode A, ListNode B){
        if (A == null){
            return B;
        }
        if (B == null){
            return A;
        }

        if (A.val < B.val){
            A.next = merge(A.next, B);
            return A;
        }else{
            B.next = merge(A, B.next);
            return B;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(0);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode res = sortList(head);
    }
}
