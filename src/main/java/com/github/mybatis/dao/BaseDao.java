package com.github.mybatis.dao;

import com.github.commons.Query;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * @author xiebiao
 */
public abstract class BaseDao extends SqlSessionDaoSupport implements IDao {

    public <T> Integer insert(T t) throws DataAccessException {
        return this.getSqlSession().insert(getNameSpace() + ".insert", t);
    }

    public Integer delete(String key) throws DataAccessException {
        return this.getSqlSession().delete(this.getNameSpace() + ".delete", key);
    }

    public <T> Integer update(T domain) throws DataAccessException {
        return this.getSqlSession().update(this.getNameSpace() + ".update", domain);
    }

    public <T> T find(Object key) throws DataAccessException {
        return (T) this.getSqlSession().selectOne(this.getNameSpace() + ".find", key);
    }

    public <T extends Query> List<T> listForObject(T query) throws DataAccessException {
        return this.getSqlSession().selectList(this.getNameSpace() + ".list", query);
    }

    public <T extends Query> Integer countForObject(T query) throws DataAccessException {
        return (Integer) this.getSqlSession().selectOne(this.getNameSpace() + ".count", query);
    }

    public <T> List<T> batchInsert(List<T> list) {
        // TODO
        return null;
    }

    public <T> List<T> batchUpdate(List<T> list) {
        // TODO
        return null;
    }

    public <T> List<T> batch(List<T> list, String sqlId) {
        // TODO
        return null;
    }

    public String getNameSpace() {
        return this.getClass().getName();
    }
}
