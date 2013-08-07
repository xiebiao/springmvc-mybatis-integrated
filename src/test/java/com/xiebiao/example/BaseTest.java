package com.xiebiao.example;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

public class BaseTest extends TestCase {

    protected Hsqldb     db;
    protected SqlSession sql;

    @Before
    public void setUp() {
        db = new Hsqldb("test");
        
        
        String resource = "mybatis/SqlMapConfig.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();

        }
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
        sql = sf.openSession();
    }
}
