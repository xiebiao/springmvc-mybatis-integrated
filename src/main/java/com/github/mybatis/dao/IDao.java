package com.github.mybatis.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.github.commons.Query;

/**
 * DAO
 *
 * @author xiebiao
 */
public interface IDao {

  <T> Integer insert(T domain) throws DataAccessException;

  Integer delete(String keyId) throws DataAccessException;

  <T> Integer update(T domain) throws DataAccessException;

  <T> T find(Object keyId) throws DataAccessException;

  <E extends Query> List<E> listForObject(E domain) throws DataAccessException;

  <E extends Query> Integer countForObject(E domain) throws DataAccessException;

  <E> List<E> batchInsert(final List<E> list);

  <E> List<E> batchUpdate(final List<E> list);

  <E> List<E> batch(final List<E> list, final String sqlId);

}
