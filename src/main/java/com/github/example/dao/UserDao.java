package com.github.example.dao;

import java.util.List;

import com.github.example.domain.User;

public interface UserDao extends IDao {

	public User getUser(int userId);

	public List<User> listAll(User user);
}
