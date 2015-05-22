package com.google.guava.base;

import static org.hamcrest.CoreMatchers.is;

import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
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

  @Test
  public void test_ListJoiner() {
    // String is = Joiner.on(",").withKeyValueSeparator(" is ").join(hmap);
  }

  @Test
  public void test_join_map() {
    Map<String, Object> hmap = Maps.newLinkedHashMap();
    hmap.put("name", "xiaog");
    hmap.put("age", 1);
    String is = Joiner.on("&").withKeyValueSeparator("=").join(hmap);
    Assert.assertEquals("name=xiaog&age=1", is);
  }

  @Test
  public void test_join_skipNull() {
    List<String> value = Lists.newArrayList();
    value.add("name");
    value.add("age");
    value.add(null);
    String is = Joiner.on("&").skipNulls().join(value);
    // String is = Joiner.on("&").join(value);
    Assert.assertEquals("name&age", is);
  }
}
