package cn.xiaohupao.leetcode61;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/1 17:19
 */
public class RotateList {

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
     * Given the head of a linked list, rotate the list to the right by k places.
     * @param head head of a linked list
     * @param k right by k places
     * @return head of a linked list
     *
     * time: O(n)
     * space: O(1)
     */
    public static ListNode rotateRight(ListNode head, int k){
        if (head == null || head.next== null){
            return head;
        }
        //计算出节点的个数
        int l = 1;
        //将temp指针指向最后一个节点，而不是null
        ListNode temp = head;
        while (temp.next != null){
            temp = temp.next;
            l++;
        }

        if (k % l == 0){
            return head;
        }

        k = l - (k % l);

        //成环
        temp.next = head;
        while (k-- > 0){
            temp = temp.next;
        }

        //找到结果的头结点
        ListNode res = temp.next;
        //去环
        temp.next = null;

        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i < 6; i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        ListNode res = rotateRight(head, 2);
        System.out.println(res);
    }
}
