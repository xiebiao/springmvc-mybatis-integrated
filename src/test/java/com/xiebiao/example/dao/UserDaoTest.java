package com.xiebiao.example.dao;

import org.junit.Test;

import com.github.example.domain.User;
import com.xiebiao.example.BaseTest;

public class UserDaoTest extends BaseTest {

    @Test
    public void test() {
        User user = new User();
        user.setUserId(1);
        String userId = "1";
        this.sql.selectOne("find", user);
        
    }
}
