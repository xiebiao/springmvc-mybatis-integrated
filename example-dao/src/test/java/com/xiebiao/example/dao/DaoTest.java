package com.xiebiao.example.dao;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiebiao.example.domain.User;
import com.xiebiao.example.jpa.impl.UserDaoImpl;

public class DaoTest extends TestCase {
	private final int userId = 1;
	private final String userName = "xiaog";
	private ApplicationContext ac;
	private final String beanName = "userDao";

	public void setUp() {
		ac = new ClassPathXmlApplicationContext("application-dao-test.xml");
		ac.getBean("userDao");
	}

	@Test
	public void test_insert() {
		UserDaoImpl ud = (UserDaoImpl) ac.getBean(beanName);
		Assert.assertNotNull(ud);
		if (ud.getUser(userId) != null) {
			ud.delete(String.valueOf(userId));
		}
		User u = new User();
		u.setUserName(userName);
		u.setAge(10);
		u.setUserId(userId);
		String key = ud.insert(u);
		Assert.assertNotNull(key);
	}

}
