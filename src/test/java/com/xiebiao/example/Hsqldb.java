package com.xiebiao.example;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.hsqldb.Server;

public class Hsqldb {

    private String databaseName = "abator";
    private Server hsqldb;

    public Hsqldb(String databaseName) {
        this.databaseName = databaseName;
        hsqldb = new Server();
        hsqldb.setDatabaseName(0, databaseName);
        hsqldb.setDatabasePath(0, System.getProperty("user.dir") + File.separator + "target" + File.separator
                + databaseName);
        // hsqldb.setSilent(true);
        // hsqldb.setTrace(true);
        // hsqldb.setProperties(props)
        hsqldb.start();
        createTables();
    }

    private void createTables() {
        try {
            InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("script/test.sql");
            StringBuffer sb = new StringBuffer();
            byte[] b = new byte[1024];
            while (input.read(b) != -1) {
                sb.append(new String(b));
            }
            Connection conn = this.getConnection();
            Statement stat = conn.createStatement();
            String sql = sb.toString().replaceAll("\n", "").trim();
            System.out.println(sql);
            stat.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        hsqldb.shutdown();
    }

    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:" + databaseName, "sa", "");
        if (conn != null) {
            return conn;
        }
        throw new RuntimeException("");
    }

    public static final void main(String args[]) {
        Hsqldb db = new Hsqldb("test");
        // try {
        // Connection conn = db.getConnection();
        // Statement stat = conn.createStatement();
        // // 新建数据表
        // stat.executeUpdate("create table push(id integer,map VARCHAR(5120) )");
        // // 插入数据
        // String sql = "INSERT INTO push VALUES(1,'map')";
        // stat.executeUpdate(sql);
        // System.out.println("Insert OK!");
        // // 查询数据
        // PreparedStatement pstmt =
        // conn.prepareStatement("SELECT * FROM push");
        // ResultSet rs = pstmt.executeQuery();
        // while (rs.next()) {
        // String s = null;
        // s = rs.getString(1) + " : " + rs.getString(2);
        // System.out.println(s);
        // }
        // } catch (SQLException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // } finally {
        // db.shutdown();
        // }

    }
}
