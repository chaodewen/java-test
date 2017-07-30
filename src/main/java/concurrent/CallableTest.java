package concurrent;

import java.util.concurrent.Callable;

/**
 * Created by Cc on 2017/7/28.
 */
public class CallableTest implements Callable {
    private String text;

    public CallableTest(String text) {
        this.text = text;
    }

    @Override
    public Object call() throws Exception {
        int num = 0;
        for(int i = 0; i < 100; i ++) {
            System.out.println(text + ":" + i);
        }
        System.out.println("num : " + ++ num);

        return num;
    }
}