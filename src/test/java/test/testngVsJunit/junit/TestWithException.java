package test.testngVsJunit.junit;

import org.junit.Test;

/**
 * @author <a href="mailto:joyrap@qq.com">joyrap@qq.com</a>
 * @date 7/16/15
 */
public class TestWithException {
  @Test(expected = NullPointerException.class)
  public void throwNullPointException() {
    // throw new NullPointerException();
    throw new IllegalArgumentException();
  }
}
