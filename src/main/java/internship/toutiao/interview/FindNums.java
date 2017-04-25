package internship.toutiao.interview;

import java.util.Arrays;

/**
 * Created by Cc on 2017/4/25.
 */

public class FindNums {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15, 17, 19, 21, 23};
        int k = 11, c = 9;
        solve(k, c, nums);

        int[] nums2 = new int[] { 1, 2, 3, 4, 8, 10, 11 };
        int k2 = 7, c2 = 3;
        solve(k2, c2, nums2);
    }
    private static void solve(int k, int c, int[] nums) {
        int low = 0, high = nums.length - 1, index = 0;
        while(low <= high) {
            int mid = (high - low) / 2 + low;
            index = mid;
            if(nums[mid] == k)
                break;
            else if(nums[mid] > k)
                high = mid - 1;
            else
                low = mid + 1;
        }

        int oldIndex = index;
        if(oldIndex > 0 && Math.abs(nums[oldIndex] - k) > Math.abs(nums[oldIndex - 1] - k))
            index --;
        if(oldIndex < nums.length && Math.abs(nums[index] - k) > Math.abs(nums[oldIndex + 1] - k))
            index = oldIndex + 1;

        System.out.println(index);

        int remain = c - 1, left = index, right = index;
        while(remain > 0) {
            int cnt = (remain + 1) / 2;
            if(left - cnt < 0 || right + cnt >= nums.length)
                cnt = left < (nums.length - 1 - right) ? left : (nums.length - 1 - right);

            int leftMin = Math.abs(k - nums[left - cnt]), rightMin = Math.abs(k - nums[right + cnt]);

            left = leftMin <= rightMin ? (left - cnt) : left;
            right = leftMin <= rightMin ? right : (right + cnt);

            remain -= cnt;
        }

        System.out.println(Arrays.toString(new int[] { nums[left], nums[right] }));
    }
}