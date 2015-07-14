package test.testngVsJunit.testng;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author <a href="mailto:joyrap@qq.com">joyrap@qq.com</a>
 * @date 7/14/15
 */
public class TestngTest {
  @BeforeClass
  public void setUp() {
    System.out.println("execute @BeforClass");
  }

  @Test
  public void aFastTest() {
    System.out.println("Fast test");
  }

  @Test(groups = {"slow"})
  public void aSlowTest() {
    System.out.println("Slow test");
  }

}
