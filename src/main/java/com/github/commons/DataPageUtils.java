package com.github.commons;

import java.util.List;

/**
 * @author xiebiao
 */
public final class DataPageUtils {

  public static final int MAX_SELECT_COUNT = 100;

  /**
   * 分页获取List数据
   *
   * @param index 页码( index >= 1 )
   * @param pageSize 每页数据大小
   * @param data 数据
   * @return 分页数据
   */
  public static <E> List<E> getList(int index, int pageSize, final List<E> data) {
    if (data == null)
      return null;
    if (index <= 0) {
      index = 1;
    }
    int i = pageSize * (index - 1);
    if (i >= data.size()) {
      return null;
    }
    if ((i + pageSize) > data.size()) {
      return data.subList(i, data.size());
    } else {
      return data.subList(i, i + pageSize);
    }
  }

  public static <E> List<E> getList(int index, final List<E> data) {
    return getList(index, MAX_SELECT_COUNT, data);
  }
}
