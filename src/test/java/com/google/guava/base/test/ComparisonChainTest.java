package com.google.guava.base.test;

import org.junit.Test;

import com.google.common.collect.ComparisonChain;

/**
 * @author xiebiao
 * @date 4/6/15
 */
public class ComparisonChainTest {
  @Test
  public void test() {
    System.out.println(ComparisonChain.start().compare("1", "2").result());
  }
}
