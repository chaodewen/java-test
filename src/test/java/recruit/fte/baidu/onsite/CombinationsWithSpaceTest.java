package recruit.fte.baidu.onsite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by Dewen on 2017/8/5.
 *
 * 测试combineAllLenWithSpace方法
 */
@RunWith(Parameterized.class)
public class CombinationsWithSpaceTest extends CombinationsTestBase {
    public CombinationsWithSpaceTest(char[] nums, String[] expected) {
        super(nums, expected);
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new char[]{}, new String[]{""}},
                {new char[]{'1'}, new String[]{"1"}},
                {new char[]{'1', '2'}, new String[]{"1", "2", "21"}},
                {new char[]{'1', '2', '3'}, new String[]{"1", "2", "3", "21", "31", "32", "321"}},
                {new char[]{'1', '2', '3', '4'}, new String[]{"1", "2", "3", "4", "21", "31", "41"
                        , "32", "42", "43", "321", "421", "431", "432", "4321"}},
        });
    }

    @Before
    public void init() {
        super.init("testCombineAllLenWithSpace");
    }

    @Test
    public void test() {
        combinations.combineAllLenWithSpace(nums);
        super.check();
    }

    @After
    public void finish() {
        super.finish("testCombineAllLenWithSpace");
    }
}