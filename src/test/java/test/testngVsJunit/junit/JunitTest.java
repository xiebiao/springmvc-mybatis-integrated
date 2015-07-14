package test.testngVsJunit.junit;

import org.junit.*;

/**
 * @author <a href="mailto:joyrap@qq.com">joyrap@qq.com</a>
 * @date 7/14/15
 */
public class JunitTest {
  @Before
  public void setUp() {
    System.out.println("execute @Before");
  }

  @BeforeClass
  public static void beforeClass() {
    // init db, cache or other resources
    System.out.println("execute @BeforeClass");
  }

  @Test
  public void testMethod() {
    System.out.println("execute testMethod");
  }
  @Test
  public void testMethod2() {
    System.out.println("execute testMethod2");
  }
  @AfterClass
  public static void afterClass() {
    System.out.println("execute @AfterClass");
  }

  @After
  public void after() {
    System.out.println("execute @After");
  }
}
