package cn.xiaohupao.leetcode346;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Wukun
 * @Date: 2021/8/17下午4:31
 */
public class MovingAverageFromDataStream {

    /**
     * Given a stream of integers and a window size,
     * calculate the moving average of all integers in the sliding window.
     */
    class MovingAverage{
        private int size;
        private int sum = 0;
        private int count = 0;
        private Deque<Integer> queue = new ArrayDeque<>();

        /**
         * Initializes the object with the size of the window size.
         * @param size
         */
        public MovingAverage(int size){
            this.size = size;
        }

        /**
         * Returns the moving average of the last size values of the stream.
         * @param val
         * @return
         */
        public double next(int val){
            count++;
            queue.add(val);
            int num = count > size ? queue.poll() : 0;
            sum = sum + val - num;

            return sum * 1.0 / Math.min(count, size);
        }
    }
}
