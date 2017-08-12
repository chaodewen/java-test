package recruit.fte.baidu.onsite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Cc on 2017/8/6.
 *
 * 两种方法都进行测试
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CombinationsWithSpaceTest.class, CombinationsWithoutSpaceTest.class})
public class CombinationsTestStarter {
}