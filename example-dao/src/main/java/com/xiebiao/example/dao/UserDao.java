package com.xiebiao.example.dao;

import com.xiebiao.example.domain.User;
import com.xiebiao.mybatis.dao.IDao;

public interface UserDao extends IDao {

	public User getUser(int userId);

}
