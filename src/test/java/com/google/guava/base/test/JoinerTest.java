package com.google.guava.base.test;

import static org.hamcrest.CoreMatchers.is;

import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;

/**
 * @author xiebiao
 * @date 4/6/15
 */
public class JoinerTest {
  @Test
  public void test_MapJoiner() {
    Map<String, Object> hmap = Maps.newLinkedHashMap();
    hmap.put("name", "xiaog");
    hmap.put("age", 1);

    String expectString = "name is xiaog,age is 1";
    String is = Joiner.on(",").withKeyValueSeparator(" is ").join(hmap);
    System.out.println(is);
    Assert.assertEquals(expectString, is(is));

  }
}
