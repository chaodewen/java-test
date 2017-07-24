package recruit.intern.webank.online;

import java.util.Scanner;

/**
 * Created by Cc on 2017/4/25.
 */

public class Job {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            int n = s.nextInt();
            int a = s.nextInt(), b = s.nextInt(), c = s.nextInt();
            System.out.println(solve(n, a, b, c));
        }
        s.close();
    }
    private static int solve(int n, int a, int b, int c) {
        int ans = 0, suma, sumb, sumc;
        for (int i = 0; i <= a; i ++) {
            suma = i * 5;
            if(suma > n)
                break;
            for (int j = 0; j <= b; j++) {
                sumb = suma + j * 8;
                if(sumb > n)
                    break;
                for (int k = 0; k <= c; k++) {
                    sumc = sumb + k * 10;
                    if(sumc == n) {
                        ans++;
//                        System.out.println("(" + i + ", " + j + ", " + k + ")");
                    }
                    if(sumc > n)
                        break;
                }
            }
        }
        return ans;
    }
}