package com.cyw.tools;

import java.sql.*;

import config.DBConfig;

/**
 * @author cyw
 * @Date 2019/5/13 21:26
 * @Package_Name: tools
 * @Description��
 */
public class DButil extends DBConfig {
    Connection conn=null;
    static {
    System.out.println(USER);
        try {
//            Class.forName(driver);
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            System.out.println("�Ҳ��������࣡");
        }
    }
    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
            System.out.println("���ݿ����ӳɹ���");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }

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

    public static void main(String[] args) {
        new DButil().getConnection();
    }

}
