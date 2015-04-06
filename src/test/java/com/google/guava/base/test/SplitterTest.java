package com.google.guava.base.test;

import java.util.Map;

import org.junit.Test;

import com.google.common.base.Splitter;
import com.google.common.collect.Maps;

/**
 * @author xiebiao
 * @date 4/6/15
 */
public class SplitterTest {
  @Test
  public void test_split() {
    String text = "My|=Name|Is|Xiaog";
    Map<String, Object> textMap = Maps.newHashMap();
    textMap.put("name", "xiaog");
    textMap.put("age", 10);
    System.out.println(Splitter.on("|").split(text));
  }

  @Test
  public void test_splitMap() {

  }
}
