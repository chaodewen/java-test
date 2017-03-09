package concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Cc on 2017/3/9.
 */

public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10, true); // 10个理发师公平理发
        boolean[] customers = new boolean[100]; // 100个顾客
        Thread[] threads = new Thread[100]; // 100个线程处理100个顾客的问题
        for(int i = 0; i < threads.length; i ++)
            threads[i] = new Thread(new Haircut(semaphore, customers, i));
        for(Thread thread : threads)
            thread.start();
    }
}

class Haircut implements Runnable {
    Semaphore semaphore;
    boolean[] customers; // 未理发的顾客
    int customerId;

    public Haircut(Semaphore semaphore, boolean[] customers, int customerId) {
        this.semaphore = semaphore;
        this.customers = customers;
        this.customerId = customerId;
    }

    private void cut(int customerId) {
        try {
            semaphore.acquire();
            System.out.println(findCustomer() + " 理发中 ......");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private int findCustomer() {
        // 这里理论上需要加锁
        // 防止多个理发师同时处理同一个顾客
        synchronized (customers) {
            for(int i = 0; i < customers.length; i ++)
                if(!customers[i]) {
                    customers[i] = true;
                    return i;
                }
            return -1;
        }
    }

    @Override
    public void run() {
        cut(customerId);
    }
}