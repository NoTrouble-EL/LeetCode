package cn.xiaohupao.leetcode92;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/10 19:43
 */
public class ReverseLinkedListII {

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

    /**
     * Given the head of a singly linked list and two integers left and right where left <= right,
     * reverse the nodes of the list from position left to position right, and return the reversed list.
     * @param head head of a linked list
     * @param left an integer
     * @param right an integer
     * @return reverse list
     *
     * time: O(N)
     * space: O(1)
     */
    public static ListNode reverseBetween(ListNode head, int left, int right){
        //构建一个dummy节点
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        //找到pre为left的前一个
        for (int i = 0; i < left - 1; i++){
            pre = pre.next;
        }

        //cur为left节点
        ListNode cur = pre.next;

        //穿线法
        for (int i = left; i < right; i++){
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }


        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode res = reverseBetween(head, 2, 4);
    }
}
