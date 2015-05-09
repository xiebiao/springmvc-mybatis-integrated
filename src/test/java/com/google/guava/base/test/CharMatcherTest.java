package com.google.guava.base.test;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.CharMatcher;

/**
 * @author xiebiao
 * @date 4/6/15
 */
public class CharMatcherTest {
  @Test
  public void test_inRange() {

    CharMatcher str = CharMatcher.inRange('A', 'D');
    Assert.assertEquals(true, str.matchesAllOf("ABCD"));

  }

  @Test
  public void test_retainFrom() {
    String text = "aaa111DDD123DDDDee1!";
    Assert.assertEquals("1111231", CharMatcher.JAVA_DIGIT.retainFrom(text));
  }

  @Test
  public void test_removeFrom() {
    String text = "aaa111DDD123DDDDee1!";
    Assert.assertEquals("aaa111123ee1!", CharMatcher.JAVA_UPPER_CASE.removeFrom(text));
  }

  @Test
  public void test_anyOf() {
    CharMatcher charMatcher = CharMatcher.anyOf("abasdfasf|w");

    System.out.println(charMatcher.countIn("a"));

  }
}
