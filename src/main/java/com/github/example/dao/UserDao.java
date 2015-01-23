package com.github.example.dao;

import com.github.example.domain.User;
import com.github.mybatis.dao.IDao;

import java.util.List;

public interface UserDao extends IDao {

    public User getUser(int userId);

    public List<User> listAll(User user);
}
