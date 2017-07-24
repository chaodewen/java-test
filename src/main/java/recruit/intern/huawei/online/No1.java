package recruit.intern.huawei.online;

import java.util.Scanner;

/**
 * Created by Cc on 2017/3/17.
 */

public class No1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String str = s.next();
            StringBuilder sb = new StringBuilder();

            for(char c : str.toCharArray())
                if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
                    sb.append(c);

            System.out.println(sb.toString().toLowerCase());
        }
    }
}