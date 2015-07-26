package test.testngVsJunit.junit;

import org.junit.Rule;
import org.junit.Test;

/**
 * @author <a href="mailto:joyrap@qq.com">joyrap@qq.com</a>
 * @date 7/15/15
 */
public class TestWithRule {
  @Rule
  public MyRule rule = new MyRule();

  @Test
  public void test() {
    System.out.println("test method");

  }
}
