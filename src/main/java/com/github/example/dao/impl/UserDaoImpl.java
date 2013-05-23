package com.github.example.dao.impl;

import java.util.List;

import com.github.example.dao.UserDao;
import com.github.example.domain.User;
import com.github.mybatis.dao.BaseDao;

public class UserDaoImpl extends BaseDao implements UserDao {

    public final String NAME_SPACE = this.getClass().getName();

    public User getUser(int userId) {
        return this.find(String.valueOf(userId));
    }

    @Override
    public String getNameSpace() {
        return NAME_SPACE;
    }

    public List<User> listAll(User user) {

        return this.getSqlSession().selectList(this.getNameSpace() + ".listAll", user);
    }

}
