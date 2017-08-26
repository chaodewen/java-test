package recruit.fte.didi.online;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Cc on 2017/8/26.
 */
public class KthLargestNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> array = new ArrayList<>();
        while(scanner.hasNext()) {
            String[] nums = scanner.nextLine().split(" ");
            for(String num : nums)
                array.add(Integer.valueOf(num));
            int k = scanner.nextInt();
            int[] input = new int[array.size()];
            for(int i = 0; i < input.length; i++)
                input[i] = array.get(i);
            System.out.println(findKthLargest(input, k));
        }
        scanner.close();
    }
    private static int findKthLargest(int[] nums, int k) {
        return quickSearch(nums, 0, nums.length - 1, k);
    }
    private static int quickSearch(int nums[], int left, int right, int k) {
        int i = left, key = nums[right];

        for(int j = left; j < right; j ++)
            if(nums[j] < key)
                swap(nums, i ++, j);

        swap(nums, i, right);

        if(right + 1 - i == k)
            return nums[i];
        else if(right + 1 - i > k)
            return quickSearch(nums, i + 1, right, k);
        else
            return quickSearch(nums, left, i - 1, k - (right + 1 - i));
    }
    private static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}