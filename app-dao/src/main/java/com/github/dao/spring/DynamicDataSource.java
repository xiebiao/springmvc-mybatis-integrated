package com.github.dao.spring;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author xiebiao
 * @date 10/10/15
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
  @Override
  protected Object determineCurrentLookupKey() {
    return DynamicDataSourceHolder.getDataSouce();
  }
}
