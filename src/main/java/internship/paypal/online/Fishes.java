package internship.paypal.online;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Cc on 2017/4/13.
 */

public class Fishes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            int n = s.nextInt();
            ArrayList<Integer> size = new ArrayList<>(), dir = new ArrayList<>();
            for(int i = 0; i < n; i ++)
                size.add(s.nextInt());
            for(int i = 0; i < n; i ++)
                dir.add(s.nextInt());
            solve(size, dir);
        }
        s.close();
    }
    private static void solve(ArrayList<Integer> size, ArrayList<Integer> dir) {
        for(int i = 1; i < size.size();i ++) {
            if(dir.get(i) == -1 && dir.get(i - 1) == 1) {
                if(size.get(i) > size.get(i - 1)) {
                    size.remove(i - 1);
                    dir.remove(i - 1);
                }
                else if(size.get(i) < size.get(i - 1)) {
                    size.remove(i);
                    dir.remove(i);
                }
                i = 0;
            }
        }
        System.out.println(size.size());
    }
}