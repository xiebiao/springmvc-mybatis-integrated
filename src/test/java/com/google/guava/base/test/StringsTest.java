package com.google.guava.base.test;

import junit.framework.Assert;

import org.junit.Test;

import com.google.common.base.Strings;

/**
 * @author xiebiao
 * @date 4/6/15
 */
public class StringsTest {
  @Test
  public void test_padEnd() {
    String text = "1";
    String expect = "1ss";
    Assert.assertEquals(expect, Strings.padEnd(text, 3, 's'));
  }

  @Test
  public void test_commonSuffix() {
    String suffix = ".jpg";
    Assert.assertEquals(suffix, Strings.commonSuffix("a1.xxx.jpg", "a2.TTT.jpg"));
  }

  @Test
  public void test_repeat() {
    String expect = "****";
    Assert.assertEquals(expect, Strings.repeat("*", 4));
  }

  @Test
  public void test_padStart() {
    String expect = "ssa";
    String text = "a";
    Assert.assertEquals(expect, Strings.padStart(text, 3, 's'));
  }
}
