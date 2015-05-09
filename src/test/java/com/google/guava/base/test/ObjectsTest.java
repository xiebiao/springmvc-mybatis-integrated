package com.google.guava.base.test;

import junit.framework.Assert;

import org.junit.Test;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * @author xiebiao
 * @date 4/6/15
 */
public class ObjectsTest {
  @Test
  public void test() {
    System.out.println(Objects.equal("A", "a"));
    System.out.println(MoreObjects.toStringHelper(this).add("name", "xiaog"));
    System.out.println(Objects.hashCode("a", "b"));
  }

  @Test
  public void test_equal_return_false() {
    Assert.assertEquals(false, Objects.equal("A", "a"));
  }

  @Test
  public void test_equal_return_true() {
    Assert.assertEquals(true, Objects.equal("a", "a"));
  }
}
