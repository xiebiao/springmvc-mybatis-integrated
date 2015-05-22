package com.google.guava.base;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author bjxieb
 * @date 5/22/15
 */
public class ListsTest {
  @Test
  public void test_partition() {
    List<String> lists = Lists.newArrayList("1", "2", "3", "4");
    List<List<String>> p = Lists.partition(lists, 1);
    Assert.assertEquals(4, p.size());
    Assert.assertEquals("1", p.get(0).get(0));
  }

}
