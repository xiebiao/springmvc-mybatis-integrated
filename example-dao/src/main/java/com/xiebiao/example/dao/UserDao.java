package com.xiebiao.example.dao;

import java.util.List;

import com.xiebiao.example.domain.User;
import com.xiebiao.mybatis.dao.IDao;

public interface UserDao extends IDao {

	public User getUser(int userId);

	public List<User> listAll(User user);
}
