package com.xiebiao.mybatis.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.xiebiao.mybatis.domain.BaseDomain;

public interface IDao {
	/**
	 * @param <T>
	 *            DO
	 * @param t
	 * @return 
	 * @throws DataAccessException
	 */
	<T> Integer insert(T t) throws DataAccessException;

	/**
	 * @param keyId
	 * @throws DataAccessException
	 */
	Integer delete(String keyId) throws DataAccessException;

	/**
	 * @param <T>
	 *            DO
	 * @param t
	 * @throws DataAccessException
	 */
	<T> Integer update(T t) throws DataAccessException;

	/**
	 * @param <T>
	 *            DO
	 * @param keyId
	 * @return
	 * @throws DataAccessException
	 */
	<T> T find(String keyId) throws DataAccessException;

	/**
	 * @param <T>
	 *            DO
	 * @param t
	 * @return
	 * @throws DataAccessException
	 */
	<T> List<T> listForObject(T t) throws DataAccessException;

	/**
	 * @param <T>
	 *            DO
	 * @param t
	 * @return
	 * @throws DataAccessException
	 */
	<T> Integer countForObject(T t) throws DataAccessException;

	<T extends BaseDomain> List<T> insertBatch(final List<T> t);

	<T extends BaseDomain> List<T> updateBatch(final List<T> t);

	/**
	 * 根据自定义sqlID批量更新
	 * 
	 * @param t
	 * @param updateSqlId
	 *            ibatis配置id
	 * @return
	 */
	<T extends BaseDomain> List<T> updateBatch(final List<T> t,
			final String updateSqlId);

}
