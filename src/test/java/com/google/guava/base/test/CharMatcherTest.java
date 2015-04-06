package com.google.guava.base.test;

import org.junit.Test;

import com.google.common.base.CharMatcher;

/**
 * @author xiebiao
 * @date 4/6/15
 */
public class CharMatcherTest {
  @Test
  public void test_() {
    String text = "aaa111DDD123DDDDee1!";
    String text2 = "ABCDED";
   // System.out.println(CharMatcher.inRange('A', 'Z').matchesAllOf(text2));
   // System.out.println(CharMatcher.is('a').matchesAllOf("a"));
    System.out.println(CharMatcher.anyOf("aaab").matches('a'));
    System.out.println(CharMatcher.JAVA_LETTER);

    // System.out.println(CharMatcher.anyOf("test").and(CharMatcher.ANY).toString());
    System.out.println(CharMatcher.JAVA_DIGIT.retainFrom(text));
  }
}
