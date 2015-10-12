package com.github.web.utils;

import org.junit.Test;
import org.testng.Assert;

/**
 * @author bjxieb
 * @date 10/12/15
 */
public class WebXssScanUtilsTest {
  @Test
  public void test_replace_script_to_blank() {
    String result = WebXssScanUtils.filter("<script>alrt('asdf')</script>");
    Assert.assertEquals("", result);
  }
}
