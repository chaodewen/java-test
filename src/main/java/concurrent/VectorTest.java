package concurrent;

import java.util.Vector;

/**
 * Created by Dewayne on 2016/11/9.
 */

/**
 * 深入理解Java虚拟机代码清单13-2
 *
 * 意图是说明Vector是线程安全容器
 * 但是因为只是给add()、get()、size()等方法加synchronized关键字
 * 所以这段代码还是会抛出数组越界访问的异常
 * 需要在后面两个for循环外再加synchronized关键字
 *
 * 原因是for循环中调用size()取到vector长度后
 * 另一个线程可能调用remove()导致要get()的i失效
 *
 * 出错需要等待一段时间
 */
public class VectorTest {
    private static Vector<Integer> vector = new Vector<>();
    public static void main(String[] args) {
        while(true) {
            for (int i = 0; i < 10; i++)
                vector.add(i);

            Thread removeThread = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++)
                    vector.remove(i);
            });

            Thread printThread = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++)
//                    System.out.println(vector.get(i));
                    vector.get(i);
            });

            removeThread.start();
            printThread.start();

            // 不要同时产生过多线程，否则导致系统假死
            while (Thread.activeCount() > 20) ;
        }
    }
}