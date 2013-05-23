package com.github.example.service;

import com.github.commons.DataPage;
import com.github.example.domain.User;


public interface UserService {
	public DataPage<User> listAll(User user, int pageIndex, int pageSize);

	public void addUser(User user);
}
