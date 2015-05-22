package com.google.guava.collect;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

/**
 * @author bjxieb
 * @date 5/22/15
 */
public class ImmutableListTest {
  @Test
  public void test() {
    ImmutableList<String> stringImmutableList = ImmutableList.of("1", "2");
    for (String a : stringImmutableList) {
        System.out.println(a);
    }
  }
}
