package com.xiebiao.mybatis.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

import com.xiebiao.mybatis.domain.BaseDomain;

public abstract class BaseDao extends SqlSessionDaoSupport implements IDao {

	public <T> Integer insert(T t) throws DataAccessException {
		return this.getSqlSession().insert(
				getNameSpace() + ".insert", t);
	}

	public Integer delete(String keyId) throws DataAccessException {
		return this.getSqlSession().delete(this.getNameSpace() + ".delete",
				keyId);
	}

	public <T> Integer update(T t) throws DataAccessException {
		return this.getSqlSession().update(this.getNameSpace() + ".update", t);
	}

	public <T> T find(String keyId) throws DataAccessException {
		T t = (T) this.getSqlSession().selectOne(this.getNameSpace() + ".find",
				keyId);
		return t;
	}

	public <T> List<T> listForObject(T t) throws DataAccessException {
		return this.getSqlSession()
				.selectList(this.getNameSpace() + ".list", t);
	}

	public <T> Integer countForObject(T t) throws DataAccessException {
		return (Integer) this.getSqlSession().selectOne(
				this.getNameSpace() + ".count",t);
	}

	public <T extends BaseDomain> List<T> insertBatch(List<T> t) {
		return null;
	}

	public <T extends BaseDomain> List<T> updateBatch(List<T> t) {
		return null;
	}

	public <T extends BaseDomain> List<T> updateBatch(List<T> t,
			String updateSqlId) {
		return null;
	}

	public abstract String getNameSpace();
}
