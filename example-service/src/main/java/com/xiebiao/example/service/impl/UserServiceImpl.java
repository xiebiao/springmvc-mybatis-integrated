package com.xiebiao.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiebiao.common.util.DataPage;
import com.xiebiao.example.dao.UserDao;
import com.xiebiao.example.domain.User;
import com.xiebiao.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	private final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(this
			.getClass());

	public DataPage<User> listAll(User user, int pageIndex, int pageSize) {

		int count = this.userDao.countForObject(user);

		LOG.error("................pageIndex" + pageIndex + " pageSize:"
				+ pageSize);
		DataPage<User> dp = new DataPage<User>(count, pageIndex, pageSize);
		user.setStart(dp.getStartRecord());
		user.setRows(dp.getEndRecord());
		dp.addAll(this.userDao.listForObject(user));
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
