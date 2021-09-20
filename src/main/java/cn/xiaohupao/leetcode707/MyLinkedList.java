package cn.xiaohupao.leetcode707;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/20 13:38
 */
public class MyLinkedList {

    private int size;
    private Node head;
    private Node tail;

    class Node{
        private int val;
        private Node next;
        private Node prev;

        public Node(int val){
            this.val = val;
        }
    }

    public MyLinkedList(){
        this.size = 0;
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index){
        if (index < 0 || index >= size){
            return -1;
        }
        if (index < (size >> 1)){
            Node temp = head;
            for (int i = 0; i <= index; i++){
                temp = temp.next;
            }

            return temp.val;
        }else{
            Node temp = tail;
            for (int i = 0; i < size - index; i++){
                temp = temp.prev;
            }

            return temp.val;
        }
    }

    public void addAtHead(int val){
        addAtIndex(0, val);
    }

    public void addAtTail(int val){
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val){
        if (index < 0 || index > size){
            return;
        }
        Node pre,after;
        if (index < (size >> 1)){
            pre = head;
            for (int i = 0; i < index; i++){
                pre = pre.next;
            }
            after = pre.next;
        }else{
            after = tail;
            for (int i = 0; i < size - index; i++){
                after = after.prev;
            }
            pre = after.prev;
        }

        Node newNode = new Node(val);
        newNode.next = after;
        after.prev = newNode;
        pre.next = newNode;
        newNode.prev = pre;

        size++;
    }

    public void deleteAtIndex(int index){
        if (index < 0 || index >= size){
            return;
        }

        Node pre, after;
        if (index < (size >> 1)){
            pre = head;
            for (int i = 0; i < index; i++){
                pre = pre.next;
            }
            after = pre.next.next;
        }else{
            after = tail;
            for (int i = 0; i < size - index - 1; i++){
                after = after.prev;
            }
            pre = after.prev.prev;
        }

        pre.next = after;
        after.prev = pre;

        size--;
    }
}
