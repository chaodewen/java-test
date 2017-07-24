package recruit.intern.jd.online;

import java.util.Scanner;

/**
 * Created by Cc on 2017/4/7.
 */

public class Queue {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            String str = s.next();
            solve(n, str);
        }
        s.close();
    }
    private static void solve(int n, String str) {
        boolean[] rec = new boolean[n];

        for(int i = 0; i < str.length(); i ++) {
            if(str.charAt(i) != 'X' && str.charAt(i) != '#') {
                int x = str.charAt(i) - '0', start = (i - x) >= 0 ? (i - x) : 0
                        , end = (i + x) < str.length() ? (i + x) : (str.length() - 1);
                for(int j = start; j <= end; j ++)
                    if(str.charAt(j) == 'X')
                        rec[j] = true;
            }
        }

        int ans = 0;

        for(int i = 0; i < n; i ++)
            if(rec[i])
                ans ++;

        System.out.println(ans);
    }
}