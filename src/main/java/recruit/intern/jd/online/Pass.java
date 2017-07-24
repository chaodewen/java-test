package recruit.intern.jd.online;

import java.util.Scanner;

/**
 * Created by Cc on 2017/4/7.
 */

public class Pass {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            double[] p = new double[n];
            for(int i = 0; i < n; i ++)
                p[i] = ((double) s.nextInt()) / 100;

            solve(n, p);
        }
        s.close();
    }
    private static void solve(int n, double[] p) {
        int passN = (int) Math.ceil(0.6 * n);
        double dp[][] = new double[n + 1][n + 1];

        dp[0][0] = 1;
        search(dp, p);

        print(dp, n, passN);
    }
    private static void print(double[][] dp, int n, int passN) {
        double ans = 0;
        for (int i = passN; i <= n; ++i) {
            ans += dp[n][i];
        }
        System.out.printf("%.5f\n", ans);
    }
    private static void search(double[][] dp, double p[]) {
        for (int i = 1; i <= p.length; ++i) {
            double temp = dp[i - 1][0];
            dp[i][0] = temp * (1 - p[i - 1]);
            for (int j = 1; j <= i; ++j) {
                double temp2 = dp[i - 1][j] * (1 - p[i - 1]);
                double temp3 = dp[i - 1][j - 1] * p[i - 1];
                dp[i][j] = temp2 + temp3;
            }
        }
    }
}