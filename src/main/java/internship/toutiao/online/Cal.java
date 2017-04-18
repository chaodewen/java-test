package internship.toutiao.online;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Cc on 2017/4/18.
 */

public class Cal {
    private static int x, y;
    private static char c;
    private static StringBuilder[] sb;
    private static String D, sz;
    private static HashMap<Character, String[]> map;
    private static void init() {
        D = "  ";
        map = new HashMap<>();
        map.put('0', new String[]{"***", "* *", "* *", "* *", "***"});
        map.put('1', new String[]{"*", "*", "*", "*", "*"});
        map.put('2', new String[]{"***", "  *", "***", "*  ", "***"});
        map.put('3', new String[]{"***", "  *", "***", "  *", "***"});
        map.put('4', new String[]{"* *", "* *", "***", "  *", "  *"});
        map.put('5', new String[]{"***", "*  ", "***", "  *", "***"});
        map.put('6', new String[]{"***", "*  ", "***", "* *", "***"});
        map.put('7', new String[]{"***", "  *", "  *", "  *", "  *"});
        map.put('8', new String[]{"***", "* *", "***", "* *", "***"});
        map.put('9', new String[]{"***", "* *", "***", "  *", "***"});
        map.put('+', new String[]{"   ", " * ", "***", " * ", "   "});
        map.put('-', new String[]{"   ", "   ", "***", "   ", "   "});
        map.put('*', new String[]{"   ", "* *", " * ", "* *", "   "});
        map.put('/', new String[]{"   ", "  *", " * ", "*  ", "   "});
        map.put('=', new String[]{"    ", "****", "    ", "****", "    "});
        map.put('.', new String[]{"  ", "  ", "  ", "**", "**"});
    }
    private static void input() {
        Scanner scanner = new Scanner(System.in);
        String[] params = scanner.nextLine().trim().split(" ");
        scanner.close();

        x = Integer.valueOf(params[0]);
        y = Integer.valueOf(params[2]);
        c = params[1].charAt(0);

        sb = new StringBuilder[5];
        for (int i = 0; i < 5; ++i) {
            sb[i] = new StringBuilder();
            for (Character cc : params[0].toCharArray()) {
                sb[i].append(map.get(cc)[i]);
                sb[i].append(D);
            }
            sb[i].append(map.get(c)[i]);
            sb[i].append(D);
            for (Character cc : params[2].toCharArray()) {
                sb[i].append(map.get(cc)[i]);
                sb[i].append(D);
            }
            sb[i].append(map.get('=')[i]);
        }
    }
    private static void preHandler() {
        switch (c) {
            case '+':
                sz = String.valueOf(x + y);
                break;
            case '-':
                sz = String.valueOf(x - y);
                break;
            case '*':
                sz = String.valueOf(x * y);
                break;
            case '/':
                float fz = x / y;
                sz = String.format("%.2f", fz);
                if (sz.charAt(sz.length()-1) == '0') {
                    if (sz.charAt(sz.length()-2) == '0') {
                        sz = sz.substring(0, sz.length() - 3);
                    } else {
                        sz = sz.substring(0, sz.length() - 1);
                    }
                }
                break;
            default:
                sz = "0";
                break;
        }
    }
    private static void handler() {
        for (int i = 0; i < 5; ++i) {
            for (Character cc : sz.toCharArray()) {
                sb[i].append(D);
                sb[i].append(map.get(cc)[i]);
            }
        }
    }
    private static void output() {
        for (StringBuilder sbi : sb)
            System.out.println(sbi.toString());
    }
    public static void main(String[] args) {
        init();
        input();
        preHandler();
        handler();
        output();
    }
}