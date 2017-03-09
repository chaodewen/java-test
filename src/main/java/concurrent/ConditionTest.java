package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Cc on 2017/3/8.
 */

/**
 * Condition的方法与Object中可以对应
 * Condition : await()、signal()、signalAll()
 * Object : wait()、notify()、notifyAll()
 */
public class ConditionTest {
    public static void main(String[] args) {
        Depot depot = new Depot(15);
        Operation operation = new Operation(depot);
        operation.put(10);
        operation.get(5);
        operation.put(20);
        operation.put(5);
        operation.get(35);
    }
}

class Operation {
    Depot depot;

    public Operation(Depot depot) {
        this.depot = depot;
    }

    public void put(int quantity) {
        new Thread(() -> depot.put(quantity)).start();
    }

    public void get(int quantity) {
        new Thread(() -> depot.get(quantity)).start();
    }
}

class Depot {
    private int used;
    private int capacity;
    private Lock lock;
    private Condition emptyCondition;
    private Condition fullCondition;

    public Depot(int capacity) {
        this.used = 0;
        this.capacity = capacity;
        this.lock = new ReentrantLock();
        emptyCondition = this.lock.newCondition();
        fullCondition = this.lock.newCondition();
    }

    public void put(int quantity) {
        lock.lock();
        try {
            while (used == capacity)
                fullCondition.await(); // 库存满保持库存满等待
            // 实际增量
            int inc = quantity > (capacity - used) ? (capacity - used) : quantity;
            used += inc;
            System.out.println(Thread.currentThread().getName() + " --- 要入库:" + quantity + " 实际入库:" + inc + " 库存量:" + used);
            emptyCondition.signal(); // 库存未满发出库存空信号,让库存空条件不再等待
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get(int quantity) {
        lock.lock();
        try {
            while(used == 0)
                emptyCondition.await(); // 库存空保持库存空等待
            // 实际减少量
            int dec = quantity > used ? used : quantity;
            used -= dec;
            System.out.println(Thread.currentThread().getName() + " --- 要出库:" + quantity + " 实际出库:" + dec + " 库存量:" + used);
            fullCondition.signal(); // 库存不空发出库存满信号,让库存满条件不再等待
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}