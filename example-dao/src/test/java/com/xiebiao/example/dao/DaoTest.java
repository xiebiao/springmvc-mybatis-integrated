package com.xiebiao.example.dao;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiebiao.example.dao.impl.UserDaoImpl;
import com.xiebiao.example.domain.User;

public class DaoTest extends TestCase {
	private final int userId = 1;
	private final String userName = "xiaog";
	private ApplicationContext ac;
	private final String beanName = "userDao";

	public void setUp() {
		ac = new ClassPathXmlApplicationContext("application-dao-test.xml",
				"application-dao.xml");

	}

	public void test_UserDao_insert() {
		UserDaoImpl ud = (UserDaoImpl) ac.getBean(beanName);
		Assert.assertNotNull(ud);
		if (ud.getUser(userId) != null) {
			ud.delete(String.valueOf(userId));
		}
		User u = new User();
		u.setUserName(userName);
		u.setAge(10);
		u.setUserId(userId);
		int success = ud.insert(String.valueOf(u));
		
	}

	public void test_UserDao_getUser() {
		UserDaoImpl ud = (UserDaoImpl) ac.getBean(beanName);
		Assert.assertNotNull(ud);
		User user = ud.getUser(userId);
		Assert.assertNotNull(user);
	}

	public void test_UserDao_delete() {
		UserDaoImpl ud = (UserDaoImpl) ac.getBean(beanName);
		Assert.assertNotNull(ud);
		int c = ud.delete(String.valueOf(userId));
		Assert.assertEquals(1, c);
	}
}
