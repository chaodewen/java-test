package recruit.intern.baidu.online;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Cc on 2017/4/27.
 */

public class Permutation {
    private static int ans;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt(), k = s.nextInt();
            ans = 0;
            solve(n, k, new ArrayList<Integer>());
            System.out.println(ans);
        }
        s.close();
    }
    private static void solve(int n, int k, ArrayList<Integer> list) {
        if(list.size() == n) {
//            for(Integer i : list)
//                System.out.print(i + " ");
//            System.out.println();
            handle(n, k, list);
        }
        else {
            for(int i = 1; i <= n; i ++)
                if(!list.contains(i)) {
                    list.add(i);
                    solve(n, k, list);
                    list.remove(list.size() - 1);
                }
        }
    }
    private static void handle(int n, int k, ArrayList<Integer> list) {
        int larger = n - k - 1, smaller = k;
        for(int i = 1; i < list.size(); i ++) {
            if(list.get(i) > list.get(i - 1))
                smaller --;
            else if(list.get(i) < list.get(i - 1))
                larger --;
            else
                return;
        }
        if(larger >= 0 && smaller >= 0)
            ans = (ans + 1) % 2017;
    }
}