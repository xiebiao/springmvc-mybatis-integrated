package test.testngVsJunit.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author <a href="mailto:joyrap@qq.com">joyrap@qq.com</a>
 * @date 7/14/15
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestCase2.class, TestCase1.class})
public class TestSuite {
}
