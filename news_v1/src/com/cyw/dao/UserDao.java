package com.cyw.dao;

import com.cyw.model.User;

import java.util.ArrayList;

/**
 * @author cyw
 * @Date 2019/5/13 17:33
 * @Package_Name: com.cyw.Servlet
 * @Description：
 */
public interface UserDao{
    /**
     * 添加用户
     * @param user
     * @return
     */
    public int userAdd(User user);

    /**
     * 查询用户
     * @param username
     * @return
     */
    public User userSelect(String username);
    public User userSelect(int user_id);

    /**
     * 查询所有用户
     * @return
     */
    public ArrayList<User> userSelectAll();

    /**
     * 查询指定id用户详细信息
     * @param id
     * @return
     */
    public User userDetailesSelect(int id);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public int userUpdate(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    public int userDelete(User user);

    /**
     * 同时删除多个
     * @param id_list
     * @return
     */
    public int userDelete(ArrayList<Integer> id_list);
}
