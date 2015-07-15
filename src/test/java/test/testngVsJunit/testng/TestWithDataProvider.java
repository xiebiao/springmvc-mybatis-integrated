package test.testngVsJunit.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author <a href="mailto:joyrap@qq.com">joyrap@qq.com</a>
 * @date 7/15/15
 */
public class TestWithDataProvider {
  // is named "test1"
  @DataProvider(name = "test1")
  public Object[][] createData1() {
    return new Object[][] {new Object[] {"Cedric", new Integer(36)},
        new Object[] {"Anne", new Integer(37)},};
  }

  // This test method declares that its data should be supplied by the Data Provider
  // named "test1"
  @Test(dataProvider = "test1")
  public void verifyData1(String n1, Integer n2) {
    System.out.println(n1 + " " + n2);
  }
}
