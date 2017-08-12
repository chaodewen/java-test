package recruit.fte.netease.online;

import java.util.Scanner;

/**
 * Created by Cc on 2017/8/12.
 */
public class Independence {
    private static int x, f, d, p;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            x = scanner.nextInt();
            f = scanner.nextInt();
            d = scanner.nextInt();
            p = scanner.nextInt();

            solve();
        }
        scanner.close();
    }
    private static void solve() {
        long max = 1;
        while(max * x <= d) {
            max ++;
        }
        max --;

        long ans = (d - x * (long) f) / (long) (x + p);
        ans = f + (ans <= 0 ? 0 : ans);

        System.out.println(max < ans ? max : ans);
    }
}