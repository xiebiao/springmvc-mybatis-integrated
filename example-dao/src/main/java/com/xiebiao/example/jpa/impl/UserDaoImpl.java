package com.xiebiao.example.jpa.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.xiebiao.example.dao.UserDao;
import com.xiebiao.example.domain.User;
import com.xiebiao.mybatis.domain.BaseDomain;

@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	private EntityManager entityManager;

	public User getUser(int userId) {
		return (User) entityManager.find(User.class, userId);
	}

	public <T> List<T> listForObject(T t) throws DataAccessException {
		return entityManager.createQuery("Select s.userName from user s")
				.getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public <T> String insert(T t) throws DataAccessException {
		// TODO Auto-generated method stub
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

}
