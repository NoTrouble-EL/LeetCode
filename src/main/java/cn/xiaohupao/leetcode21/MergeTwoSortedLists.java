package cn.xiaohupao.leetcode21;

/**
 * @Author: xiaohupao
 * @Date: 2021/5/20 12:38
 */
public class MergeTwoSortedLists {

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
     * Merge two sorted linked lists and return it as a sorted list.
     * The list should be made by splicing together the nodes of the first two lists.
     * @param l1 linked lists head
     * @param l2 linked lists head
     * @return end of the merge two lists head
     *
     * time: O(n+m)
     * space: O(1)
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if (l1 != null){
            temp.next = l1;
        }else {
            temp.next = l2;
        }

        return dummy.next;
    }

    /**
     * Merge two sorted linked lists and return it as a sorted list.
     * The list should be made by splicing together the nodes of the first two lists.
     * @param l1 linked lists head
     * @param l2 linked lists head
     * @return end of the merge two lists head
     *
     * time: O(m+n)
     * space: O(m+n)
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        if (l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l21 = l1;
        ListNode temp1 = l1;
        temp1.next = new ListNode(2);
        temp1 = temp1.next;
        temp1.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        ListNode l22 = l2;
        ListNode temp2 = l2;
        temp2.next = new ListNode(3);
        temp2 = temp2.next;
        temp2.next = new ListNode(4);

        ListNode res1 = mergeTwoLists1(l1, l2);
        System.out.println(res1);

        ListNode res2 = mergeTwoLists2(l21, l22);
        System.out.println(res2);
    }
}
