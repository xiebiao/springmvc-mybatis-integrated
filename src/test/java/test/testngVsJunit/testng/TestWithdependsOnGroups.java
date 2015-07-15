package test.testngVsJunit.testng;



import org.testng.annotations.Test;

/**
 * @author <a href="mailto:joyrap@qq.com">joyrap@qq.com</a>
 * @date 7/15/15
 */
public class TestWithdependsOnGroups {
  @Test(groups = {"init"})
  public void serverStartedOk() {}

  @Test(groups = {"init"})
  public void initEnvironment() {}

  @Test(dependsOnGroups = {"init.* "})
  public void method1() {
    System.out.println("test method1");
  }

}
