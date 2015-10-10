package com.github.dao.spring;

/**
 * @author xiebiao
 * @date 10/10/15
 */
public final class DynamicDataSourceHolder {
  public static final ThreadLocal<String> holder = new ThreadLocal<>();

  public static void putDataSource(String name) {
    holder.set(name);
  }

  public static String getDataSouce() {
    return holder.get();
  }
}
