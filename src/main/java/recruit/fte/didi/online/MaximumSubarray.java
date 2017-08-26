package recruit.fte.didi.online;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Cc on 2017/8/26.
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> array = new ArrayList<>();
        while(scanner.hasNext()) {
            String[] nums = scanner.nextLine().split(" ");
            for(String num : nums)
                array.add(Integer.valueOf(num));
            System.out.println(maxSubArray(array));
        }
        scanner.close();
    }

    private static int maxSubArray(List<Integer> array) {
        if(array.size() == 0)
            return 0;

        int max = array.get(0), last = array.get(0);

        for(int i = 1; i < array.size(); i ++) {
            last = (last > 0) ? (last + array.get(i)) : array.get(i);
            max = max > last ? max : last;
        }

        return max;
    }
}