package test.testngVsJunit.testng;

import org.testng.annotations.Test;

/**
 * @author <a href="mailto:joyrap@qq.com">joyrap@qq.com</a>
 * @date 7/14/15
 */
public class Test1 {
  @Test(groups = {"functest", "checkintest"})
  public void testMethod1() {}

  @Test(groups = {"functest", "checkintest"})
  public void testMethod2() {}

  @Test(groups = {"functest"})
  public void testMethod3() {}

}
