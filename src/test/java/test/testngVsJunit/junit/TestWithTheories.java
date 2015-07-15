package test.testngVsJunit.junit;

import static org.junit.Assert.assertTrue;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * 用于数据集测试的场景
 * 
 * @author <a href="mailto:joyrap@qq.com">joyrap@qq.com</a>
 * @date 7/15/15
 */
@RunWith(Theories.class)
public class TestWithTheories {
  @DataPoints
  public static int[] positiveIntegers() {
    return new int[] {1, 10, 1234567};
  }

  @Theory
  public void a_plus_b_is_greater_than_a_and_greater_than_b(Integer a, Integer b) {
    System.out.println("a=" + a + " b=" + b);
    assertTrue(a + b > a);
    assertTrue(a + b > b);
  }
}
