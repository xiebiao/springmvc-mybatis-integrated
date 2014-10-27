package com.xiebiao.example.dao;

import java.util.List;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mongodb.MongoClient;

/**
 * @author xiebiao
 * @date 8/26/14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-config-mongodb-test.xml")
public class MongoUserDaoTest extends TestCase {
  @Resource
  private MongoClient mongoClient;


  @Test
  public void test() {
    List<String> names = mongoClient.getDatabaseNames();
    for (String name : names) {
      System.out.println(name);
    }
  }

  @Test
  public void test_1() {
      mongoClient.getDB("xx").getCollection("");
  }
}
