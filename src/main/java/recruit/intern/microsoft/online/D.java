package recruit.intern.microsoft.online;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Cc on 2017/3/31.
 */

public class D {
    private static int cnt;
    private static ArrayList<String> results;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String str = scanner.nextLine();
            solve(str);
        }
        scanner.close();
    }
    private static void solve(String str) {
        cnt = 0;
        results = new ArrayList<String>();
        System.out.print(Math.abs(cal(str)) + " ");
        search(str, 0);
        System.out.println(cnt);
    }
    private static void search(String str, int start) {
        int cal = cal(str);

        if(cal == 0) {
            cnt ++;
            for(String s : results)
                if(s.equals(str))
                    return;

            results.add(str);
            return;
        }


        StringBuilder sb = new StringBuilder(str);

        if(cal > 0) {
            for(int i = start + 1; i <= str.length(); i ++) {
                sb.insert(i, ')');
                if(cal(sb.toString()) < cal)
                    search(sb.toString(), i + 1);
                sb.deleteCharAt(i);
            }
        }
        else {
            for(int i = start; i < str.length(); i ++) {
                sb.insert(i, '(');
                if(cal(sb.toString()) > cal)
                    search(sb.toString(), i + 1);
                sb.deleteCharAt(i);
            }
        }
    }
    private static int cal(String str) {
        int left = 0, right = 0;

        for(char c : str.toCharArray()) {
            if (c == '(')
                left ++;
            else
                right ++;
        }

        return left - right;
    }
}