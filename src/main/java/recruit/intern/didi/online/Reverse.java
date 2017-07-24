package recruit.intern.didi.online;

import java.util.Scanner;

/**
 * Created by Cc on 2017/4/22.
 */

public class Reverse {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(reverseWords(s.nextLine()));
        s.close();
    }
    private static String reverseWords(String s) {
        String[] strings = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < strings.length; i ++)
            if(!strings[i].isEmpty()) {
                StringBuilder temp = new StringBuilder();
                for(int j = strings[i].length() - 1; j >= 0; j --) {
                    temp.append(strings[i].charAt(j));
                }
                if(sb.length() != 0)
                    sb.append(" " + temp);
                else
                    sb.append(temp);
            }

        return sb.toString();
    }
}