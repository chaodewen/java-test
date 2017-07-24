package recruit.intern.toutiao.interview;

/**
 * Created by Cc on 2017/4/25.
 */
public class RotatedArrayFindNum {
    public static void main(String[] args) {
        int[] nums = new int[]{ 15, 17, 18, 1, 2, 3, 4, 8, 9, 10, 12};
        System.out.println(search(nums, 12));
    }
    private static boolean search(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = (high - low) / 2 + low;
            if(nums[mid] == k)
                return true;
            else if(nums[mid] >= nums[0]) {
                if(nums[mid] > k && k >= nums[0])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else {
                if(nums[mid] < k && k <= nums[nums.length - 1])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }
}
