package algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Cc on 2017/4/24.
 */

public class LinkedBlockingQueue<E> {
    private Queue<E> queue;
    private int capacity;
    public LinkedBlockingQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }
    public boolean offer(E e) {
        synchronized (queue) {
            if (capacity > queue.size())
                return queue.offer(e);
            return false;
        }
    }
    public E poll() {
        synchronized (queue) {
            if (queue.size() > 0) {
               return queue.poll();
            }
            return null;
        }
    }
    public E peek() {
        synchronized (queue) {
            if (queue.size() > 0)
                return queue.peek();
            return null;
        }
    }
}