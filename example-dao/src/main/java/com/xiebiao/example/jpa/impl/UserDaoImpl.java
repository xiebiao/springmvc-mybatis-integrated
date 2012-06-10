package com.xiebiao.example.jpa.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import com.xiebiao.example.dao.UserDao;
import com.xiebiao.example.domain.User;
import com.xiebiao.mybatis.domain.BaseDomain;

public class UserDaoImpl extends JpaDaoSupport implements UserDao {

	public <T> String insert(T t) throws DataAccessException {
		this.getJpaTemplate().persist(t);
		return null;
	}

	public Integer delete(String keyId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Integer update(T t) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T find(String keyId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<T> listForObject(T t) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Integer countForObject(T t) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T extends BaseDomain> List<T> insertBatch(List<T> t) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T extends BaseDomain> List<T> updateBatch(List<T> t) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T extends BaseDomain> List<T> updateBatch(List<T> t,
			String updateSqlId) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> listAll(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
