package internship.toutiao.interview;

/**
 * Created by Cc on 2017/4/25.
 */

public class FindNLargest {
    public static void main(String[] args) {
        int[] nums = new int[]{ 5, 3, 2, 1, 4 };
        int k = 3;
        quickSearch(nums, 0, nums.length - 1, k);
        for(int i = nums.length - k; i < nums.length; i ++)
            System.out.print(nums[i] + " ");
    }
    private static void quickSearch(int[] nums, int start, int end, int k) {
        if(start >= end)
            return;

        int i = start, key = nums[end];

        for(int j = start; j < end; j ++)
            if(nums[j] <= key)
                swap(nums, i ++, j);
        swap(nums, i, end);
        if(nums.length - 1 - i == k)
            return;
        quickSearch(nums, start, i - 1, k);
        quickSearch(nums, i + 1, end, k);
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}