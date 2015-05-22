package com.google.guava.base;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Sets;

/**
 * @author xiebiao
 * @date 4/6/15
 */
public class SplitterTest {

  @Test
  public void test_split_omit_emty() {
    String text = "My|Name|Is|Xiaog||haha";
    Iterable<String> iterable = Splitter.on("|").omitEmptyStrings().split(text);
    Set<String> result = Sets.newHashSet("My", "Name", "Is", "Xiaog", "haha");
    Iterator<String> iterator = iterable.iterator();
    while (iterator.hasNext()) {
      String value = iterator.next();
      Assert.assertEquals(true, result.contains(value));
    }
  }

  @Test
  public void test_split_trim() {
    String text = "My|Name|Is|Xiaog|    ||haha";
    Iterable<String> iterable = Splitter.on("|").omitEmptyStrings().trimResults().split(text);
    Set<String> result = Sets.newHashSet("My", "Name", "Is", "Xiaog", "haha");
    Iterator<String> iterator = iterable.iterator();
    while (iterator.hasNext()) {
      String value = iterator.next();
      Assert.assertEquals(true, result.contains(value));
    }
  }

  @Test
  public void test_split_use_trim_machter() {
    String text = "My_|_Name|Is|Xiaog||haha";
    Iterable<String> iterable =
        Splitter.on("|").omitEmptyStrings().trimResults(new TrimCharMatcher()).split(text);
    Set<String> result = Sets.newHashSet("My", "Name", "Is", "Xiaog", "haha");
    Iterator<String> iterator = iterable.iterator();
    while (iterator.hasNext()) {
      String value = iterator.next();
      Assert.assertEquals(true, result.contains(value));
    }
  }

  static class TrimCharMatcher extends CharMatcher {

    @Override
    public boolean matches(char c) {
      if (c == '_') {
        return true;
      }
      return false;
    }
  }
}
