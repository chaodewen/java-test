package recruit.fte.baidu.onsite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by Dewen on 2017/8/5.
 *
 * 测试数字的组合
 */
@RunWith(Parameterized.class)
public class CombinationsTest {
    // 开启同时输出到log的功能
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private Combinations combinations;

    // 输入参数
    private int[] nums;

    // 正确输出值
    private String[] expected;

    public CombinationsTest(int[] nums, String[] expected) {
        this.nums = nums;
        this.expected = expected;
    }

    /**
     * 生成测试输入参数
     *
     * @return 测试输入参数
     */
    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{}, new String[]{""}},
                {new int[]{1}, new String[]{"1"}},
                {new int[]{1, 2}, new String[]{"1", "2", "21"}},
                {new int[]{1, 2, 3}, new String[]{"1", "2", "3", "21", "31", "32", "321"}},
                {new int[]{1, 2, 3, 4}, new String[]{"1", "2", "3", "4", "21", "31", "41"
                        , "32", "42", "43", "321", "421", "431", "432", "4321"}},
        });
    }

    @Before
    public void init() {
        combinations = new Combinations();

        // 清空log缓存
        systemOutRule.clearLog();
    }

    @Test
    public void testCombineAllLen() {
        combinations.combineAllLen(nums);

        // 取log进行处理
        String[] ans = systemOutRule.getLog().split("\n");

        Assert.assertArrayEquals(expected, ans);
    }
}