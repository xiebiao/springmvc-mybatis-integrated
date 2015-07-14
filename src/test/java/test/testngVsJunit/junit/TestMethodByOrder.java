package test.testngVsJunit.junit;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * @author <a href="mailto:joyrap@qq.com">joyrap@qq.com</a>
 * @date 7/14/15
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMethodByOrder {
  @Test
  public void a() {
      System.out.println("test method a()");
  }

  @Test
  public void b() {
      System.out.println("test method b()");
  }

  @Test
  public void c() {
      System.out.println("test method c()");
  }
}
