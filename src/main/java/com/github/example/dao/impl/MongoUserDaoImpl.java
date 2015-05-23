package com.github.example.dao.impl;

import java.util.List;

import com.github.example.dao.UserDao;
import com.github.example.domain.User;
import com.github.mybatis.dao.BaseDao;

/**
 * @author xiebiao
 * @date 8/26/14
 */
public class MongoUserDaoImpl extends BaseDao implements UserDao {

  @Override
  public User getUser(int userId) {
    return null;
  }

  @Override
  public List<User> listAll(User user) {
    return null;
  }
}
