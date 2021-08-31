package cn.xiaohupao.leetcode641;

/**
 * @Author: Wukun
 * @Date: 2021/8/17下午3:52
 */
public class DesignCircularDeque {

    /**
     * Design your implementation of the circular double-ended queue (deque).
     */
    class MyCircularDeque{

        private int[] queue;
        private int front;
        private int rear;
        private int capacity;

        /**
         * Initializes the deque with a maximum size of k.
         * @param k
         */
        public MyCircularDeque(int k){
            queue = new int[k+1];
            capacity = k+1;
            front = 0;
            rear = 0;
        }

        /**
         * Adds an item at the front of Deque.
         * Returns true if the operation is successful, or false otherwise.
         * @param value
         * @return
         */
        public boolean insertFront(int value){
            if (isFull()){
                return false;
            }
            front = (front - 1 + capacity) % capacity;
            queue[front] = value;
            return true;
        }

        /**
         * Adds an item at the rear of Deque.
         * Returns true if the operation is successful, or false otherwise.
         * @param value
         * @return
         */
        public boolean insertLast(int value){
            if (isFull()){
                return false;
            }
            queue[rear] = value;
            rear = (rear+1)%capacity;
            return true;
        }

        /**
         * Deletes an item from the front of Deque.
         * Returns true if the operation is successful, or false otherwise.
         * @return
         */
        public boolean deleteFront(){
            if (isEmpty()){
                return false;
            }
            front = (front+1)%capacity;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque.
         * Returns true if the operation is successful, or false otherwise.
         * @return
         */
        public boolean deleteLast(){
            if (isEmpty()){
                return false;
            }
            rear = (rear-1+capacity)%capacity;
            return true;
        }

        /**
         * Returns the front item from the Deque.
         * Returns -1 if the deque is empty.
         * @return
         */
        public int getFront(){
            if (isEmpty()){
                return -1;
            }

            return queue[front];
        }

        /**
         * Returns the last item from Deque.
         * Returns -1 if the deque is empty.
         * @return
         */
        public int getRear(){
            if (isEmpty()){
                return -1;
            }

            return queue[(rear-1+capacity)%capacity];
        }

        /**
         * Returns true if the deque is empty, or false otherwise.
         * @return
         */
        public boolean isEmpty(){
            return front == rear;
        }

        /**
         *  Returns true if the deque is full, or false otherwise.
         * @return
         */
        public boolean isFull(){
            return front == (rear + 1) % capacity;
        }
    }
}
