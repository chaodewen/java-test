package recruit.fte.baidu.onsite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by Cc on 2017/8/6.
 *
 * 测试combineAllLenWithoutSpace方法
 */
@RunWith(Parameterized.class)
public class CombinationsWithoutSpaceTest extends CombinationsTestBase {
    public CombinationsWithoutSpaceTest(char[] nums, String[] expected) {
        super(nums, expected);
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new char[]{}, new String[]{""}},
                {new char[]{'1'}, new String[]{"1"}},
                {new char[]{'1', '2'}, new String[]{"1", "2", "12"}},
                {new char[]{'1', '2', '3'}, new String[]{"1", "2", "12", "3", "13", "23", "123"}},
                {new char[]{'1', '2', '3', '4'}, new String[]{"1", "2", "12", "3", "13", "23", "123"
                        , "4", "14", "24", "124", "34", "134", "234", "1234"}},
        });
    }

    @Before
    public void init() {
        super.init("testCombineAllLenWithoutSpace");
    }

    @Test
    public void test() {
        combinations.combineAllLenWithoutSpace(nums);
        super.check();
    }

    @After
    public void finish() {
        super.finish("testCombineAllLenWithoutSpace");
    }
}
