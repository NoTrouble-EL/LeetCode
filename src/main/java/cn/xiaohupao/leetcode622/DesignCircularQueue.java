package cn.xiaohupao.leetcode622;

/**
 * @Author: Wukun
 * @Date: 2021/8/17下午2:34
 */
public class DesignCircularQueue {

    /**
     * Design your implementation of the circular queue.
     * The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle.
     * It is also called "Ring Buffer".
     * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue.
     * In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue.
     * But using the circular queue, we can use the space to store new values.
     */
    class MyCircularQueue{

        private int[] queue;
        private int headIndex;
        private int count;
        private int capacity;

        /**
         *  Initializes the object with the size of the queue to be k.
         * @param k
         */
        public MyCircularQueue(int k){
            this.queue = new int[k];
            this.headIndex = 0;
            this.count = 0;
            this.capacity = k;
        }

        /**
         * Inserts an element into the circular queue.
         * Return true if the operation is successful.
         * @param value
         * @return
         */
        public boolean enQueue(int value){
            if (this.count == this.capacity){
                return false;
            }

            int tailIndex = (this.headIndex + this.count) % this.capacity;
            this.queue[tailIndex] = value;
            count++;
            return true;
        }

        /**
         * Deletes an element from the circular queue.
         * Return true if the operation is successful.
         * @return
         */
        public boolean deQueue(){
            if (this.count == 0){
                return false;
            }
            this.headIndex = (this.headIndex + 1) % this.capacity;
            count--;
            return true;
        }

        /**
         * Gets the front item from the queue. If the queue is empty, return -1.
         * @return
         */
        public int front(){
            if (this.count == 0){
                return -1;
            }

            return this.queue[this.headIndex];
        }

        /**
         * Gets the last item from the queue. If the queue is empty, return -1.
         * @return
         */
        public int rear(){
            if (this.count == 0){
                return -1;
            }
            int tailIndex = (this.headIndex + this.count - 1) % this.capacity;
            return this.queue[tailIndex];
        }

        /**
         * Checks whether the circular queue is empty or not.
         * @return
         */
        public boolean isEmpty(){
            return this.count == 0;
        }

        /**
         * Checks whether the circular queue is full or not.
         * @return
         */
        public boolean isFull(){
            return this.count == this.capacity;
        }
    }
}
