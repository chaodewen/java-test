package recruit.intern.didi.online;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Cc on 2017/4/22.
 */

public class Child {
    private static int n;
    private static Comp[] c;
    private static int[] dp;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            n = s.nextInt();
            c = new Comp[n];
            dp = new int[n];
            Arrays.fill(dp, 1);
            for(int i = 0; i < n; i ++)
                c[i] = new Comp(s.nextInt(), s.nextInt());
            if(n == 1)
                System.out.println(1);
            else
                solve();
        }
        s.close();
    }
    private static void solve() {
        Arrays.sort(c, new Comparator<Comp>() {
            @Override
            public int compare(Comp o1, Comp o2) {
                if(o1.w == o2.w)
                    return o1.h - o2.h;
                return o1.w - o2.w;
            }
        });
//        for(int i = 0; i < c.length; i ++)
//            System.out.println(c[i].w + " " + c[i].h);
        System.out.println(cal());
    }
    private static int cal() {
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(c[i].w > c[j].w && c[i].h > c[j].h){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }

        int result = 1;
        for(int i = 0; i < n; i++){
            if(dp[i] > result){
                result = dp[i];
            }
        }
        return result;
    }
}

class Comp {
    int w, h;
    public Comp(int w, int h) {
        this.w = w;
        this.h = h;
    }
}