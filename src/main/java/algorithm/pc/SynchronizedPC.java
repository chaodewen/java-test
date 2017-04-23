package algorithm.pc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Cc on 2017/3/5.
 */

public class SynchronizedPC {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Producer producer = new Producer(queue, 3);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
    // 静态内部类保证不和包中其它类冲突
    private static class Producer implements Runnable {
        private Queue<Integer> queue;
        private int maxSize;
        private Producer(Queue<Integer> queue, int maxSize) {
            this.queue = queue;
            this.maxSize = maxSize;
        }
        @Override
        public void run() {
            while (true) {
                synchronized (queue) { // 共享对象作为锁
                    while (queue.size() == maxSize) { // 要使用while()而不是if()
                        try {
                            System.out.println("Producer starts waiting ...");
                            queue.wait(); // 共享对象调用wait()
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int elem = new Random().nextInt();
                    System.out.println("Produce element : " + elem);
                    queue.offer(elem);
                    queue.notifyAll(); // 共享对象调用notifyAll()
                }
            }
        }
    }
    private static class Consumer implements Runnable {
        private Queue<Integer> queue;
        private Consumer(Queue<Integer> queue) {
            this.queue = queue;
        }
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            System.out.println("Consumer starts waiting ...");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Consume element : " + queue.peek());
                    queue.poll();
                    queue.notifyAll();
                }
            }
        }
    }
}