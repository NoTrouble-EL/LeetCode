package cn.xiaohupao.leetcode25;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/20 17:09
 */
public class ReverseNodesInKGroup {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
     * k is a positive integer and is less than or equal to the length of the linked list.
     * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
     * @param head given a linked list
     * @param k int - k at a time
     * @return ListNode - modified list head
     *
     * time: O(n)
     * space: O(n)
     */
    public static ListNode reverseKGroup(ListNode head, int k){
        if (head == null || head.next == null){
            return head;
        }

        int count = 0;
        ListNode cur = head;

        while (cur != null && count != k){
            cur = cur.next;
            count++;
        }

        if (count == k){
            cur = reverseKGroup(cur, k);
            while (count-- > 0){
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }

    public static ListNode reverseKGroup1(ListNode head, int k){
        if (head == null){
            return head;
        }

        ListNode A = head, B = head;
        for (int i = 0; i < k; i++){
            if (B == null){
                return head;
            }
            B = B.next;
        }

        ListNode newHead = reverse(A, B);
        A.next = reverseKGroup1(B, k);

        return newHead;
    }

    private static ListNode reverse(ListNode A, ListNode B){
        ListNode pre = null, cur = A;
        while (cur != B){
            ListNode after = cur.next;
            cur.next = pre;
            pre = cur;
            cur = after;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i < 6; i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        //ListNode res = reverseKGroup(head, 2);
        ListNode res = reverseKGroup1(head, 2);
        System.out.println(res);
    }
}
