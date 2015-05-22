package com.google.guava.base;

import junit.framework.Assert;

import org.junit.Test;

import com.google.common.base.Optional;

/**
 * @author bjxieb
 * @date 5/22/15
 */
public class OptionalTest {
  @Test
  public void test_of() {
    Integer a = 1;
    int t = Optional.of(a).get();
    Assert.assertEquals(1, t);
  }
}
