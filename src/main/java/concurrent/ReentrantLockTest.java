package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Cc on 2017/3/6.
 */

public class ReentrantLockTest {
    public static void main(String[] args) {

    }
}

class PrintQueue {
    private final Lock lock = new ReentrantLock(); // 默认是非公平锁
    public void print() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " has been locked.");
            System.out.println(Thread.currentThread().getName() + " is printing ...");
            Thread.sleep(10000); // 需要catch
            System.out.println(Thread.currentThread().getName() + " finished printing and will unlock.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // 必须在finally中释放 否则如果锁守护的代码在try块之外抛出了异常 它将永远不会被释放
        }
    }
}