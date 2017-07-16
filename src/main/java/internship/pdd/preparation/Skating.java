package internship.pdd.preparation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Cc on 2017/7/15.
 *
 * POJ 1088 Runtime Error
 */
public class Skating {
    private static int R, C;
    private static int[][] dp, h;
    private static Height[] heights;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            R = scanner.nextInt();
            C = scanner.nextInt();

            dp = new int[R][C];
            h = new int[R][C];
            heights = new Height[R * C];

            for(int i = 0; i < R; i ++) {
                for(int j = 0; j < C; j ++) {
                    int height = scanner.nextInt();
                    h[i][j] = height;
                    heights[i * R + j] = new Height(height, i, j);
                    dp[i][j] = -1;
                }
            }

            Arrays.sort(heights, Comparator.comparingInt(o -> o.h));

            int max = 0;
            for(int i = 0; i < R * C; i ++) {
                max = Math.max(findMin(heights[i].x, heights[i].y), max);
            }

            System.out.println(max);
        }
        scanner.close();
    }
    private static int findMin(int i, int j) {
        if(i < 0 || i >= R || j < 0 || j >= C) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = 0, down = 0, left = 0, right = 0;

        if(i - 1 >= 0 && h[i - 1][j] > h[i][j]) {
            if(dp[i - 1][j] == -1) {
                dp[i - 1][j] = findMin(i - 1, j);
            }
            up = dp[i - 1][j];
        }

        if(i + 1 < R && h[i + 1][j] > h[i][j]) {
            if(dp[i + 1][j] == -1) {
                dp[i + 1][j] = findMin(i + 1, j);
            }
            down = dp[i + 1][j];
        }

        if(j - 1 >= 0 && h[i][j - 1] > h[i][j]) {
            if(dp[i][j - 1] == -1) {
                dp[i][j - 1] = findMin(i, j - 1);
            }
            left = dp[i][j - 1];
        }

        if(j + 1 < C && h[i][j + 1] > h[i][j]) {
            if(dp[i][j + 1] == -1) {
                dp[i][j + 1] = findMin(i, j + 1);
            }
            right = dp[i][j + 1];
        }

        int max = Math.max(Math.max(up, down), Math.max(left, right));

        dp[i][j] = ++ max;

        return dp[i][j];
    }
}

class Height {
    int h, x, y;

    Height(int h, int x, int y) {
        this.h = h;
        this.x = x;
        this.y = y;
    }
}