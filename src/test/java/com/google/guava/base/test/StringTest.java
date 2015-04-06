package com.google.guava.base.test;

import org.junit.Test;

/**
 * @author xiebiao
 * @date 4/6/15
 */
public class StringTest {
  @Test
  public void test_replaceAll() {
    String string = "my,name is ,1,1xiaog, age is 100";
    System.out.println(string.replaceAll(",", ""));
    System.out.println(string.replace(",", ""));
  }
}
