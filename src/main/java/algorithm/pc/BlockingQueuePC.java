package algorithm.pc;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Cc on 2017/4/24.
 */

public class BlockingQueuePC {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        Producer producer = new Producer(queue, 3);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
    private static class Producer implements Runnable {
        BlockingQueue<Integer> queue;
        int maxSize;
        private Producer(BlockingQueue<Integer> queue, int maxSize) {
            this.queue = queue;
            this.maxSize = maxSize;
        }
        @Override
        public void run() {
            while (true) {
                int elem = new Random().nextInt();
                System.out.println("Produce element : " + elem);
                queue.offer(elem);
            }
        }
    }
    private static class Consumer implements Runnable {
        BlockingQueue<Integer> queue;
        private Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }
        @Override
        public void run() {
            while (true) {
                System.out.println("Consume element : " + queue.peek());
                queue.poll();
            }
        }
    }
}