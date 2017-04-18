package internship.toutiao.online;

import java.util.*;

/**
 * Created by Cc on 2017/4/18.
 */
public class Array {
    private static int m, n;
    private static int[] a, b, ans;
    private static ArrayList<Integer> list;
    static void commonPart() {
        Arrays.sort(a);
        for (int i = 0; i < b.length; i ++)
            if (Arrays.binarySearch(a, b[i]) >= 0)
                list.add(b[i]);

        ans = new int[list.size()];

        int idx = 0, i = 0;
        while(i < list.size())
            ans[idx ++] = list.get(i ++);

        for (int r : ans)
            System.out.print(r + " ");

        System.out.println();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()) {
            m = in.nextInt();
            a = new int[m];

            for (int i = 0; i < m; i ++)
                a[i] = in.nextInt();

            n = in.nextInt();
            b = new int[n];

            for (int i = 0; i < n; i ++)
                b[i] = in.nextInt();

            list = new ArrayList<>();

            commonPart();
        }

        in.close();
    }

}