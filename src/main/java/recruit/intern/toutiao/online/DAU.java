package recruit.intern.toutiao.online;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Cc on 2017/4/18.
 */

public class DAU {
    private static Set<Long> set;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        set = new HashSet<>();
        while(s.hasNext()) {
            long l = s.nextLong();
            if(l == 0)
                break;
            set.add(l);
        }
        System.out.println(set.size());
        s.close();
    }
}