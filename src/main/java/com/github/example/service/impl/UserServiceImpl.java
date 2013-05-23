package com.github.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.commons.DataPage;
import com.github.example.dao.UserDao;
import com.github.example.domain.User;
import com.github.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	private final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(this
			.getClass());

	public DataPage<User> listAll(User user, int pageIndex, int pageSize) {

		int count = this.userDao.countForObject(Integer.class);

		LOG.error("................pageIndex" + pageIndex + " pageSize:"
				+ pageSize);
		DataPage<User> dp = new DataPage<User>(count, pageIndex, pageSize);
		user.setStart(dp.getStartRecord());
		user.setEnd(dp.getEndRecord());

		List<User> listUser = this.userDao.listAll(user);
		dp.addAll(listUser);
		return dp;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void addUser(User user) {
		this.userDao.insert(user);
	}

}
