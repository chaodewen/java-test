package recruit.fte.baidu.onsite;

/**
 * Created by Dewen on 2017/8/4.
 */
public class Combinations {
    /**
     * 输出长度为len的nums中数字的组合
     *
     * @param nums  可选数的表
     * @param len   生成组合还需数字的个数
     * @param ans   当前正在生成的组合
     * @param start 选择数字的起始位置
     */
    public void combine(int[] nums, int[] ans, int len, int start) {
        // 结束递归
        if (len == 0) {
            print(ans);
            return;
        }

        // 循环向当前位置放置数字
        for (int i = start; i <= nums.length - len; i++) {
            // start恰好是当前位置
            ans[start] = nums[i];
            // 递归向右边一个位置放入数字
            combine(nums, ans, len - 1, start + 1);
        }
    }

    /**
     * 输出结果
     *
     * @param ans 结果数组
     */
    private void print(int[] ans) {
        for (int num : ans)
            System.out.print(num);

        System.out.println();
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();

        int[] nums = {1, 2};

        // 循环处理每种长度
        for (int len = 1; len <= nums.length; len++) {
            int[] ans = new int[len];
            combinations.combine(nums, ans, len, 0);
        }
    }
}