package test.testngVsJunit.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author <a href="mailto:joyrap@qq.com">joyrap@qq.com</a>
 * @date 7/15/15
 */
public class TestWithParameters {
  //@Parameters({"name"})
  @Test(parameters = {"xiaog"})
  public void testWithParameterA(String name) {
    System.out.println("do something with :" + name);
  }
}
