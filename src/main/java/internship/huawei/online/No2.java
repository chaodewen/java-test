package internship.huawei.online;

import java.util.Scanner;

/**
 * Created by Cc on 2017/3/17.
 */

public class No2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] cnt = new int[5];
        while (s.hasNext()) {
            String str = s.next();

            for(int i = 0; i < str.length(); i ++)
                if(str.charAt(i) == '1')
                    cnt[i] ++;
        }
        int ans = cnt[0];
        for(int i = 1; i < cnt.length; i ++)
            ans = ans > cnt[i] ? cnt[i] : ans;

        System.out.println(ans);
    }
}