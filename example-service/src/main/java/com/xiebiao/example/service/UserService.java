package com.xiebiao.example.service;

import com.xiebiao.common.util.DataPage;
import com.xiebiao.example.domain.User;


public interface UserService {
	public DataPage<User> listAll(User user, int pageIndex, int pageSize);

	public void addUser(User user);
}
