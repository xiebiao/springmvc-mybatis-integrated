package com.google.guava.base;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

import com.google.common.primitives.Ints;

/**
 * @author bjxieb
 * @date 5/22/15
 */
public class IntsTest {
  @Test
  public void test_concat() {
    int[] a = new int[] {1, 2};
    int[] b = new int[] {3, 4};
    int[] concatInts = Ints.concat(a, b);
    Assert.assertEquals(true, Arrays.equals(new int[] {1, 2, 3, 4}, concatInts));
  }

  @Test
  public void test_join() {
    int[] a = new int[] {1, 2, 3, 4};
    String join = Ints.join("-", a);
    Assert.assertEquals("1-2-3-4", join);
  }

  @Test
  public void test_max() {
    int[] a = new int[] {1, 2, 3, 4};
    Assert.assertEquals(4, Ints.max(a));
  }

  @Test
  public void test_toByteArray() {
    byte[] a = Ints.toByteArray(1);
    for (byte b : a) {
      System.out.println(b);
    }
    // Assert.assertEquals(4, Ints.max(a));
  }

  @Test
  public void test_compare() {
    Assert.assertEquals(-1, Ints.compare(1, 4));

  }
}
