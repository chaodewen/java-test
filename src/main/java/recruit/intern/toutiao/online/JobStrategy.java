package recruit.intern.toutiao.online;

import java.util.Scanner;

/**
 * Created by Cc on 2017/4/18.
 */

public class JobStrategy {
    private static int n, k, ans;
    private static int[][] job;
    private static boolean[][] rec;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            n = s.nextInt();
            k = s.nextInt();
            job = new int[n][n];
            rec = new boolean[n][n];
            for(int i = 0; i < n; i ++)
                for(int j = 0; j < i + 1; j ++)
                    job[i][j] = s.nextInt();
            ans = 0;
            solve(n - 1, n - 1, 0);
            System.out.println(ans);
        }
        s.close();
    }
    private static void solve(int row, int col, int cnt) {
        if(cnt == k) {
            int sum = 0;
            for(int i = 0; i < n; i ++)
                for(int j = 0; j < i + 1; j ++)
                    if(rec[i][j])
                        sum += job[i][j];
            ans = Math.max(sum, ans);
        }
        else if(row >= 0 && cnt < k) {
            if(row == n - 1 || rec[row + 1][col] && rec[row + 1][col + 1]) {
                rec[row][col] = true;
                if(col == 0)
                    solve(row - 1, row - 1, cnt + 1);
                else
                    solve(row, col - 1, cnt + 1);
                rec[row][col] = false;
            }

            if(col == 0)
                solve(row - 1, row - 1, cnt);
            else
                solve(row, col - 1, cnt);
        }
    }
}