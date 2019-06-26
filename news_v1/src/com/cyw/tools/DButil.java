package com.xqx.tools;

import java.sql.*;

import config.DBConfig;

/**
 * @author xqx
 * @Date 2019/5/13 21:26
 * @Package_Name: tools
 * @Description：
 */
public class DButil extends DBConfig {
    Connection conn=null;
    // 创建静态代码块 加载数据库驱动类
    static {
        try {
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            System.out.println("找不到驱动类！");
        }
    }

    /**
     * 获取数据库连接
     * @return Connection
     */
    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
            System.out.println("数据库连接成功！");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     * @param rs
     * @param ps
     * @param conn
     */
    public void close(ResultSet rs, PreparedStatement ps, Connection conn){
        try {
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(conn !=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试数据库连接是否成功
     * @param args
     */
    public static void main(String[] args) {
        new DButil().getConnection();
    }

}
