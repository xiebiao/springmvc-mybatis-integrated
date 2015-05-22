package com.google.guava.base;

import java.util.Date;

import org.junit.Test;

/**
 * @author bjxieb
 * @date 4/10/15
 */
public class DateConverterTest {
  @Test
  public void test() {
    DateConverter dateConverter = new DateConverter();
      System.out.println(dateConverter.convert(new Date()));
      System.out.println(dateConverter.doBackward(System.currentTimeMillis()+""));
  }
}
