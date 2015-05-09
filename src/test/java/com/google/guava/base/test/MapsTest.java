package com.google.guava.base.test;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;

/**
 * @author bjxieb
 * @date 5/9/15
 */
public class MapsTest {
  @Test
  public void test_ArrayListMultimap() {
    ArrayListMultimap multimap = ArrayListMultimap.create();
    multimap.put("key", Lists.newArrayList("a", "b"));
    System.out.println(multimap);
  }
}
