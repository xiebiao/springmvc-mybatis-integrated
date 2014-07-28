package com.github.example.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

/**
 * @author xiebiao
 */
public abstract class BaseDao extends SqlSessionDaoSupport implements IDao {

    public String getNameSpace() {
        return this.getClass().getName();
    }

    @Override
    public <T> Integer insert(T t) throws DataAccessException {
        return this.getSqlSession().insert(getNameSpace() + "." + "insert");
    }

    @Override
    public Integer delete(String key) throws DataAccessException {
        return this.getSqlSession().delete(getNameSpace() + "." + "delete", key);
    }

    @Override
    public <T> Integer update(T t) throws DataAccessException {
        return this.getSqlSession().update(getNameSpace() + "." + "update");
    }

    @Override
    public <T> T find(String key) throws DataAccessException {
        return this.getSqlSession().selectOne(getNameSpace() + "." + "find", key);
    }

    @Override
    public <E> List<E> listForObject(E e) throws DataAccessException {
        return this.getSqlSession().selectList(this.getNameSpace() + ".list", e);
    }

    @Override
    public <E> Integer countForObject(E e) throws DataAccessException {
        return (Integer) this.getSqlSession().selectOne(this.getNameSpace() + ".count", e);
    }
}
