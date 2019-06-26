package com.xqx.dao.impl;

import com.xqx.dao.UserDao;
import com.xqx.model.User;
import com.xqx.tools.DButil;
import config.UserSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author xqx
 * @Date 2019/5/13 20:51
 * @Package_Name: impl
 * @Description：
 */
public class UserDaoImpl extends UserSQL implements UserDao{
    DButil db = new DButil();

    public UserDaoImpl() {
    }

    @Override
    public int userAdd(User user) {
        //获取数据库连接 题
        Connection connection = db.getConnection();
        //定义用户表插入用户信息sql语句
//        String sql = "INSERT INTO `news`.`user` (username, password) VALUES ( ?, ?)";
        //创建sql载体
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(USER_ADD);
            //SQL参数赋值
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            //执行SQL语句
            int rows = ps.executeUpdate();
            if (rows == 1) {
                ps.close();
                int user_id = userSelect(user.getUsername()).getUser_id();
                // String sql_d = "INSERT INTO `news`.`user_details` (user_details_id, username, phone, email) VALUES (?, ?, ?, ?)";
                ps = connection.prepareStatement(USER_ADD_D);
                ps.setInt(1, user_id);
                ps.setString(2, user.getUsername());
                ps.setString(3, user.getPhone());
                ps.setString(4, user.getEmail());
                int rows_d = ps.executeUpdate();
                db.close(null, ps, connection);
                if (rows_d == 1)
                    return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getErrorCode();
        }
        return 0;
    }

    @Override
    public User userSelect(String username) {
        User user = new User(0, "0", "0");
        ResultSet rs = null;
        Connection connection = db.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(USER_SELECT_NAME);
            ps.setString(1, username);
            rs = ps.executeQuery();
            //System.out.println("rows:"+rs.getRow());
            if (rs.next()) {
                System.out.println(rs.getInt(1));
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
            System.out.println(11111111);
            db.close(rs, ps, connection);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        System.out.println(user);
        System.out.println(3333);
        return user;
    }

    public User userSelect(int user_id) {
        User user = new User(0, "0", "0");
        ResultSet rs = null;
        Connection connection = db.getConnection();
//        String sql = "select user_id, username, password from user where username = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(USER_SELECT_ID);
            ps.setInt(1, user_id);
            rs = ps.executeQuery();
            //System.out.println("rows:"+rs.getRow());
            if (rs.next()) {
                System.out.println(rs.getInt(1));
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            System.out.println(11111111);
            db.close(rs, ps, connection);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        System.out.println(user);
        System.out.println(3333);
        return user;
    }

    @Override
    public User userDetailesSelect(int id) {
        User user = null;
        ResultSet rs = null;
        Connection connection = db.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(USER_DETAILES_SELECT);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            //System.out.println("rows:"+rs.getRow());
            if (rs.next()) {
                System.out.println(rs.getInt(1));
                if (user == null) {
                    user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                    System.out.println("密码查询成功 DAO");
                }
            } else {
                user = new User(1, "0", "0");
            }
            db.close(rs, ps, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int userUpdate(User user) {
        return 0;
    }

    @Override
    public int userDelete(User user) {
        return 0;
    }

    @Override
    public ArrayList<User> userSelectAll() {
        return null;
    }

    @Override
    public int userDelete(ArrayList<Integer> id_list) {
        return 0;
    }
}
