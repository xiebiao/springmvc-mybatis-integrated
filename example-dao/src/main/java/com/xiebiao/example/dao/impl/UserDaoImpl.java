package com.xiebiao.example.dao.impl;

import java.util.List;

import com.xiebiao.example.dao.UserDao;
import com.xiebiao.example.domain.User;
import com.xiebiao.mybatis.dao.BaseDao;


public class UserDaoImpl extends BaseDao implements UserDao {

	public final String NAME_SPACE = this.getClass().getName();

	public User getUser(int userId) {
		return (User) this.find(String.valueOf(userId));
	}

	@Override
	public String getNameSpace() {
		return NAME_SPACE;
	}

	public List<User> listAll(User user) {

		return this.getSqlSession().selectList(
				this.getNameSpace() + ".listAll", user);
	}

}
