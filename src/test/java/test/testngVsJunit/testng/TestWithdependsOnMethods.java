package test.testngVsJunit.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author <a href="mailto:joyrap@qq.com">joyrap@qq.com</a>
 * @date 7/15/15
 */
public class TestWithdependsOnMethods {
  @Test
  public void serverStartedOk() {
    Assert.assertEquals(true, true);
  }

  @Test(dependsOnMethods = {"serverStartedOk"}, alwaysRun = true)
  public void method1() {
    System.out.println("test method1");
  }

}
