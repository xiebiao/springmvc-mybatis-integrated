package com.google.guava.base.test;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.junit.Test;

/**
 * @author xiebiao
 * @date 4/6/15
 */
public class ObjectsTest {
  @Test
  public void test() {
      System.out.println(Objects.equal("A","a"));
      System.out.println(MoreObjects.toStringHelper(this).add("name", "xiaog"));
  }
}
