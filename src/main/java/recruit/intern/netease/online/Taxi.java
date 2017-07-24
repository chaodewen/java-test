package recruit.intern.netease.online;

import java.util.Scanner;

/**
 * Created by Cc on 2017/3/25.
 */

public class Taxi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] tx = new int[n], ty = new int[n];

            for(int i = 0; i < n; i ++)
                tx[i] = scanner.nextInt();

            for(int i = 0; i < n; i ++)
                ty[i] = scanner.nextInt();

            int gx = scanner.nextInt(), gy = scanner.nextInt();
            int walktime = scanner.nextInt(), taxitime = scanner.nextInt();

            cal(n, tx, ty, gx, gy, walktime, taxitime);
        }
    }

    private static void cal(int n, int[] tx, int[] ty, int gx, int gy, int walktime, int taxitime) {
        int min = Math.abs(gx) * walktime + Math.abs(gy) * walktime;

        for(int i = 0; i < n; i ++) {
            int temp = Math.abs(tx[i]) * walktime + Math.abs(ty[i]) * walktime
                    + Math.abs(gx - tx[i]) * taxitime + Math.abs(gy - ty[i]) * taxitime;
            min = min > temp ? temp : min;
        }

        System.out.println(min);
    }
}