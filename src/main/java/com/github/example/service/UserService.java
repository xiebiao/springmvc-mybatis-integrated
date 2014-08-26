package com.github.example.service;

import java.util.List;

import com.github.example.domain.User;


public interface UserService {
	public List<User> listAll(User user, int pageIndex, int pageSize);

	public void addUser(User user);
}
