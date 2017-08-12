package recruit.fte.baidu.onsite;

/**
 * Created by Dewen on 2017/8/5.
 *
 * 数字的组合
 */
public class Combinations {
    /**
     * 对所有长度的情况进行组合（不使用额外空间）
     * 如果按照之前逐层选择数字然后递归的方法
     * 必须存储上一层选择好的数字
     * 所以在不使用额外空间的情况下只能对于每个组合都遍历生成每个位置的数
     * 这种解法的复杂度应该是不能更低了
     *
     * @param nums 可选数的表
     */
    public void combineAllLenWithoutSpace(char[] nums) {
        // 循环2^(n-1)次遍历所有组合
        for (int i = 1; i < (1 << nums.length); i++) {
            // 对每一位进行判断
            for (int j = 0; j < nums.length; j++)
                if ((i & (1 << j)) != 0)
                    System.out.print(nums[j]);

            System.out.println();
        }
    }

    /**
     * 对所有长度的情况进行组合（使用额外空间）
     *
     * @param nums 输入数组
     */
    public void combineAllLenWithSpace(char[] nums) {
        // 循环处理每种长度
        for (int len = 1; len <= nums.length; len++)
            combine(nums, new char[len], len, 0);
    }

    /**
     * 输出长度为len的nums中数字的组合
     *
     * @param nums  可选数的表
     * @param len   生成组合还需数字的个数
     * @param cur   当前正在生成的组合
     * @param start 选择数字的起始位置
     */
    private void combine(char[] nums, char[] cur, int len, int start) {
        // 结束递归
        if (len == 0) {
            for (char num : cur)
                System.out.print(num);

            System.out.println();

            return;
        }

        // 循环向当前位置放置数字
        for (int i = start; i <= nums.length - len; i++) {
            // start恰好是当前位置
            cur[len - 1] = nums[i];
            // 递归向右边一个位置放入数字
            combine(nums, cur, len - 1, i + 1);
        }
    }
}