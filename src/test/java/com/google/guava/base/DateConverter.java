package com.google.guava.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

import com.google.common.base.Converter;

/**
 * @author bjxieb
 * @date 4/10/15
 */
public class DateConverter extends Converter<Date, String> {
  private static final String format = "yyyy-MM-dd";

  @Override
  protected String doForward(Date date) {
    return new SimpleDateFormat(format).format(date);
  }

  @Override
  protected Date doBackward(String s) {
    return DateTime.parse(s).toDate();
  }
}
