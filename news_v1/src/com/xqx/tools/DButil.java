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
//    private static String driver = "com.mysql.cj.jdbc.Driver";
//    private static String dburl = "jdbc:mysql://47.106.141.114:3306/news?useSSL=true&serverTimezone=GMT";
//    private static String user = "xqx";
//    private static String password = "19980510";
    Connection conn=null;
//    private static String driver;
//    private static String dburl;
//    private static String user;
//    private static String password;
//
//
//
//    static {
//        //用来保存属性文件中的键值对
//            Properties prop = new Properties();
//            FileReader fr = null;
//        InputStream in = DButil.class.getResourceAsStream("");
//            try {
//                //fr = new FileReader("C:\\Users\\ASDS\\Desktop\\class1.txt");
////                fr = new FileReader("dbconfig.properties");
//                prop.load(fr); //从dbconfig.properties文件中获取键值对
//                fr.close();
//            } catch (Exception e) {
//                System.out.println("=======配置文件读取错误=======");
//            }
//
//        //将所读取到的值赋值给成员变量
//        driver=prop.getProperty("driver");
//        dburl=prop.getProperty("dburl");
//        user=prop.getProperty("user");
//        password=prop.getProperty("password");
//        System.out.println(driver);
    static {
    System.out.println(USER);
        try {
//            Class.forName(driver);
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            System.out.println("找不到驱动类！");
        }
    }
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
