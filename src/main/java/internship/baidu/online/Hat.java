package internship.baidu.online;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Cc on 2017/4/27.
 */

public class Hat {
    private static int[] nums;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            int n = s.nextInt();
            nums = new int[n];
            for(int i = 0; i < n; i ++)
                nums[i] = s.nextInt();
            if(n < 3)
                System.out.println(-1);
            else {
                Arrays.sort(nums);
                System.out.println(nums[n - 3]);
            }
        }
        s.close();
    }
}