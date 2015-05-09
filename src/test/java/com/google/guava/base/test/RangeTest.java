package com.google.guava.base.test;

import org.junit.Test;

import com.google.common.collect.Range;

/**
 * @author bjxieb
 * @date 5/9/15
 */
public class RangeTest {
  @Test
  public void test_() {
    Range<Integer> r = Range.closed(1, 10);
    System.out.println(r.contains(5));
  }
}
