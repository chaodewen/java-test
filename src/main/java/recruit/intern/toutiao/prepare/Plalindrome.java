package recruit.intern.toutiao.prepare;

/**
 * Created by Cc on 2017/8/19.
 *
 * 给定数组，可以删除两个相邻的数，并在这个位置插入这两个数的和
 * 问最少经过多少次这样的操作可以把数组构建为回文序列
 */
public class Plalindrome {
    public int findMinTimes(int[] nums) {
        int low = 0, high = nums.length - 1, cnt = 0;

        while(low < high) {
            if(nums[low] != nums[high]) {
                if(nums[low] < nums[high])
                    nums[low + 1] += nums[low++];
                else
                    nums[high - 1] += nums[high--];

                cnt++;
            }
            else {
                low++;
                high--;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Plalindrome plalindrome = new Plalindrome();
        System.out.println(plalindrome.findMinTimes(new int[] {1, 1, 1, 3}));
        System.out.println(plalindrome.findMinTimes(new int[] {2, 1, 3}));
        System.out.println(plalindrome.findMinTimes(new int[] {2, 8, 9, 7, 3}));
        System.out.println(plalindrome.findMinTimes(new int[] {1, 2, 3}));
        System.out.println(plalindrome.findMinTimes(new int[] {1, 2, 4, 6, 1}));
    }
}