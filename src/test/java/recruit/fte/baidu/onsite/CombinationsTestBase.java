package recruit.fte.baidu.onsite;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;

/**
 * Created by Cc on 2017/8/6.
 *
 * 测试基类
 */
public class CombinationsTestBase {
    // 开启同时输出到log的功能
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    protected Combinations combinations;

    // 输入参数
    protected char[] nums;

    // 正确输出值
    protected String[] expected;

    protected CombinationsTestBase(char[] nums, String[] expected) {
        this.nums = nums;
        this.expected = expected;
    }

    protected void init(String methodName) {
        System.out.printf("===================== Starting %s (len = %d) =====================\n"
                , methodName, nums.length);

        combinations = new Combinations();

        // 清空log缓存
        systemOutRule.clearLog();
    }

    protected void check() {
        // 取log进行处理
        String[] ans = systemOutRule.getLog().split("\n");

        Assert.assertArrayEquals(expected, ans);
    }

    protected void finish(String methodName) {
        System.out.printf("===================== Stopping %s (len = %d) =====================\n\n\n\n"
                , methodName, nums.length);
    }
}