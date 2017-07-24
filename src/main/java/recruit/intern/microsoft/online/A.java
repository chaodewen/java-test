package recruit.intern.microsoft.online;

import java.util.Scanner;

/**
 * Created by Cc on 2017/3/31.
 */

public class A {
    private static int p, q, n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            p = scanner.nextInt();
            q = scanner.nextInt();
            n = scanner.nextInt();

            System.out.printf("%.2f\n", search(p / 100d, 0, 0, 1, true) + search((100 - p) / 100d, 0, 0, 0, false));
        }
        scanner.close();
    }
    private static double search(double lastp, double path, int level, int l, boolean reset) {
        if(lastp == 0)
            return 0;

        if(l == n || n == 0)
            return path * (level + 1);

        if(reset) {
            double newp = ((double) (p / (int) Math.pow(2, l))) / 100d;
            double newpath = (path == 0 ? lastp * newp : path * newp);
            double newpath2 = (path == 0 ? lastp * (1 - newp) : path * (1 - newp));
            return search(newp, newpath, level + 1, l + 1, true) + search(1 - newp, newpath2, level + 1, l, false);
        }
        else {
            double newp = (lastp + q / 100d) > 1 ? 1 : (lastp + q / 100d);
            double newpath = (path == 0 ? lastp * newp : path * newp);
            double newpath2 = (path == 0 ? lastp * (1 - newp) : path * (1 - newp));
            return search(newp, newpath, level + 1, l + 1, true) + search(1 - newp, newpath, level + 1, l, false);
        }
    }
}