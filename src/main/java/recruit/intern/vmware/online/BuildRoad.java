package recruit.intern.vmware.online;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Cc on 2017/3/29.
 */

//未完成
public class BuildRoad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            boolean[][] rec = new boolean[n][n];

            for(int i = 0; i < n - 1; i ++) {
                int a = scanner.nextInt(), b = scanner.nextInt();
                rec[a - 1][b - 1] = true;
                rec[b - 1][a - 1] = true;
            }

            ArrayList<Integer> path = new ArrayList<Integer>();
            int max = 0;
            for(int i = 1; i < n; i ++) {
                path.add(i);
                int temp = search(rec, n, i, path, new ArrayList<Integer>());
                max = max < temp ? temp : max;
                path.remove(path.size() - 1);
            }

            System.out.println(max);
        }
        scanner.close();
    }
    private static int search(boolean[][] rec, int n, int start, ArrayList<Integer> path, ArrayList<Integer> nonpath) {
        if(start > n)
            return 0;

        int ans = 0;
        for(int i = start + 1; i <= n; i ++) {
            if(!nonpath.contains(i) && !path.contains(i)) {
                for(Integer j : path) {
                    if(rec[j - 1][i - 1]) {
                        path.add(i);
                        int tempmax = 0;
                        ArrayList<Integer> newpath = new ArrayList<Integer>();
                        for(int k = start + 1; k <= n; k ++) {
                            newpath.add(k);
                            int temp = search(rec, n, start + 1, newpath, path);
                            tempmax = tempmax > temp ? tempmax : temp;
                            newpath.remove(newpath.size() - 1);
                        }
                        int now = (path.size() - 1) * tempmax;
                        ans = ans > now ? ans : now;
                        path.remove(path.size() - 1);
                    }
                }
            }
        }

        return ans;
    }
}